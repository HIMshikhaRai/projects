package com.example.himshikha.bloodo.models;

public class DonorDetailModel {


//      buffer.append("ID: "+ cursor.getString(0)+"\n");
//                    buffer.append("Name: "+ cursor.getString(1)+"\n");
//                    buffer.append("Phone: "+ cursor.getString(2)+"\n");
//                    buffer.append("Email: "+ cursor.getString(3)+"\n");
//                    buffer.append("Password: "+ cursor.getString(4)+"\n");
//                    buffer.append("Address: "+ cursor.getString(5)+"\n");
//                    buffer.append("Blood Group: "+ cursor.getString(6)+"\n");

    private String id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String address;
    private String bloodGroup;

    public DonorDetailModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
