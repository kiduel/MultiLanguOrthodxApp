package com.example.kidus11.amhtiggeeeng.data;

/**
 * Created by kidus11 on 12/21/17.
 */

public class Dawit {
    private String timeOfPrayer;
    private String title_or_description;

    public Dawit (String timeOfPrayer, String title_or_description) {
        this.timeOfPrayer = timeOfPrayer;
        this.title_or_description = title_or_description;
    }

    public String getTimeOfPrayer() {
        return timeOfPrayer;
    }

    public String getTitle_or_description() {
        return title_or_description;
    }
}

