package com.hairforyou.appointmentsystem;

public class Client extends User {
    public Client(String userType, String firstName, String lastName, String sex, String emailAddress, String phoneNumber, String username, String password,
    String securityAnswer, String address) {
        super("client", firstName, lastName, username, password, securityAnswer, null,
        null, phoneNumber, sex, address);
    }
}