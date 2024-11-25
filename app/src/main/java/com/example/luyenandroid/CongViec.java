package com.example.luyenandroid;

public class CongViec {
    private String title;
    private String company;
    private String date;

    public CongViec(String title, String company, String date) {
        this.title = title;
        this.company = company;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
