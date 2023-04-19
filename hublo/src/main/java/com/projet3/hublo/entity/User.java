package com.projet3.hublo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Command> commands;
    @ManyToMany
    @JoinTable(name="favorite",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List <Product> products = new ArrayList<>();
    private String firstname;
    private String lastname;
    private String immatriculation;
    private String mail;
    private String password;
    private String phoneNumber;
    private String defaultStation;
    private String role;
    private String poste;
    public User(){}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getImmatriculation() {
        return immatriculation;
    }
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) { this.mail = mail; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getDefaultStation() { return defaultStation; }
    public void setDefaultStation(String defaultStation) { this.defaultStation = defaultStation; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }
    public List<Command> getCommands() { return commands; }
    public void setCommands(List<Command> commands) { this.commands = commands; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}
