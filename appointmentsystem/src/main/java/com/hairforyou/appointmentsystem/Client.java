package com.hairforyou.appointmentsystem;

public class Client extends User {
    public Client(String userType, String firstName, String lastName, String username, String password, String securityAnswer, String role, String emailAddress,
    String phoneNumber, String sex, String address) {
        super("client", firstName, lastName, username, password, securityAnswer, null,
        null, phoneNumber, sex, address);
    }
}

/*
admin  Joseph Joestar jojo  password Joe          marketing_director jojo@gmail.com 876-478-2550 null null
client Samuel Jackson sammy password Jacksonville null               null           876-256-2670 Male 34-Frank-Street
*/