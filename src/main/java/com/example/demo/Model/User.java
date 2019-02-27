package com.example.demo.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String nom ;
    private String prenom ;
    private long tel;
    private String password ;
    private String email;


    @ManyToMany(
            mappedBy = "participants")
    private Collection<Events> events=new ArrayList<>();

    public User(String nom, String prenom,String password,long tel,String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel=tel;
        this.password=password;
        this.email=email;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel=" + tel +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password =password ;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Collection<Events> getEvents() {
        return events;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}