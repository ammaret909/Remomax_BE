package com.example.RemomaxBE.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "check_rcc")
public class RCCModel {
    @Id
    private Long id;

    @Column(name = "check_rcc")
    private String check_rcc;

    public RCCModel() {
    }

    public RCCModel(Long id, String check_rcc) {
        this.id = id;
        this.check_rcc = check_rcc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheck_rcc() {
        return check_rcc;
    }

    public void setCheck_rcc(String check_rcc) {
        this.check_rcc = check_rcc;
    }
}
