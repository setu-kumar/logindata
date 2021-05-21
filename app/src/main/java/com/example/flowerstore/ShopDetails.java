package com.example.flowerstore;

public class ShopDetails {
    String[] name,address,phone;
    int image[];

    public String[] getName() {
        return name;
    }

    public ShopDetails(String[] name, String[] address, String[] phone, int[] image) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.image = image;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }

    public int[] getImage() {
        return image;
    }

    public void setImage(int[] image) {
        this.image = image;
    }

    public void setName(String[] name) {
        this.name = name;
    }
}
