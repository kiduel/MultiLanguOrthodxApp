package com.example.kidus11.amhtiggeeeng.data;

/**
 * Created by kidus11 on 12/9/17.
 */

public class Day {
    private String date;
    private String date_prayer_inside;

    public Day(String date, String date_prayer_inside) {
        this.date = date;
        this.date_prayer_inside = date_prayer_inside;
    }

    public Day(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getDateDesc() {
        return date_prayer_inside;
    }
}
