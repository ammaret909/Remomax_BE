package com.example.RemomaxBE.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "alert_massage")
public class MassageModel {
    @Id
    private String RCC;
    @Column(name = "id")
    private String ID;
    @Column(name = "massage")
    private String massage;
    @Column(name = "description")
    private String description;

    public MassageModel() {
    }

    public MassageModel(String RCC, String ID, String massage, String description) {
        this.RCC = RCC;
        this.ID = ID;
        this.massage = massage;
        this.description = description;
    }

    public String getRCC() {
        return RCC;
    }

    public void setRCC(String RCC) {
        this.RCC = RCC;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
