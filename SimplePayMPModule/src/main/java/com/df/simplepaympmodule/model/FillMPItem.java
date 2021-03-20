package com.df.simplepaympmodule.model;

public class FillMPItem {

    private String title;
    private String description;
    private int quantity;
    private String currency_id;
    private Double unit_price;

    public FillMPItem(String title, String description, int quantity, String currency_id, Double unit_price) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.currency_id = currency_id;
        this.unit_price = unit_price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

}
