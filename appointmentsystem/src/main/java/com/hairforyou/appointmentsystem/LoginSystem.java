package com.hairforyou.appointmentsystem;

/**
 *
 * @author lambe
 */
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.Base64;

public class LoginSystem implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel usernameLabel, passwordLabel, messageLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;

    private DatabaseManager databaseManager;

    private static final String DB_URL = "jdbc:sqlite:logins.db";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS users (username TEXT PRIMARY KEY, password TEXT, salt TEXT)";

    public class DatabaseManager {
        private Connection connection;
    
        public DatabaseManager(String url) throws SQLException {
            this.connection = DriverManager.getConnection(url);
        }
    
        public Connection getConnection() {
            return connection;
        }
    
        public void close() throws SQLException {
            connection.close();
        }
    }
    

    public LoginSystem() {
        frame = new JFrame();
        panel = new JPanel();
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        messageLabel = new JLabel("");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(300, 200));

        usernameLabel.setBounds(50, 30, 75, 25);
        passwordLabel.setBounds(50, 70, 75, 25);

        messageLabel.setBounds(75, 110, 200, 25);
        messageLabel.setFont(new Font(null, Font.BOLD, 14));

        usernameField.setBounds(125, 30, 150, 25);
        passwordField.setBounds(125, 70, 150, 25);

        loginButton.setBounds(50, 150, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        registerButton.setBounds(175, 150, 100, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(messageLabel);
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login System");
        frame.pack();
        frame.setVisible(true);

        try {
            databaseManager = new DatabaseManager(DB_URL);
            Statement statement = databaseManager.getConnection().createStatement();
            statement.executeUpdate(CREATE_TABLE_SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                String sql = "SELECT * FROM users WHERE username=?";
                PreparedStatement preparedStatement = databaseManager.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String hashedPassword = resultSet.getString("password");
                    String salt = resultSet.getString("salt");
                    if (validatePassword(password, hashedPassword, salt)) {
                        messageLabel.setText("Login successful!");
                    } else {
                        messageLabel.setText("Invalid password!");
                    }
                } else {
                    messageLabel.setText("User not found!");
                }
            } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == registerButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                String sql = "SELECT * FROM users WHERE username=?";
                PreparedStatement preparedStatement = databaseManager.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    messageLabel.setText("User already exists!");
                } else {
                    String salt = generateSalt();
                    String hashedPassword = generatePasswordHash(password, salt);

                    sql = "INSERT INTO users (username, password, salt) VALUES (?, ?, ?)";
                    preparedStatement = databaseManager.getConnection().prepareStatement(sql);
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, hashedPassword);
                    preparedStatement.setString(3, salt);
                    preparedStatement.executeUpdate();

                    messageLabel.setText("Registration successful!");
                }
            } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String generatePasswordHash(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 10000, 128);
        SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    private boolean validatePassword(String password, String hashedPassword, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String generatedHash = generatePasswordHash(password, salt);
        return hashedPassword.equals(generatedHash);
    }
}
