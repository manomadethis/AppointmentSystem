package com.hairforyou.appointmentsystem;

/**
 *
 * @author manoklm
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class AddAppointmentDialog extends JDialog {

    private JTextField idField;
    private JTextField nameField;
    private JTextField numberField;
    private JTextField addressField;
    private JButton okButton;
    private JButton cancelButton;

    private Appointment appointment;

    public static ArrayList<User> users = new ArrayList<>();

    public AddAppointmentDialog(JFrame parent, AppointmentDao appointmentDao) {
        super(parent, "Add Appointment", true);
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

            // Create a new combo box for selecting clients
            JComboBox<String> clientComboBox = new JComboBox<>();

            // Populate the combo box with clients
            try {
                // Open the users.txt file and read each line
                BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
                String line = reader.readLine();

                while (line != null) {
                    // Split the line into fields
                    String[] fields = line.split(" ");

                    // Add Users of type client
                if (fields[0].equals("client")) {
                    Client client = new Client("client", fields[1], fields[2], fields[3], fields[4], fields[5], null,
                    null, fields[8], fields[9], fields[10]);
                    String fullName = client.getFirstName() + " " + client.getLastName();
                    users.add(client);
                    clientComboBox.addItem(fullName);
                }

                    // Read the next line
                    line = reader.readLine();
                }

                // Close the reader
                reader.close();
            } catch (IOException ex) {
                // Handle the exception
            }

            // Show the combo box in a dialog box
            int result = JOptionPane.showConfirmDialog(null, clientComboBox, "Select an existing client", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            // Get the selected client from the combo box
            int selectedIndex = clientComboBox.getSelectedIndex();
            Client selectedClient = (Client) users.get(selectedIndex);

            // Set the client's data to the relevant fields in the appointment dialog
            nameField.setText(selectedClient.getFirstName() + " " + selectedClient.getLastName());

            numberField.setText(selectedClient.getPhoneNumber());

            String address = selectedClient.getAddress().replaceAll("-", " ");
            addressField.setText(address);


            // Set the ID field to a randomly generated number between 1000000 and 1009999
            Random random = new Random();
            int id = random.nextInt(100000, 100000);
            idField.setText("100" + String.valueOf(id));

        // Check if the user clicked OK
        if (result == JOptionPane.OK_OPTION) {
            // Create the OK and Cancel buttons
            okButton = new JButton("OK");
            cancelButton = new JButton("Cancel");

            okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    // Create a new appointment object and add it to the database
                    appointment = new Appointment(
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        numberField.getText(),
                        addressField.getText(),
                        new SimpleDateFormat("yyyy-MM-dd").format(dateField.getCalendar().getTime()),
                        new SimpleDateFormat("hh:mm a").format((Date) timeSpinner.getValue())
                    );

                    boolean success = appointmentDao.addAppointment(appointment);
                    if (success) {
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(AddAppointmentDialog.this,
                                "Unable to add appointment.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            // Add an ActionListener to the Cancel button
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    appointment = null;
                    dispose();
                }
            });

            // Add the OK and Cancel buttons to the panel
            constraints.gridx = 0;
            constraints.gridy = 6;
            panel.add(okButton, constraints);

            constraints.gridx = 1;
            panel.add(cancelButton, constraints);
        }

        setContentPane(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    public Appointment getAppointment() {
        return appointment;
    }
}
