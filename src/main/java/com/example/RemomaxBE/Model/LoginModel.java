package com.example.RemomaxBE.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_test")
public class LoginModel {
    @Id
    private String RCC;
    @Column(name = "ID")
    private long ID;
    @Column(name = "USERID")
    private String USERID;
    @Column(name = "DRAWSSAP")
    private String DRAWSSAP;

    public LoginModel() {
    }

    public LoginModel(String RCC, long ID, String USERID, String DRAWSSAP) {
        this.RCC = RCC;
        this.ID = ID;
        this.USERID = USERID;
        this.DRAWSSAP = DRAWSSAP;
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

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getDRAWSSAP() {
        return DRAWSSAP;
    }

    public void setDRAWSSAP(String DRAWSSAP) {
        this.DRAWSSAP = DRAWSSAP;
    }
}
