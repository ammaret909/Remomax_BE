package com.example.RemomaxBE.DTOout;

import jakarta.persistence.Column;

public class UserDTOout {
    private String RCC;
    private String fullname;
    private String USERID;
    private String DRAWSSAP;
    private String level;

    public UserDTOout() {
    }

    public UserDTOout(String RCC, String fullname, String USERID, String DRAWSSAP, String level) {
        this.RCC = RCC;
        this.fullname = fullname;
        this.USERID = USERID;
        this.DRAWSSAP = DRAWSSAP;
        this.level = level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
