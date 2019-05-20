package com.learn2crack.model;


public class User {

    private String name;
    private String email;
    private String reg_number;
    private String contact_number;
    private String address_of_prac;
    private String pincode;
    private String password;
    private String created_at;
    private String newPassword;
    private String token;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public void setAddress_of_prac(String address_of_prac) { this.address_of_prac = address_of_prac; }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getReg_number() {
        return reg_number;
    }

    public String getContact_number() {
        return contact_number;
    }

    public String getAddress_of_prac() {
        return address_of_prac;
    }

    public String getPincode() { return pincode;}

    public String getCreated_at() {
        return created_at;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
