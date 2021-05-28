package com.project.bootcamp.model.dto;

import java.time.LocalDate;

public class StockDTO {
    private long id;
    private String name;
    private Double price;
    private LocalDate date;
    private Double variation;

    public StockDTO() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getVariation() {
        return this.variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }

}