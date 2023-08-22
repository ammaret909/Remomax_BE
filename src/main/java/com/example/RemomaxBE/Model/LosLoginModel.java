package com.example.RemomaxBE.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loslogin")
public class LosLoginModel {
    @Id
    private String rcc;
    @Column(name = "losname")
    private String user;
    @Column(name = "lospassw")
    private String password;
    @Column(name = "IPin")
    private String IP;
    @Column(name = "seqlose")
    private int checkLogin;
    @Column(name = "alert")
    private String alert;
    @Column(name = "approveby")
    private String approveby;
    @Column(name = "approvedate")
    private String approvedate;
    @Column(name = "ractive")
    private String ractive;
    @Column(name = "remark")
    private String remark;
    @Column(name = "ristory")
    private String ristory;

    public LosLoginModel() {
    }

    public LosLoginModel(String rcc, String user, String password, String IP, int checkLogin, String alert, String approveby, String approvedate, String ractive, String remark, String ristory) {
        this.rcc = rcc;
        this.user = user;
        this.password = password;
        this.IP = IP;
        this.checkLogin = checkLogin;
        this.alert = alert;
        this.approveby = approveby;
        this.approvedate = approvedate;
        this.ractive = ractive;
        this.remark = remark;
        this.ristory = ristory;
    }

    public String getRcc() {
        return rcc;
    }

    public void setRcc(String rcc) {
        this.rcc = rcc;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getCheckLogin() {
        return checkLogin;
    }

    public void setCheckLogin(int checkLogin) {
        this.checkLogin = checkLogin;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getApproveby() {
        return approveby;
    }

    public void setApproveby(String approveby) {
        this.approveby = approveby;
    }

    public String getApprovedate() {
        return approvedate;
    }

    public void setApprovedate(String approvedate) {
        this.approvedate = approvedate;
    }

    public String getRactive() {
        return ractive;
    }

    public void setRactive(String ractive) {
        this.ractive = ractive;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRistory() {
        return ristory;
    }

    public void setRistory(String ristory) {
        this.ristory = ristory;
    }
}
