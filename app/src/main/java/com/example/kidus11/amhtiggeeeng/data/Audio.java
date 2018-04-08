package com.example.kidus11.amhtiggeeeng.data;

/**
 * Created by kidus11 on 12/26/17.
 */

public class Audio {
    private String audio_title;
    private String artist;
    private String audioUrl;
    private String imageUrl;


    public Audio(String audio_title, String artist, String imageUrl, String audioUrl) {
        this.audio_title = audio_title;
        this.artist = artist;
        this.imageUrl = imageUrl;
        this.audioUrl = audioUrl;

    }

    public Audio(String audio_title, String imageUrl) {
        this.audio_title = audio_title;
        this.imageUrl = imageUrl;
    }

    public String getAudio_title() {
        return audio_title;
    }
    public String getArtist() {
        return artist;
    }
    public String getAudioUrl() {
        return audioUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }
}
