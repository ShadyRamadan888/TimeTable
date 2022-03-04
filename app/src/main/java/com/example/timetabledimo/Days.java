package com.example.timetabledimo;

public class Days {

    private String name ;
    private String date;


    public Days(String name, String date) {
        this.name = name;
        this.date = date;

    }

    @Override
    public String toString() {
        return "Days{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
