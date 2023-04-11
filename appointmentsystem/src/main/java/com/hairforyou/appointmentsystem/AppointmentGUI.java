package com.hairforyou.appointmentsystem;

/**
 *
 * @author manoklm
 */

import javax.swing.*;

import com.itextpdf.text.DocumentException;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class AppointmentGUI extends JFrame {

    // Instance variables
    private JLabel titleLabel;
    private JTable appointmentTable;
    private JScrollPane tableScrollPane;
    private JButton addButton;
    private JButton updateButton;
    private JButton removeButton;
    private JButton generateReportButton;
    private JButton manageRequestsButton;
    private JButton signOutButton;

    private AppointmentDaoImpl appointmentDao;
    public static ArrayList<Appointment> appointmentRequests = new ArrayList<>();

    // Constructor
    public AppointmentGUI() {

        // Set the window properties
        setTitle("Hair For You Appointment Management System");
        setSize(1000, 600);
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
        manageRequestsButton = new JButton("Manage Requests");
        manageRequestsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signOutButton = new JButton("Sign Out");
        signOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Set the component properties
        titleLabel.setFont(new Font("Perpetua", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        appointmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        appointmentTable.setAutoCreateRowSorter(true);
        addButton.setPreferredSize(new Dimension(150, 30));
        updateButton.setPreferredSize(new Dimension(150, 30));
        removeButton.setPreferredSize(new Dimension(150, 30));
        generateReportButton.setPreferredSize(new Dimension(150, 30));
        manageRequestsButton.setPreferredSize(new Dimension(150, 30));
        signOutButton.setPreferredSize(new Dimension(150, 30));

        // Create a new Color object with RGB values
        Color panelColor = new Color(204, 204, 204);

        // Create the GUI layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(panelColor);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(generateReportButton);
        buttonPanel.add(manageRequestsButton);
        buttonPanel.add(signOutButton);;

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

        // Action Listener for Manage Clients button
        manageRequestsButton.addActionListener(e -> {
            try {
                File file = new File("appointmentRequests.txt");
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(null, "There are no appointment requests.");
                    System.out.println("file not found");
                    return;
                }

                BufferedReader reader = new BufferedReader(new FileReader(file));
                List<Appointment> appointmentRequests = new ArrayList<>();
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    Appointment appointment = new Appointment(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5]);
                    appointmentRequests.add(appointment);
                }
                reader.close();

                if (appointmentRequests.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "There are no appointment requests.");
                } else {
                    String[] appointmentStrings = new String[appointmentRequests.size()];
                    for (int i = 0; i < appointmentRequests.size(); i++) {
                        Appointment appointment = appointmentRequests.get(i);
                        appointmentStrings[i] = appointment.getCustomerName() + " - " + appointment.getDate() + " - " + appointment.getTime();

                    }

                    String selectedAppointmentString = (String) JOptionPane.showInputDialog(null, "Choose an appointment to manage:",
                            "Manage Appointments", JOptionPane.QUESTION_MESSAGE, null, appointmentStrings, appointmentStrings[0]);

                        if (selectedAppointmentString != null) {
                            Appointment selectedAppointment = null;
                            for (Appointment appointment : appointmentRequests) {
                                String appointmentString = appointment.getCustomerName() + " - " + appointment.getDate() + " - " + appointment.getTime();
                                if (appointmentString.equals(selectedAppointmentString)) {
                                    selectedAppointment = appointment;
                                    break;
                                }
                            }

                        if (selectedAppointment != null) {
                            String[] options = {"Approve", "Deny"};
                            int choice = JOptionPane.showOptionDialog(null, selectedAppointment.toString(),
                                    "Manage Appointment", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                    options, options[0]);

                            if (choice == 0) {
                                appointmentDao.addAppointment(selectedAppointment);
                                ((AppointmentTableModel) appointmentTable.getModel()).addAppointment(selectedAppointment);
                                appointmentRequests.remove(selectedAppointment);
                                writeAppointmentRequestsToFile(appointmentRequests);
                                JOptionPane.showMessageDialog(null, "Appointment approved.");
                            } else if (choice == 1) {
                                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to deny this appointment?",
                                        "Confirm Denial", JOptionPane.YES_NO_OPTION);
                                if (confirm == JOptionPane.YES_OPTION) {
                                    appointmentRequests.remove(selectedAppointment);
                                    writeAppointmentRequestsToFile(appointmentRequests);
                                    JOptionPane.showMessageDialog(null, "Appointment denied.");
                                }
                            }
                        }
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error occurred while reading appointment requests from file.");
                ex.printStackTrace();
            }
        });


        signOutButton.addActionListener(e -> {
            this.dispose();
            LoginSystem login = new LoginSystem();
            login.setVisible(true);
        });

    setVisible(true);
    }

    private void writeAppointmentRequestsToFile(List<Appointment> appointmentRequests) {
        try {
            FileWriter writer = new FileWriter("appointmentRequests.txt");
            for (Appointment appointment : appointmentRequests) {
                writer.write(appointment.getCustomerID() + " " +
                        appointment.getCustomerName() + " " +
                        appointment.getCustomerNumber() + " " +
                        appointment.getCustomerAddress() + " " +
                        appointment.getDate() + " " +
                        appointment.getTime() + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while writing appointment requests to file.");
            ex.printStackTrace();
        }
    }
}