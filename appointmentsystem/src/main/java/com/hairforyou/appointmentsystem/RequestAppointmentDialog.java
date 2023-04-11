package com.hairforyou.appointmentsystem;

/**
 *
 * @author manoklm
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.JDateChooser;

public class RequestAppointmentDialog extends JDialog {

    private JTextField idField;
    private JTextField nameField;
    private JTextField numberField;
    private JTextField addressField;
    private JButton okButton;
    private JButton cancelButton;

    private Appointment appointment;

    public static ArrayList<User> users = new ArrayList<>();

    public RequestAppointmentDialog(JFrame parent, AppointmentDao appointmentDao) {
        super(parent, "Request Appointment", true);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        //ID field
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("ID:"), constraints);

        constraints.gridx = 1;
        idField = new JTextField(20);
        idField.setEditable(false);
        panel.add(idField, constraints);

        // Name field
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Name:"), constraints);

        constraints.gridx = 1;
        nameField = new JTextField(20);
        panel.add(nameField, constraints);

        // Number field
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Number:"), constraints);

        constraints.gridx = 1;
        numberField = new JTextField(20);
        panel.add(numberField, constraints);

        // Address field
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Address:"), constraints);

        constraints.gridx = 1;
        addressField = new JTextField(20);
        panel.add(addressField, constraints);

        // Date Label
        JLabel dateLabel = new JLabel("Date");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(dateLabel, constraints);

        // Date Field with JCalendar
        JDateChooser dateField = new JDateChooser();
        dateField.setDateFormatString("yyyy-MM-dd");
        dateField.setDate(new Date());
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(dateField, constraints);

        // Time Label
        JLabel timeLabel = new JLabel("Time:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(timeLabel, constraints);

        // Time Field with JSpinner
        SpinnerDateModel spinnerTimeModel = new SpinnerDateModel();
        spinnerTimeModel.setCalendarField(Calendar.MINUTE);
        JSpinner timeSpinner = new JSpinner(spinnerTimeModel);
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "hh:mm a"));
        timeSpinner.setValue(new Date());
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(timeSpinner, constraints);

        // Set the client's data to the relevant fields in the appointment dialog
        nameField.setText(LoginSystem.currentUser.getFirstName() + " " + LoginSystem.currentUser.getLastName());
        numberField.setText(LoginSystem.currentUser.getPhoneNumber());
        String address = LoginSystem.currentUser.getAddress().replaceAll("-", " ");
        addressField.setText(address);

        // Set the ID field to the ID number from the users.txt file
        try {
            List<String> lines = Files.readAllLines(Paths.get("users.txt"));
            for (String line : lines) {
                String[] fields = line.split("\\s+");
                if (fields[0].equals("client") && fields[3].equals(LoginSystem.currentUser.getUsername())) {
                    Integer id = Integer.parseInt(fields[11]);
                    // set the ID field to the ID from the file
                    idField.setText(String.valueOf(id));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Create the OK and Cancel buttons
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new appointment object with input data
                appointment = new Appointment(
                    Integer.parseInt(idField.getText()),
                    nameField.getText(),
                    numberField.getText(),
                    addressField.getText(),
                    new SimpleDateFormat("yyyy-MM-dd").format(dateField.getCalendar().getTime()),
                    new SimpleDateFormat("hh:mm a").format((Date) timeSpinner.getValue())
                );

                // Check if the appointment conflicts with any existing appointment
                if(appointmentDao.hasConflict(appointment)) {
                    JOptionPane.showMessageDialog(RequestAppointmentDialog.this,
                        "This appointment conflicts with an existing appointment.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Set the appointment as a request
                boolean success = appointmentDao.requestAppointment(appointment);
                if (success) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RequestAppointmentDialog.this,
                            "Unable to add appointment.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add the OK and Cancel buttons to the panel
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(okButton, constraints);

        constraints.gridx = 1;
        panel.add(cancelButton, constraints);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public Appointment getAppointment() {
        return appointment;
    }
}
