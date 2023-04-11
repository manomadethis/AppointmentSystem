/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.hairforyou.appointmentsystem;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author lambe
 */
public class NewAdminGUI extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public NewAdminGUI() {
        initComponents();
        buttonHover();
        centerPanel();
        setVisible(true);
    }

    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        adminPanel = new javax.swing.JPanel();
        hairForYouWhiteLogo = new javax.swing.JLabel();
        newClientLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        addressLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        confirmPasswordLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        securityQuestionLabel = new javax.swing.JLabel();
        Role = new javax.swing.JLabel();
        usernameLabel1 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        securityQuestionField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        roleField = new javax.swing.JTextField();
        emailAddressField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        confirmPasswordField = new javax.swing.JPasswordField();
        usernameField = new javax.swing.JTextField();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/hair-for-you-interior.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminPanel.setBackground(new java.awt.Color(204, 204, 204));
        adminPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hairForYouWhiteLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/hair-for-you-logo-small.png"))); // NOI18N
        adminPanel.add(hairForYouWhiteLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 40));

        newClientLabel.setBackground(new java.awt.Color(255, 255, 255));
        newClientLabel.setFont(new java.awt.Font("Perpetua", 0, 21)); // NOI18N
        newClientLabel.setText("NEW ADMIN");
        adminPanel.add(newClientLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 130, 30));

        questionLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        questionLabel.setText("What was the name of your first pet?");
        adminPanel.add(questionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 320, 30));

        firstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firstNameLabel.setText("First Name:");
        adminPanel.add(firstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lastNameLabel.setText("Last Name:");
        adminPanel.add(lastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        passwordField.setBackground(new java.awt.Color(204, 204, 204));
        passwordField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        passwordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 51, 255)));
        adminPanel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 230, -1));

        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addressLabel.setText("Email address: ");
        adminPanel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        phoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phoneNumberLabel.setText("Phone number:");
        adminPanel.add(phoneNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordLabel.setText("Password:");
        adminPanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        confirmPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confirmPasswordLabel.setText("Confirm Password:");
        adminPanel.add(confirmPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        submitButton.setBackground(new java.awt.Color(51, 102, 255));
        submitButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.setBorderPainted(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        adminPanel.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 90, 30));

        securityQuestionLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        securityQuestionLabel.setText("Security Question:");
        adminPanel.add(securityQuestionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        Role.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Role.setText("Role:");
        adminPanel.add(Role, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        usernameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernameLabel1.setText("Username:");
        adminPanel.add(usernameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        cancelButton.setBackground(new java.awt.Color(255, 0, 0));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setBorderPainted(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        adminPanel.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 90, 30));

        securityQuestionField.setBackground(new java.awt.Color(204, 204, 204));
        securityQuestionField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        securityQuestionField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        securityQuestionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                securityQuestionFieldActionPerformed(evt);
            }
        });
        adminPanel.add(securityQuestionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 230, -1));

        firstNameField.setBackground(new java.awt.Color(204, 204, 204));
        firstNameField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        firstNameField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });
        adminPanel.add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 230, -1));

        lastNameField.setBackground(new java.awt.Color(204, 204, 204));
        lastNameField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lastNameField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });
        adminPanel.add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 230, -1));

        roleField.setBackground(new java.awt.Color(204, 204, 204));
        roleField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        roleField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        roleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleFieldActionPerformed(evt);
            }
        });
        adminPanel.add(roleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 230, -1));

        emailAddressField.setBackground(new java.awt.Color(204, 204, 204));
        emailAddressField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        emailAddressField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        emailAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailAddressFieldActionPerformed(evt);
            }
        });
        adminPanel.add(emailAddressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 210, -1));

        phoneNumberField.setBackground(new java.awt.Color(204, 204, 204));
        phoneNumberField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        phoneNumberField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        phoneNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberFieldActionPerformed(evt);
            }
        });
        adminPanel.add(phoneNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 200, -1));

        confirmPasswordField.setBackground(new java.awt.Color(204, 204, 204));
        confirmPasswordField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        confirmPasswordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 51, 255)));
        adminPanel.add(confirmPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 170, -1));

        usernameField.setBackground(new java.awt.Color(204, 204, 204));
        usernameField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        usernameField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        adminPanel.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 230, -1));

        getContentPane().add(adminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void buttonHover() {
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });
    /**
     * @param args the command line arguments
     */
    }

    public void centerPanel() {
        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculate the center position of the screen
        int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);

        // Set the position of the frame to the center of the screen
        setLocation(centerX, centerY);

        // Set the position of the frame to the center of the screen
        setLocation(centerX, centerY);
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String role = roleField.getText();
        String emailAddress = emailAddressField.getText();
        String phoneNumber = phoneNumberField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        String securityAnswer = securityQuestionField.getText();

        if (firstName.isEmpty() || lastName.isEmpty() || role.isEmpty() ||
            emailAddress.isEmpty() || phoneNumber.isEmpty() || username.isEmpty() ||
            password.length() == 0 || securityAnswer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Password and confirm password fields do not match.");
            return;
        }

        User admin = new Admin("admin", firstName, lastName, username, password, securityAnswer, role,
                                emailAddress, phoneNumber, null, null, null);
        LoginSystem.addUser(admin);
        JOptionPane.showMessageDialog(null, "Admin account created.");
        dispose();
    }


    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void securityQuestionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_securityQuestionFieldActionPerformed
        submitButtonActionPerformed(evt);
    }//GEN-LAST:event_securityQuestionFieldActionPerformed

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void roleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleFieldActionPerformed
    }//GEN-LAST:event_roleFieldActionPerformed

    private void emailAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailAddressFieldActionPerformed
    }//GEN-LAST:event_emailAddressFieldActionPerformed

    private void phoneNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberFieldActionPerformed
    }//GEN-LAST:event_phoneNumberFieldActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
    }//GEN-LAST:event_usernameFieldActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Role;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JTextField emailAddressField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel hairForYouWhiteLogo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel newClientLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JTextField roleField;
    private javax.swing.JTextField securityQuestionField;
    private javax.swing.JLabel securityQuestionLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel1;
    // End of variables declaration//GEN-END:variables
}
