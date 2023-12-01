package com.example.RemomaxBE.DemoAdmin.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "drawsapp_admin")
public class AdminLoginModel {
    @Id
    private String RCC;
    @Column(name = "USERID")
    private String USERID;
    @Column(name = "DRAWSSAP")
    private String DRAWSSAP;

    public AdminLoginModel() {
    }

    public AdminLoginModel(String RCC, String USERID, String DRAWSSAP) {
        this.RCC = RCC;
        this.USERID = USERID;
        this.DRAWSSAP = DRAWSSAP;
    }

    public String getRCC() {
        return RCC;
    }

    public void setRCC(String RCC) {
        this.RCC = RCC;
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
