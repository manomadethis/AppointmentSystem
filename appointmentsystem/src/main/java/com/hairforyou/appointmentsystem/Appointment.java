package com.hairforyou.appointmentsystem;

/**
 *
 * @author lambe
 */

public class Appointment {

    // Instance variables
    private int customerID;
    private String customerName;
    private String customerNumber;
    private String customerAddress;
    private String date;
    private String time;

    // Constructor
    public Appointment(int customerID, String customerName, String customerNumber, String customerAddress, String date, String time) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerAddress = customerAddress;
        this.date = date;
        this.time = time;
    }

    // Getters and setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDuration() {
        return 120;
    }


}
