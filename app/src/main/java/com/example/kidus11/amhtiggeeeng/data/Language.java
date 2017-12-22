package com.example.kidus11.amhtiggeeeng.data;

/**
 * Created by kidus11 on 12/7/17.
 */

public class Language {
    private String languageName;
    private String description;

    public Language(String languageName, String description) {
        this.languageName = languageName;
        this.description = description;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getDescription() {
        return description;
    }
}

