package com.example.RemomaxBE.DTOout;

import com.example.RemomaxBE.Model.HeaderAllModel;
import jakarta.persistence.Column;

import java.util.ArrayList;
import java.util.List;

public class RedirectPageDTOout {
    private String rcc;
    private String namePage;
    private String title;
    private String subTitleH1;
    private String subTitleH2;
    private String subTitleH3;
    private List<HeaderAllModel> header1DTOoutList = new ArrayList<>();
    private List<HeaderAllModel> header2DTOoutList = new ArrayList<>();
    private List<HeaderAllModel> header3DTOoutList = new ArrayList<>();

    public RedirectPageDTOout() {
    }

    public RedirectPageDTOout(String rcc, String namePage, String title, String subTitleH1, String subTitleH2, String subTitleH3, List<HeaderAllModel> header1DTOoutList, List<HeaderAllModel> header2DTOoutList, List<HeaderAllModel> header3DTOoutList) {
        this.rcc = rcc;
        this.namePage = namePage;
        this.title = title;
        this.subTitleH1 = subTitleH1;
        this.subTitleH2 = subTitleH2;
        this.subTitleH3 = subTitleH3;
        this.header1DTOoutList = header1DTOoutList;
        this.header2DTOoutList = header2DTOoutList;
        this.header3DTOoutList = header3DTOoutList;
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

    public List<HeaderAllModel> getHeader1DTOoutList() {
        return header1DTOoutList;
    }

    public void setHeader1DTOoutList(List<HeaderAllModel> header1DTOoutList) {
        this.header1DTOoutList = header1DTOoutList;
    }

    public List<HeaderAllModel> getHeader2DTOoutList() {
        return header2DTOoutList;
    }

    public void setHeader2DTOoutList(List<HeaderAllModel> header2DTOoutList) {
        this.header2DTOoutList = header2DTOoutList;
    }

    public List<HeaderAllModel> getHeader3DTOoutList() {
        return header3DTOoutList;
    }

    public void setHeader3DTOoutList(List<HeaderAllModel> header3DTOoutList) {
        this.header3DTOoutList = header3DTOoutList;
    }
}
