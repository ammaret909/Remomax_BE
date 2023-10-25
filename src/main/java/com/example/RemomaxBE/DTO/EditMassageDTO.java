package com.example.RemomaxBE.DTO;

public class EditMassageDTO {
    private String rcc;
    private String id;
    private String massage;
    private String description;

    public EditMassageDTO() {
    }

    public EditMassageDTO(String rcc, String id, String massage, String description) {
        this.rcc = rcc;
        this.id = id;
        this.massage = massage;
        this.description = description;
    }

    public String getRcc() {
        return rcc;
    }

    public void setRcc(String rcc) {
        this.rcc = rcc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
