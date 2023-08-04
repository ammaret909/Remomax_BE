package com.example.RemomaxBE.DTO;

public class CheckLoginDTO {
    private String USERID;
    private String DRAWSSAP;

    public CheckLoginDTO() {
    }

    public CheckLoginDTO(String USERID, String DRAWSSAP) {
        this.USERID = USERID;
        this.DRAWSSAP = DRAWSSAP;
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
