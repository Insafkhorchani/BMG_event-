package com.example.demo.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Admin implements Serializable {
    @Id
    @GeneratedValue
    private  long id ;
    private  String firstName ;
    private   String lastName ;
    private  String login ;
    private  String password ;
    private  String type ;
    private  String address ;
    private  String  phoneNumber;


    public Admin(String firstName, String lastName, String login, String password, String type, String address, String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.type = type;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Admin(Long cin) {
        this.id = cin;
    }

    public Admin(int i) {
    }

    public Long getCin() {
        return id;
    }

    public void setCin(Long cin) {
        this.id = cin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
