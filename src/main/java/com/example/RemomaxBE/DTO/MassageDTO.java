package com.example.RemomaxBE.DTO;

public class MassageDTO {
    private String RCC;
    private String massage;

    public MassageDTO() {
    }

    public MassageDTO(String RCC, String massage) {
        this.RCC = RCC;
        this.massage = massage;
    }

    public String getRCC() {
        return RCC;
    }

    public void setRCC(String RCC) {
        this.RCC = RCC;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
