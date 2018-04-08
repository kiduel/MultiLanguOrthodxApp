package com.example.kidus11.amhtiggeeeng.data;

/**
 * Created by kidus11 on 12/7/17.
 */

public class PrayersMain {
    private final String title;
    private final String prayer_dis;
    private final int icon;

    public PrayersMain(String title, String prayer_dis, int icon) {
        this.title = title;
        this.icon = icon;
        this.prayer_dis = prayer_dis;
    }

    public String getTitle() {
        return title;
    }

    public String getPrayer_dis() {
        return prayer_dis;
    }

    public int getIcon() {
        return icon;
    }

}