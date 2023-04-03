package com.hairforyou.appointmentsystem;

public class Admin extends User {
    public Admin(String userType, String firstName, String lastName, String role, String emailAddress, String phoneNumber, String username, String password,
        String securityAnswer, String address) {
        super("admin", firstName, lastName, username, password, securityAnswer, role,
        emailAddress, phoneNumber, null, null);
    }
}