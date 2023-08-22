package com.example.RemomaxBE.DTO;

import java.time.LocalDateTime;

public class RCCDTO {
    private LocalDateTime dateTime;

    public RCCDTO() {
    }

    public RCCDTO(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
