package com.example.RemomaxBE.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ulogio")
public class ReceiveLoginModel {

    @Id
    private String RCC;
    @Column(name = "rccu")
    private String RCCU;
    @Column(name = "in_or_out")
    private String InOrOut;
    @Column(name = "ip")
    private String IP;
    @Column(name = "rcc_login")
    private String rccLogin;

    public ReceiveLoginModel() {
    }

    public ReceiveLoginModel(String RCC, String RCCU, String inOrOut, String IP, String rccLogin) {
        this.RCC = RCC;
        this.RCCU = RCCU;
        InOrOut = inOrOut;
        this.IP = IP;
        this.rccLogin = rccLogin;
    }

    public String getRccLogin() {
        return rccLogin;
    }

    public void setRccLogin(String rccLogin) {
        this.rccLogin = rccLogin;
    }

    public String getRCC() {
        return RCC;
    }

    public void setRCC(String RCC) {
        this.RCC = RCC;
    }

    public String getRCCU() {
        return RCCU;
    }

    public void setRCCU(String RCCU) {
        this.RCCU = RCCU;
    }

    public String getInOrOut() {
        return InOrOut;
    }

    public void setInOrOut(String inOrOut) {
        InOrOut = inOrOut;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
}
