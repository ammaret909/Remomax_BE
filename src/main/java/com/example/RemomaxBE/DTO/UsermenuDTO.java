package com.example.RemomaxBE.DTO;

import java.util.ArrayList;
import java.util.List;

public class UsermenuDTO {
    private String rcc;
    private List<MenuDTO> menu = new ArrayList<>();;

    public UsermenuDTO() {
    }

    public UsermenuDTO(String rcc, List<MenuDTO> menu) {
        this.rcc = rcc;
        this.menu = menu;
    }

    public String getRcc() {
        return rcc;
    }

    public void setRcc(String rcc) {
        this.rcc = rcc;
    }

    public List<MenuDTO> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuDTO> menu) {
        this.menu = menu;
    }
}
