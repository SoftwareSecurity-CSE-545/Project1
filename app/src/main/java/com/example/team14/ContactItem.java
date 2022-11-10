package com.example.team14;

public class ContactItem {
    private String name;

    private String mail;

    private String phone;

    // create constructor to set the values for all the parameters of the each single view
    public ContactItem(String name, String mail, String phone) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    // getter method for returning the ID of the imageview
    public String getName() {
        return name;
    }

    // getter method for returning the ID of the TextView 1
    public String getMail() {
        return mail;
    }

    // getter method for returning the ID of the TextView 2
    public String getPhone() {
        return phone;
    }
}
