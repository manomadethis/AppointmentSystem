package com.hairforyou.appointmentsystem;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
/**
 *
 * @author manoklm
 */
public class ClientMenuGUI extends javax.swing.JFrame {

    AppointmentDao appointmentDao = new AppointmentDaoImpl();
    List<Appointment> appointments = AppointmentDaoImpl.getAppointments();

    /**
     * Creates new form AppointmentGUI2
     */
    public ClientMenuGUI() {
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of thi s method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeBackLabel = new javax.swing.JLabel();
        requestAppointmentButton = new javax.swing.JButton();
        signOutButton = new javax.swing.JButton();
        viewAppointmentButton = new javax.swing.JButton();
        hairForYouWhiteLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcomeBackLabel.setBackground(new java.awt.Color(0, 102, 204));
        welcomeBackLabel.setFont(new java.awt.Font("Perpetua", 0, 30)); // NOI18N
        welcomeBackLabel.setText("CLIENT MENU");
        welcomeBackLabel.setToolTipText("1");
        jPanel1.add(welcomeBackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        requestAppointmentButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        requestAppointmentButton.setBackground(new java.awt.Color(204, 204, 204));
        requestAppointmentButton.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        requestAppointmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/request-appointment.png"))); // NOI18N
        requestAppointmentButton.setBorderPainted(false);
        requestAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestAppointmentButtonActionPerformed(evt);
            }
        });
        jPanel1.add(requestAppointmentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 50, 30));

        signOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signOutButton.setBackground(new java.awt.Color(204, 204, 204));
        signOutButton.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        signOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/sign-out.png"))); // NOI18N
        signOutButton.setBorderPainted(false);
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(signOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 50, 50));

        viewAppointmentButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewAppointmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/view-appointment.png"))); // NOI18N
        viewAppointmentButton.setBorderPainted(false);
        viewAppointmentButton.setContentAreaFilled(false);
        viewAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAppointmentButtonActionPerformed(evt);
            }
        });
        jPanel1.add(viewAppointmentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, 50));

        hairForYouWhiteLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/hair-for-you-logo-small.png"))); // NOI18N
        jPanel1.add(hairForYouWhiteLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void requestAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new RequestAppointmentDialog(this, appointmentDao);
    }

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        LoginSystem login = new LoginSystem();
        login.setVisible(true);
    }

    private void viewAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Get the current user's name
        String currentUser = LoginSystem.currentUser.getFirstName() + " " + LoginSystem.currentUser.getLastName();
        // Search for appointments belonging to the current user
        ArrayList<Appointment> matchingAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getCustomerName().equals(currentUser)) {
                matchingAppointments.add(appointment);
            }
        }

        // If there are matching appointments, display them in a JOptionPane
        if (!matchingAppointments.isEmpty()) {
            StringBuilder message = new StringBuilder();
            for (Appointment appointment : matchingAppointments) {
                message.append("Appointment ID: ").append(appointment.getCustomerID())
                .append("\nDate: ").append(appointment.getDate())
                    .append("\nTime: ").append(appointment.getTime())
                    .append("\n\n");
            }
            JOptionPane.showMessageDialog(null, message.toString(), "Appointments for " + currentUser, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No appointments found for " + currentUser, "Error", JOptionPane.ERROR_MESSAGE);
        }

            }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hairForYouWhiteLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton requestAppointmentButton;
    private javax.swing.JButton signOutButton;
    private javax.swing.JButton viewAppointmentButton;
    private javax.swing.JLabel welcomeBackLabel;
    // End of variables declaration//GEN-END:variables
}
