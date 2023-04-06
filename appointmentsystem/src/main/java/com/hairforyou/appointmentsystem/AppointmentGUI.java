package com.hairforyou.appointmentsystem;

/**
 *
 * @author manoklm
 */

import javax.swing.*;

import com.itextpdf.text.DocumentException;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class AppointmentGUI extends JFrame {

    // Instance variables
    private JLabel titleLabel;
    private JTable appointmentTable;
    private JScrollPane tableScrollPane;
    private JButton addButton;
    private JButton updateButton;
    private JButton removeButton;
    private JButton generateReportButton;

    private AppointmentDaoImpl appointmentDao;

    // Constructor
    public AppointmentGUI() {

        // Set the window properties
        setTitle("Hair For You Appointment Management System");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        appointmentDao = new AppointmentDaoImpl();

        // Get the appointment data from the database
        List<Appointment> appointments = null;
        appointments = appointmentDao.getAppointments();

        // Create the GUI components
        titleLabel = new JLabel("Appointments");
        appointmentTable = new JTable(new AppointmentTableModel(appointments));
        tableScrollPane = new JScrollPane(appointmentTable);
        addButton = new JButton("Add Appointment");
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateButton = new JButton("Update Appointment");
        updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeButton = new JButton("Remove Appointment");
        removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        generateReportButton = new JButton("Generate Report");
        generateReportButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Set the component properties
        titleLabel.setFont(new Font("Perpetua", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        appointmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        appointmentTable.setAutoCreateRowSorter(true);
        addButton.setPreferredSize(new Dimension(150, 30));
        updateButton.setPreferredSize(new Dimension(150, 30));
        removeButton.setPreferredSize(new Dimension(150, 30));
        generateReportButton.setPreferredSize(new Dimension(150, 30));

        // Create a new Color object with RGB values
        Color panelColor = new Color(204, 204, 204);

        // Set the background color of the panel
        getContentPane().setBackground(panelColor);
        appointmentTable.setBackground(panelColor);

        // Create the GUI layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(generateReportButton);

        // Set the background color of the panel
        buttonPanel.setBackground(panelColor);
        tableScrollPane.setBackground(panelColor);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listener for Add Appointment
        addButton.addActionListener(e -> {
            AddAppointmentDialog addAppointmentDialog = new AddAppointmentDialog(this, appointmentDao);
            addAppointmentDialog.setVisible(true);
            Appointment appointment = addAppointmentDialog.getAppointment();
            if (appointment != null) {
                ((AppointmentTableModel) appointmentTable.getModel()).addAppointment(appointment);
            }
        });

        // Action Listener for Update Appointment
        updateButton.addActionListener(e -> {
            int selectedRow = appointmentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select an appointment to update", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            Appointment appointment = ((AppointmentTableModel) appointmentTable.getModel()).getAppointmentAt(selectedRow);
            UpdateAppointmentDialog updateAppointmentDialog = new UpdateAppointmentDialog(this, appointmentDao, appointment);
            updateAppointmentDialog.setVisible(true);
            Appointment updatedAppointment = updateAppointmentDialog.getAppointment();
            if (updatedAppointment != null) {
                boolean success = appointmentDao.updateAppointment(updatedAppointment);
                if (success) {
                    ((AppointmentTableModel) appointmentTable.getModel()).updateAppointment(updatedAppointment, selectedRow);
                    //JOptionPane.showMessageDialog(this, "Appointment updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Could not update appointment.");
                }
            }
        });

        // Action Listener for Remove Appointment
        removeButton.addActionListener(e -> {
                int selectedRow = appointmentTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(this, "Please select an appointment to remove.");
                } else {
                    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this appointment?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        int appointmentId = (int) appointmentTable.getModel().getValueAt(selectedRow, 0);
                        AppointmentDao appointmentDao = new AppointmentDaoImpl();
                        if (appointmentDao.removeAppointment(appointmentId)) {
                            ((AppointmentTableModel) appointmentTable.getModel()).removeAppointment(selectedRow);
                            JOptionPane.showMessageDialog(this, "Appointment removed successfully.");
                        } else {
                            JOptionPane.showMessageDialog(this, "Error: Could not remove appointment.");
                        }
                    }
                }
        });

        // Action Listener for Remove Appointment
        generateReportButton.addActionListener(e -> {
            try {
                boolean fileSelected = appointmentDao.generateReport();
                if (fileSelected == true) {
                    JOptionPane.showMessageDialog(null, "Report generated successfully.");
                }
            } catch (IOException | DocumentException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to generate report: " + ex.getMessage());
            }
        });

    setVisible(true);

    }
}