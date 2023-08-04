package com.example.RemomaxBE.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "alert_massage")
public class MassageModel {
    @Id
    private String RCC;
    @Column(name = "id")
    private long ID;
    @Column(name = "massage")
    private String massage;

    public MassageModel() {
    }

    public MassageModel(String RCC, long ID, String massage) {
        this.RCC = RCC;
        this.ID = ID;
        this.massage = massage;
    }

    public String getRCC() {
        return RCC;
    }

    public void setRCC(String RCC) {
        this.RCC = RCC;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
