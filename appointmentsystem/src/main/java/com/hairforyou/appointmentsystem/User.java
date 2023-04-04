package com.hairforyou.appointmentsystem;

import javax.swing.JPasswordField;

public class User {
    private String userType;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String securityAnswer;
    private String role; // for admins only
    private String emailAddress; // for admins only
    private String phoneNumber;
    private String sex;
    private String address;

    public User(String userType, String firstName, String lastName, String username, String password, String securityAnswer, String role, String emailAddress,
                String phoneNumber, String sex, String address) {
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.securityAnswer = securityAnswer;
        this.role = role;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.address = address;
    }

    // Getters and setters
    public String userType() {
        return userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public String getRole() {
        return role;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    String getPasswordFromPasswordField(JPasswordField passwordField) {
        char[] passwordChars = passwordField.getPassword();
        return new String(passwordChars);
    }

    String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return userType + " " + firstName + " " + lastName + " " + username + " " + password + " " + securityAnswer + " " + role + " " + emailAddress + " " + phoneNumber + " " + sex + " " + address;
    }


}