package com.hairforyou.appointmentsystem;

/**
 *
 * @author manoklm
 */

import javax.swing.*;

import com.toedter.calendar.JCalendar;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UpdateAppointmentDialog extends JDialog {

    private Appointment appointment;

    public UpdateAppointmentDialog(JFrame parent, AppointmentDao appointmentDao, Appointment appointment) {
        super(parent, "Update Appointment", true);
        this.appointment = appointment;

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Appointment ID Label
        JLabel idLabel = new JLabel("Appointment ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(idLabel, constraints);

        // Appointment ID Field
        JTextField idField = new JTextField(String.valueOf(appointment.getCustomerID()), 20);
        idField.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(idField, constraints);

        // Name Label
        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(nameLabel, constraints);

        // Name Field
        JTextField nameField = new JTextField(appointment.getCustomerName(), 20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(nameField, constraints);

        // Phone Number Label
        JLabel numberLabel = new JLabel("Phone Number:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(numberLabel, constraints);

        // Phone Number Field
        JTextField numberField = new JTextField(appointment.getCustomerNumber(), 20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(numberField, constraints);

        // Address Label
        JLabel addressLabel = new JLabel("Address:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(addressLabel, constraints);

        // Address Field
        JTextField addressField = new JTextField(appointment.getCustomerAddress(), 20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(addressField, constraints);

        // Date Label
        JLabel dateLabel = new JLabel("Date");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(dateLabel, constraints);

        // JCalendar for Date Field
        JCalendar calendar = new JCalendar();
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(calendar, constraints);

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

        // OK Button
        JButton okButton = new JButton("OK");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(okButton, constraints);

        // Cancel Button
        JButton cancelButton = new JButton("Cancel");
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(cancelButton, constraints);

        // Set the date on the JCalendar to the previously chosen date
        try {
            Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(appointment.getDate());
            calendar.setDate(selectedDate);
        } catch (ParseException ex) {
            // handle exception appropriately
        }

        // Set the time on the JSpinner to the previously chosen time
        try {
            Date selectedTime = new SimpleDateFormat("hh:mm a").parse(appointment.getTime());
            timeSpinner.setValue(selectedTime);
        } catch (ParseException ex) {
            // handle exception appropriately
        }

        // Action Listener for OK Button
        okButton.addActionListener(e -> {
            appointment.setCustomerName(nameField.getText());
            appointment.setCustomerNumber(numberField.getText());
            appointment.setCustomerAddress(addressField.getText());
            // Get the selected date from the JCalendar
            Date selectedDate = calendar.getDate();
            // Convert the date format to yyyy-MM-dd
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(selectedDate);

            appointment.setDate(formattedDate);
            // Get the selected time from the JSpinner
            Date selectedTime = (Date) timeSpinner.getValue();
            // Convert the time format to HH:MM:am/pm
            String formattedTime = new SimpleDateFormat("hh:mm a").format(selectedTime);
            appointment.setTime(formattedTime);

            dispose();
        });


        // Action Listener for Cancel Button
        cancelButton.addActionListener(e -> {
            dispose();
        });

        add(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    public Appointment getAppointment() {
        return appointment;
    }
}