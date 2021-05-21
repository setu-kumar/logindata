package com.example.flowerstore;

public class Contact {
    String _email;
    String _name;
    String _phone_number;
    String password;
    public Contact(){ }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public Contact(String _email, String _name, String _phone_number,String password) {
        this._email = _email;
        this._name = _name;
        this._phone_number = _phone_number;
        this.password=password;
    }


    public String getEmail(){
        return this._email;
    }

    public void setEmail(String email){
        this._email = _email;
    }

    public String getName(){
        return this._name;
    }
    public void set_name(String name){
        this._name=name;
    }
    public String getPhoneNumber(){
        return this._phone_number;
    }
    public void setPhoneNumber(String _phone_number){
     this._phone_number=_phone_number;

    }
}
