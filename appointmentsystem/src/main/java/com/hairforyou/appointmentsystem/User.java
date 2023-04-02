package com.hairforyou.appointmentsystem;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
    private String role; // for admins only
    private String emailAddress; // for admins only
    private String phoneNumber;
    private String sex;
    private String address;

    public User(String firstName, String lastName, String username, String password,
            String securityQuestion, String securityAnswer, String phoneNumber, String sex,
            String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.address = address;
    }

    // Constructor for admins
    public User(String firstName, String lastName, String username, String password,
            String securityQuestion, String securityAnswer, String role, String emailAddress,
            String phoneNumber, String sex, String address) {
        this(firstName, lastName, username, password, securityQuestion, securityAnswer,
                phoneNumber, sex, address);
        this.role = role;
        this.emailAddress = emailAddress;
    }

    // Getters and setters
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

    public String getSecurityQuestion() {
        return securityQuestion;
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

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
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
}
