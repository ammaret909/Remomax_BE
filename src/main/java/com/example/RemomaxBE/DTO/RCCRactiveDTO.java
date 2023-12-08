package com.example.RemomaxBE.DTO;

public class RCCRactiveDTO {
    private String RCC;
    private String RCCLogin;

    public RCCRactiveDTO() {
    }

    public RCCRactiveDTO(String RCC, String RCCLogin) {
        this.RCC = RCC;
        this.RCCLogin = RCCLogin;
    }

    public String getRCCLogin() {
        return RCCLogin;
    }

    public void setRCCLogin(String RCCLogin) {
        this.RCCLogin = RCCLogin;
    }

    public String getRCC() {
        return RCC;
    }

    public void setRCC(String RCC) {
        this.RCC = RCC;
    }
}
