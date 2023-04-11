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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

        // JComboBox for selecting time slot
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
                    null, fields[8], fields[9], fields[10], null);
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
            if (selectedClient.getId() == null) {
                Random random = new Random();
                int id = random.nextInt(100000, 1000000);
                idField.setText("100" + String.valueOf(id));
                selectedClient.setId(id);

                // Update the users file with the id
                try {
                    // Read the contents of the "users.txt" file into a list of strings
                    List<String> lines = Files.readAllLines(Paths.get("users.txt"));
                    // Loop through the list and find the line that contains the client's information
                    for (int i = 0; i < lines.size(); i++) {
                        String line = lines.get(i);
                        if (line.contains(selectedClient.getUsername())) {
                            // Split the line into an array of strings
                            String[] fields = line.split("\\s+");
                            fields[11] = "100" + String.valueOf(id);
                            // Join the array back into a string and update the line in the list
                            String updatedLine = String.join(" ", fields);
                            lines.set(i, updatedLine);
                            // Write the updated list of strings back to the "users.txt" file
                            Files.write(Paths.get("users.txt"), lines);
                            // Update the selected client's id
                            selectedClient.setId(id);
                            break;
                        }
                    }
                } catch (IOException e) {
                    // Handle the exception
                    e.printStackTrace();
                }
            }

            else {
                idField.setText(String.valueOf(selectedClient.getId()));
            }

        // Check if the user clicked OK
        if (result == JOptionPane.OK_OPTION) {
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

                    // Check if the appointment conflicts with any existing appointments
                    if (appointmentDao.hasConflict(appointment)) {
                        JOptionPane.showMessageDialog(AddAppointmentDialog.this,
                                "This appointment conflicts with an existing appointment.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Add the appointment to the database
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
