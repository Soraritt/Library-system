package com.company;

public class Librarian {

    private String id = "";
    private String name = "";
    private int st_Period_date = 7;
    private int en_Period_date = 15;

    public Librarian(String id,String name,int st_Period_date,int en_Period_date)
    {
        this.id = id;
        this.name = name;
        this.st_Period_date = st_Period_date;
        this.en_Period_date = en_Period_date;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSt_Period_date() {
        return st_Period_date;
    }

    public void setSt_Period_date(int st_Period_date) {
        this.st_Period_date = st_Period_date;
    }

    public int getEn_Period_date() {
        return en_Period_date;
    }

    public void setEn_Period_date(int en_Period_date) {
        this.en_Period_date = en_Period_date;
    }
}
