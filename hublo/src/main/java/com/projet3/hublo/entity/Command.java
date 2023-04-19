package com.projet3.hublo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date treatmentDate;
    private LocalDate commandDate;
    private String comment;
    private String deliveryStation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    public Command(){}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getTreatmentDate() {
        return treatmentDate;
    }
    public void setTreatmentDate(Date treatmentDate) {
        this.treatmentDate = treatmentDate;
    }
    public LocalDate getCommandDate() {
        return commandDate;
    }
    public void setCommandDate(LocalDate orderDate) {
        this.commandDate = commandDate;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getDeliveryStation() {
        return deliveryStation;
    }
    public void setDeliveryStation(String deliveryStation) {
        this.deliveryStation = deliveryStation;
    }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
