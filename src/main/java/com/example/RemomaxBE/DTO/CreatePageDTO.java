package com.example.RemomaxBE.DTO;

public class CreatePageDTO {
    private String title;
    private String namePage;

    public CreatePageDTO() {
    }

    public CreatePageDTO(String title, String namePage) {
        this.title = title;
        this.namePage = namePage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNamePage() {
        return namePage;
    }

    public void setNamePage(String namePage) {
        this.namePage = namePage;
    }
}
