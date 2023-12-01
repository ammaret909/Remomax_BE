package com.example.RemomaxBE.DTO;

public class MenuDTO {
    private String rcc;
    private String menutext;
    private String linkurl;
    private String remark;


    public MenuDTO() {
    }

    public MenuDTO(String rcc, String menutext, String linkurl, String remark) {
        this.rcc = rcc;
        this.menutext = menutext;
        this.linkurl = linkurl;
        this.remark = remark;
    }

    public String getRcc() {
        return rcc;
    }

    public void setRcc(String rcc) {
        this.rcc = rcc;
    }

    public String getMenutext() {
        return menutext;
    }

    public void setMenutext(String menutext) {
        this.menutext = menutext;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
