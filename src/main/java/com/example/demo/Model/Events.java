package com.example.demo.Model;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Events {
    @Id
    @GeneratedValue
    private long id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date_deb;
    @DateTimeFormat (pattern = "dd-MM-yyyy")
    private Date date_fin;
    private String  nom;
    private String description ;
    private int nbre_de_place ;
    private float prix ;
    private String region;




    @ManyToMany
    @JoinTable(name = "EVENTS_PARTICIPANTS",
            joinColumns = { @JoinColumn(name = "events_id") },
            inverseJoinColumns = { @JoinColumn(name = "participant_id") })
    private Collection<User> participants =new ArrayList<>();

    public Events(Date date_deb, Date date_fin, String nom, String description, int nbre_de_place, float prix, String region) {
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.nom = nom;
        this.description = description;
        this.nbre_de_place = nbre_de_place;
        this.prix = prix;
        this.region = region;

    }

    public Events() {
    }

    public Date getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(Date date_deb) {
        this.date_deb = date_deb;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbre_de_place() {
        return nbre_de_place;
    }

    public void setNbre_de_place(int nbre_de_place) {
        this.nbre_de_place = nbre_de_place;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Collection<User> getParticipants() {
        return participants;
    }

    public long getId() {
        return id;
    }
}
