package com.example.RemomaxBE.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "header_all")
public class HeaderAllModel {
    @Id
    private String rcc;
    @Column(name = "title_number")
    private String title_number;
    @Column(name = "file_name")
    private String file_name;
    @Column(name = "header_name")
    private String header_name;
    @Column(name = "popup")
    private String popup;
    @ManyToOne
    @JoinColumn(name = "page_rcc")
    private ConvertAspModel convertAspModel;

    public HeaderAllModel() {
    }

    public HeaderAllModel(String rcc, String title_number, String file_name, String header_name, String popup, ConvertAspModel convertAspModel) {
        this.rcc = rcc;
        this.title_number = title_number;
        this.file_name = file_name;
        this.header_name = header_name;
        this.popup = popup;
        this.convertAspModel = convertAspModel;
    }

    public String getRcc() {
        return rcc;
    }

    public void setRcc(String rcc) {
        this.rcc = rcc;
    }

    public String getTitle_number() {
        return title_number;
    }

    public void setTitle_number(String title_number) {
        this.title_number = title_number;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getHeader_name() {
        return header_name;
    }

    public void setHeader_name(String header_name) {
        this.header_name = header_name;
    }

    public String getPopup() {
        return popup;
    }

    public void setPopup(String popup) {
        this.popup = popup;
    }

    public ConvertAspModel getConvertAspModel() {
        return convertAspModel;
    }

    public void setConvertAspModel(ConvertAspModel convertAspModel) {
        this.convertAspModel = convertAspModel;
    }
}
