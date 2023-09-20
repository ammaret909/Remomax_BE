package com.example.RemomaxBE.DTOout;

import java.util.ArrayList;
import java.util.List;

public class ConvertAspDTOout {
    private String title;
    private String subTitleH1;
    private String subTitleH2;
    private String subTitleH3;
    private List<Header1DTOout> Header1 = new ArrayList<>();
    private List<Header2DTOout> Header2 = new ArrayList<>();
    private List<Header3DTOout> Header3 = new ArrayList<>();

    public ConvertAspDTOout() {
    }

    public ConvertAspDTOout(String title, String subTitleH1, String subTitleH2, String subTitleH3, List<Header1DTOout> header1, List<Header2DTOout> header2, List<Header3DTOout> header3) {
        this.title = title;
        this.subTitleH1 = subTitleH1;
        this.subTitleH2 = subTitleH2;
        this.subTitleH3 = subTitleH3;
        Header1 = header1;
        Header2 = header2;
        Header3 = header3;
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

    public List<Header1DTOout> getHeader1() {
        return Header1;
    }

    public void setHeader1(List<Header1DTOout> header1) {
        Header1 = header1;
    }

    public List<Header2DTOout> getHeader2() {
        return Header2;
    }

    public void setHeader2(List<Header2DTOout> header2) {
        Header2 = header2;
    }

    public List<Header3DTOout> getHeader3() {
        return Header3;
    }

    public void setHeader3(List<Header3DTOout> header3) {
        Header3 = header3;
    }
}
