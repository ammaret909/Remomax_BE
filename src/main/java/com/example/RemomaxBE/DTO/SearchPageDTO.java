package com.example.RemomaxBE.DTO;

public class SearchPageDTO {
    private String namePage;

    public SearchPageDTO() {
    }

    public SearchPageDTO(String namePage) {
        this.namePage = namePage;
    }

    public String getNamePage() {
        return namePage;
    }

    public void setNamePage(String namePage) {
        this.namePage = namePage;
    }
}
