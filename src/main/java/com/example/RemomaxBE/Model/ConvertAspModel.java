package com.example.RemomaxBE.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "pages")
public class ConvertAspModel {
    @Id
    private String rcc;
    @Column(name = "name_page")
    private String namePage;
    @Column(name = "title")
    private String title;
    @Column(name = "sub_title_1")
    private String subTitleH1;
    @Column(name = "sub_title_2")
    private String subTitleH2;
    @Column(name = "sub_title_3")
    private String subTitleH3;

    public ConvertAspModel() {
    }

    public ConvertAspModel(String rcc, String namePage, String title, String subTitleH1, String subTitleH2, String subTitleH3) {
        this.rcc = rcc;
        this.namePage = namePage;
        this.title = title;
        this.subTitleH1 = subTitleH1;
        this.subTitleH2 = subTitleH2;
        this.subTitleH3 = subTitleH3;
    }

    public String getRcc() {
        return rcc;
    }

    public void setRcc(String rcc) {
        this.rcc = rcc;
    }

    public String getNamePage() {
        return namePage;
    }

    public void setNamePage(String namePage) {
        this.namePage = namePage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitleH1() {
        return subTitleH1;
    }

    public void setSubTitleH1(String subTitleH1) {
        this.subTitleH1 = subTitleH1;
    }

    public String getSubTitleH2() {
        return subTitleH2;
    }

    public void setSubTitleH2(String subTitleH2) {
        this.subTitleH2 = subTitleH2;
    }

    public String getSubTitleH3() {
        return subTitleH3;
    }

    public void setSubTitleH3(String subTitleH3) {
        this.subTitleH3 = subTitleH3;
    }

}
