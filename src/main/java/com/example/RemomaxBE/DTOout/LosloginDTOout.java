package com.example.RemomaxBE.DTOout;

public class LosloginDTOout {
    private String rcc;
    private String time;
    private String losname;
    private String lospassw;
    private String IPin;
    private int seqlose;
    private String alert;

    public LosloginDTOout() {
    }

    public LosloginDTOout(String rcc, String time, String losname, String lospassw, String IPin, int seqlose, String alert) {
        this.rcc = rcc;
        this.time = time;
        this.losname = losname;
        this.lospassw = lospassw;
        this.IPin = IPin;
        this.seqlose = seqlose;
        this.alert = alert;
    }

    public String getRcc() {
        return rcc;
    }

    public void setRcc(String rcc) {
        this.rcc = rcc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLosname() {
        return losname;
    }

    public void setLosname(String losname) {
        this.losname = losname;
    }

    public String getLospassw() {
        return lospassw;
    }

    public void setLospassw(String lospassw) {
        this.lospassw = lospassw;
    }

    public String getIPin() {
        return IPin;
    }

    public void setIPin(String IPin) {
        this.IPin = IPin;
    }

    public int getSeqlose() {
        return seqlose;
    }

    public void setSeqlose(int seqlose) {
        this.seqlose = seqlose;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }
}
