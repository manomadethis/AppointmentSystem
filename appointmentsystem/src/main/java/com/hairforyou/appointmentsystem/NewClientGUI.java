package com.hairforyou.appointmentsystem;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

/**
 *
 * @author lambe
 */
public class NewClientGUI extends javax.swing.JFrame {

    /**
     * Creates new form Client
     */
    public NewClientGUI() {
        initComponents();
        centerPanel();
        buttonHover();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientPanel = new javax.swing.JPanel();
        hairForYouWhiteLogo = new javax.swing.JLabel();
        newClientLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        confirmPasswordLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        securityQuestionLabel1 = new javax.swing.JLabel();
        sexLabel1 = new javax.swing.JLabel();
        usernameLabel1 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        sexField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        confirmPasswordField = new javax.swing.JPasswordField();
        usernameField = new javax.swing.JTextField();
        securityQuestionField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clientPanel.setBackground(new java.awt.Color(204, 204, 204));
        clientPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hairForYouWhiteLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/hair-for-you-logo-small.png"))); // NOI18N
        clientPanel.add(hairForYouWhiteLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 40));

        newClientLabel.setBackground(new java.awt.Color(255, 255, 255));
        newClientLabel.setFont(new java.awt.Font("Perpetua", 0, 21)); // NOI18N
        newClientLabel.setText("NEW CLIENT");
        clientPanel.add(newClientLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 130, 30));

        questionLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        questionLabel.setText("In which town were you born?");
        clientPanel.add(questionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 320, 30));

        firstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firstNameLabel.setText("First Name:");
        clientPanel.add(firstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lastNameLabel.setText("Last Name:");
        clientPanel.add(lastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addressLabel.setText("Address:");
        clientPanel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        phoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phoneNumberLabel.setText("Phone number:");
        clientPanel.add(phoneNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordLabel.setText("Password:");
        clientPanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        confirmPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confirmPasswordLabel.setText("Confirm Password:");
        clientPanel.add(confirmPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        cancelButton.setBackground(new java.awt.Color(255, 0, 0));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setBorderPainted(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        clientPanel.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 90, 30));

        securityQuestionLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        securityQuestionLabel1.setText("Security Question:");
        clientPanel.add(securityQuestionLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        sexLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sexLabel1.setText("Sex:");
        clientPanel.add(sexLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        usernameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernameLabel1.setText("Username:");
        clientPanel.add(usernameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        submitButton.setBackground(new java.awt.Color(0, 255, 0));
        submitButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.setBorderPainted(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        clientPanel.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 90, 30));

        passwordField.setBackground(new java.awt.Color(204, 204, 204));
        passwordField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        passwordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 51, 255)));
        clientPanel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 230, -1));

        firstNameField.setBackground(new java.awt.Color(204, 204, 204));
        firstNameField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        firstNameField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });
        clientPanel.add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 230, -1));

        lastNameField.setBackground(new java.awt.Color(204, 204, 204));
        lastNameField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lastNameField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });
        clientPanel.add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 230, -1));

        sexField.setBackground(new java.awt.Color(204, 204, 204));
        sexField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        sexField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        sexField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexFieldActionPerformed(evt);
            }
        });
        clientPanel.add(sexField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 230, -1));

        addressField.setBackground(new java.awt.Color(204, 204, 204));
        addressField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        addressField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressFieldActionPerformed(evt);
            }
        });
        clientPanel.add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 210, -1));

        phoneNumberField.setBackground(new java.awt.Color(204, 204, 204));
        phoneNumberField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        phoneNumberField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        phoneNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberFieldActionPerformed(evt);
            }
        });
        clientPanel.add(phoneNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 200, -1));

        confirmPasswordField.setBackground(new java.awt.Color(204, 204, 204));
        confirmPasswordField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        confirmPasswordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 51, 255)));
        clientPanel.add(confirmPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 170, -1));

        usernameField.setBackground(new java.awt.Color(204, 204, 204));
        usernameField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        usernameField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        clientPanel.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 230, -1));

        securityQuestionField.setBackground(new java.awt.Color(204, 204, 204));
        securityQuestionField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        securityQuestionField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        securityQuestionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                securityQuestionFieldActionPerformed(evt);
            }
        });
        clientPanel.add(securityQuestionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 230, -1));

        getContentPane().add(clientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 560));

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

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String sex = sexField.getText();
        String address = addressField.getText();
        String modifiedAddress = address.replace(" ", "-");
        String phoneNumber = phoneNumberField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String securityAnswer = securityQuestionField.getText();

        if (firstName.isEmpty() || lastName.isEmpty() || sex.isEmpty() ||
        address.isEmpty() || phoneNumber.isEmpty() || username.isEmpty() ||
        password.length() == 0 || securityAnswer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.");
            return;
        }

        User client = new Client("client", firstName, lastName, username, password, securityAnswer, null,
        null, phoneNumber, sex, modifiedAddress, null);
        LoginSystem.addUser(client);
        JOptionPane.showMessageDialog(null, "Client account created.");
        dispose();

    }//GEN-LAST:event_submitButtonActionPerformed

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void sexFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexFieldActionPerformed
    }//GEN-LAST:event_sexFieldActionPerformed

    private void addressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressFieldActionPerformed
    }//GEN-LAST:event_addressFieldActionPerformed

    private void phoneNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberFieldActionPerformed
    }//GEN-LAST:event_phoneNumberFieldActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void securityQuestionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_securityQuestionFieldActionPerformed

    }//GEN-LAST:event_securityQuestionFieldActionPerformed

    /**
     * @param args the command line arguments
     */



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel clientPanel;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel hairForYouWhiteLogo;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel newClientLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JTextField securityQuestionField;
    private javax.swing.JLabel securityQuestionLabel1;
    private javax.swing.JTextField sexField;
    private javax.swing.JLabel sexLabel1;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel1;
    // End of variables declaration//GEN-END:variables
}