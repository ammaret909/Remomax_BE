package com.example.RemomaxBE.Model;

import com.example.RemomaxBE.DTOout.LoginAndLogoutDashboardDTOout;
import jakarta.persistence.*;

@Entity
@Table(name = "drawsapp")
public class LoginModel {
    @Id
    private String RCC;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "USERID")
    private String USERID;
    @Column(name = "DRAWSSAP")
    private String DRAWSSAP;
    @Column(name = "ractive")
    private String ractive;
    @Column(name = "level")
    private String level;
    @Column(name = "ristory")
    private String ristory;
    @Column(name = "secret")
    private String secret;

    public LoginModel() {
    }

    public LoginModel(String RCC, String fullname, String USERID, String DRAWSSAP, String ractive, String level, String ristory, String secret) {
        this.RCC = RCC;
        this.fullname = fullname;
        this.USERID = USERID;
        this.DRAWSSAP = DRAWSSAP;
        this.ractive = ractive;
        this.level = level;
        this.ristory = ristory;
        this.secret = secret;
    }

    public String getRCC() {
        return RCC;
    }

    public void setRCC(String RCC) {
        this.RCC = RCC;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getRactive() {
        return ractive;
    }

    public void setRactive(String ractive) {
        this.ractive = ractive;
    }

    public String getRistory() {
        return ristory;
    }

    public void setRistory(String ristory) {
        this.ristory = ristory;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
