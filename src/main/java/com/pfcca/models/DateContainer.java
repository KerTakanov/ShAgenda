package com.pfcca.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class DateContainer {
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalDateTime dateTime;

    public DateContainer() {
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
