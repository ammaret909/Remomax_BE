package com.example.RemomaxBE.DTO;

public class LoginDTO {
    private String RCC;
    private String USERID;
    private String DRAWSSAP;

    public LoginDTO() {
    }

    public LoginDTO(String RCC, String USERID, String DRAWSSAP) {
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
