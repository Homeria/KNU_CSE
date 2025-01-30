package com.example.covid_19notification;

public class DataItem {

    String date;
    String decideCnt;
    String deathCnt;
    String year;
    String month;
    String day;

    public DataItem() {
        date = null;
        decideCnt = null;
        deathCnt = null;
    }

    public DataItem(String date, String decideCnt, String deathCnt) {
        this.date = date;
        this.decideCnt = decideCnt;
        this.deathCnt = deathCnt;
        calTime();
    }

    public int getIntDecideCnt() {
        return Integer.parseInt(decideCnt);
    }

    public int getIntDeathCnt() {
        return Integer.parseInt(deathCnt);
    }

    public String getDate() {
        return date;
    }

    public String getDecideCnt() {
        return decideCnt;
    }

    public String getDeathCnt() {
        return deathCnt;
    }

    public String getYear() { return year; }

    public String getMonth() { return month; }

    public String getDay() { return day; }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDecideCnt(String decideCnt) {
        this.decideCnt = decideCnt;
    }

    public void setDeathCnt(String deathCnt) {
        this.deathCnt = deathCnt;
    }

    public void calTime() {
        String[] dates = date.split("-");
        year = dates[0];
        month = dates[1];
        day = dates[2];
    }

    public String toString() {
        return ("Item{date=" + date + ", decideCnt=" + decideCnt + ", deathCnt=" + deathCnt + "}");
    }
}
