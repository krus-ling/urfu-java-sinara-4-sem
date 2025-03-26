package ru.guk.education.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class RequestData {

    private double price;
    private Info info;

    public static class Info {
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Long id;
        private String date;

        // Геттеры и сеттеры
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }
    }

    // Геттеры и сеттеры
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public Info getInfo() { return info; }
    public void setInfo(Info info) { this.info = info; }
}
