package com.example.RemomaxBE.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_menu")
public class UserMenuModel {
    @Id
    private String rcc;
    @Column(name = "ristory")
    private String ristory;
    @Column(name = "ractive")
    private String ractive;
    @Column(name = "menutext")
    private String menutext;
    @Column(name = "seq")
    private int seq;
    @Column(name = "linkurl")
    private String linkurl;
    @Column(name = "remark")
    private String remark;

    @ManyToOne
    @JoinColumn(name = "urcc")
    private LoginModel urcc;

    public UserMenuModel() {
    }

    public UserMenuModel(String rcc, String ristory, String ractive, String menutext, int seq, String linkurl, String remark, LoginModel urcc) {
        this.rcc = rcc;
        this.ristory = ristory;
        this.ractive = ractive;
        this.menutext = menutext;
        this.seq = seq;
        this.linkurl = linkurl;
        this.remark = remark;
        this.urcc = urcc;
    }

    public String getRcc() {
        return rcc;
    }

    public void setRcc(String rcc) {
        this.rcc = rcc;
    }

    public String getRistory() {
        return ristory;
    }

    public void setRistory(String ristory) {
        this.ristory = ristory;
    }

    public String getRactive() {
        return ractive;
    }

    public void setRactive(String ractive) {
        this.ractive = ractive;
    }

    public LoginModel getUrcc() {
        return urcc;
    }

    public void setUrcc(LoginModel urcc) {
        this.urcc = urcc;
    }

    public String getMenutext() {
        return menutext;
    }

    public void setMenutext(String menutext) {
        this.menutext = menutext;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
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
