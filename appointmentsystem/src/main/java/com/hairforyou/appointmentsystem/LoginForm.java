package com.hairforyou.appointmentsystem;

import javax.swing.JOptionPane;
/**
 *
 * @author lambe
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        buttonHover();
        centerPanel();
    }

    // Data storage
    private ArrayList<User> users = new ArrayList<>();
    private final String FILENAME = "users.txt";


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        hairForYouWhiteIconLabel = new javax.swing.JLabel();
        hairForYouLabel = new javax.swing.JLabel();
        instagramLabel = new javax.swing.JLabel();
        telephoneButton = new javax.swing.JButton();
        whatsappButton = new javax.swing.JButton();
        instagramButton = new javax.swing.JButton();
        gmailButton = new javax.swing.JButton();
        sloganLabel = new javax.swing.JLabel();
        contactUsLabel = new javax.swing.JLabel();
        gmailLabel = new javax.swing.JLabel();
        whatsappNumberLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        nextTabButton = new javax.swing.JButton();
        backgroundImageLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        hairForYouBlackIconLabel = new javax.swing.JLabel();
        welcomeBackLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        signInLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        forgotPasswordButton = new javax.swing.JButton();
        newUserButton = new javax.swing.JButton();
        prevTabButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(410, 530));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hairForYouWhiteIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/hair-for-you-inverted.png"))); // NOI18N
        jPanel2.add(hairForYouWhiteIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 100, 120));

        hairForYouLabel.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        hairForYouLabel.setForeground(new java.awt.Color(255, 255, 255));
        hairForYouLabel.setText("Hair For You");
        jPanel2.add(hairForYouLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        instagramLabel.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        instagramLabel.setForeground(new java.awt.Color(255, 255, 255));
        instagramLabel.setText("@hairforyou");
        jPanel2.add(instagramLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        telephoneButton.setBackground(new java.awt.Color(102, 102, 102));
        telephoneButton.setForeground(new java.awt.Color(255, 255, 255));
        telephoneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/telephone-logo.png"))); // NOI18N
        telephoneButton.setBorderPainted(false);
        telephoneButton.setContentAreaFilled(false);
        jPanel2.add(telephoneButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 40, -1));

        whatsappButton.setBackground(new java.awt.Color(102, 102, 102));
        whatsappButton.setForeground(new java.awt.Color(255, 255, 255));
        whatsappButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/whatsapp-logo.png"))); // NOI18N
        whatsappButton.setBorderPainted(false);
        whatsappButton.setContentAreaFilled(false);
        jPanel2.add(whatsappButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 40, -1));

        instagramButton.setBackground(new java.awt.Color(102, 102, 102));
        instagramButton.setForeground(new java.awt.Color(255, 255, 255));
        instagramButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/instagram-logo.png"))); // NOI18N
        instagramButton.setBorderPainted(false);
        instagramButton.setContentAreaFilled(false);
        jPanel2.add(instagramButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 40, -1));

        gmailButton.setBackground(new java.awt.Color(102, 102, 102));
        gmailButton.setForeground(new java.awt.Color(255, 255, 255));
        gmailButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/gmail-logo.png"))); // NOI18N
        gmailButton.setBorderPainted(false);
        gmailButton.setContentAreaFilled(false);
        jPanel2.add(gmailButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 40, -1));

        sloganLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        sloganLabel.setForeground(new java.awt.Color(255, 255, 255));
        sloganLabel.setText("Beautiful Hair Begins Here");
        jPanel2.add(sloganLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        contactUsLabel.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        contactUsLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactUsLabel.setText("Contact us:");
        jPanel2.add(contactUsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        gmailLabel.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        gmailLabel.setForeground(new java.awt.Color(255, 255, 255));
        gmailLabel.setText("hairforyou@gmail.com");
        jPanel2.add(gmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));

        whatsappNumberLabel.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        whatsappNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        whatsappNumberLabel.setText("+1(876) 316-6434");
        jPanel2.add(whatsappNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        phoneNumberLabel.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        phoneNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        phoneNumberLabel.setText("+1(876) 316-6434");
        jPanel2.add(phoneNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        nextTabButton.setForeground(new java.awt.Color(255, 255, 255));
        nextTabButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/white-right-arrow.png"))); // NOI18N
        nextTabButton.setBorderPainted(false);
        nextTabButton.setContentAreaFilled(false);
        nextTabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTabButtonActionPerformed(evt);
            }
        });
        jPanel2.add(nextTabButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, -1, -1));

        backgroundImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/hair-for-you-interior.png"))); // NOI18N
        backgroundImageLabel.setText("jLabel12");
        jPanel2.add(backgroundImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 650));

        jPanel1.add(jPanel2);

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setMinimumSize(new java.awt.Dimension(385, 450));
        jPanel3.setPreferredSize(new java.awt.Dimension(385, 450));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hairForYouBlackIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/hair-for-you-logo.png"))); // NOI18N
        jPanel3.add(hairForYouBlackIconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 70));

        welcomeBackLabel.setBackground(new java.awt.Color(0, 102, 204));
        welcomeBackLabel.setFont(new java.awt.Font("Perpetua", 0, 30)); // NOI18N
        welcomeBackLabel.setText("WELCOME BACK,");
        welcomeBackLabel.setToolTipText("1");
        jPanel3.add(welcomeBackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        passwordLabel.setText("Password:");
        jPanel3.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        signInLabel.setBackground(new java.awt.Color(204, 255, 255));
        signInLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        signInLabel.setText("Sign in to Continue");
        jPanel3.add(signInLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        usernameField.setBackground(new java.awt.Color(204, 204, 204));
        usernameField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        usernameField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        jPanel3.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 307, 320, -1));

        loginButton.setBackground(new java.awt.Color(51, 102, 255));
        loginButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(204, 204, 204));
        loginButton.setText("Login");
        loginButton.setBorderPainted(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel3.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 320, 40));

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        usernameLabel.setText("Username:");
        jPanel3.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        forgotPasswordButton.setBackground(new java.awt.Color(255, 0, 0));
        forgotPasswordButton.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        forgotPasswordButton.setForeground(new java.awt.Color(255, 255, 255));
        forgotPasswordButton.setText("Forgot password?");
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPasswordButtonActionPerformed(evt);
            }
        });
        jPanel3.add(forgotPasswordButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, 30));

        newUserButton.setBackground(new java.awt.Color(0, 255, 0));
        newUserButton.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        newUserButton.setText("New user?");
        newUserButton.setBorderPainted(false);
        newUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserButtonActionPerformed(evt);
            }
        });
        jPanel3.add(newUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, -1, 30));

        prevTabButton.setBackground(new java.awt.Color(204, 204, 204));
        prevTabButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hairforyou/appointmentsystem/images/left-arrow.png"))); // NOI18N
        prevTabButton.setBorderPainted(false);
        prevTabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevTabButtonActionPerformed(evt);
            }
        });
        jPanel3.add(prevTabButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, -1, 60));

        passwordField.setBackground(new java.awt.Color(204, 204, 204));
        passwordField.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        passwordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 51, 255)));
        jPanel3.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 320, -1));

        jTabbedPane1.addTab("tab2", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -34, 410, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    public User findUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; // user not found
    }

    public void buttonHover() {
        telephoneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                telephoneButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                telephoneButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        whatsappButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                whatsappButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                whatsappButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        instagramButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                instagramButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                instagramButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        gmailButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gmailButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gmailButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        nextTabButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextTabButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextTabButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        forgotPasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotPasswordButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotPasswordButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        newUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newUserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newUserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        prevTabButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                prevTabButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prevTabButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });
    }

    /*private String getPasswordFromPasswordField(JPasswordField passwordField) {
        char[] passwordChars = passwordField.getPassword();
        return new String(passwordChars);
    }
    */

    private void nextTabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTabButtonActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_nextTabButtonActionPerformed

    private void forgotPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");
        User user = findUser(username, password);
        if (user == null) {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
        } else {
            String answer = JOptionPane.showInputDialog(user.getSecurityQuestion());
            if (answer == null || !answer.equals(user.getSecurityAnswer())) {
                JOptionPane.showMessageDialog(null, "Incorrect answer to security question.");
            } else {
                JOptionPane.showMessageDialog(null, "Your password is: " + user.getPassword());
            }
        }
    }

    private void newUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new UserManager();
    }

    private void prevTabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevTabButtonActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_prevTabButtonActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed

    }//GEN-LAST:event_usernameFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        User user = findUser(username, password);
        if (user == null) {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
        } else {
            JOptionPane.showMessageDialog(null, "Welcome back, " + user.getFirstName() + "!");
            // Proceed to main application
            // ...
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundImageLabel;
    private javax.swing.JLabel contactUsLabel;
    private javax.swing.JButton forgotPasswordButton;
    private javax.swing.JButton gmailButton;
    private javax.swing.JLabel gmailLabel;
    private javax.swing.JLabel hairForYouBlackIconLabel;
    private javax.swing.JLabel hairForYouLabel;
    private javax.swing.JLabel hairForYouWhiteIconLabel;
    private javax.swing.JButton instagramButton;
    private javax.swing.JLabel instagramLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton newUserButton;
    private javax.swing.JButton nextTabButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JButton prevTabButton;
    private javax.swing.JLabel signInLabel;
    private javax.swing.JLabel sloganLabel;
    private javax.swing.JButton telephoneButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel welcomeBackLabel;
    private javax.swing.JButton whatsappButton;
    private javax.swing.JLabel whatsappNumberLabel;
    // End of variables declaration//GEN-END:variables
}
