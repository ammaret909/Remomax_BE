package com.example.RemomaxBE.DTOout;

public class Header1DTOout {
    String file;
    String name;
    String popup;

    public Header1DTOout() {
    }

    public Header1DTOout(String file, String name, String popup) {
        this.file = file;
        this.name = name;
        this.popup = popup;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopup() {
        return popup;
    }

    public void setPopup(String popup) {
        this.popup = popup;
    }
}
