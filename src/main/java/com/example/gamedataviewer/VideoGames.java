package com.example.gamedataviewer;

import java.time.LocalDate;
import java.util.ArrayList;

public class VideoGames {

     int rank;
     String title;
     LocalDate releaseDate;
     boolean multiPlatform;
     static ArrayList<VideoGames> allVideoGames = new ArrayList<VideoGames>();

    VideoGames(int rank, String title, LocalDate releaseDate, boolean multiPlatform) {
        this.rank = rank;
        this.title = title;
        this.releaseDate = releaseDate;
        this.multiPlatform = multiPlatform;
        allVideoGames.add(this);
    }

    public static ArrayList<VideoGames> getAllVideoGames() {
        return allVideoGames;
    }

    public static void setAllVideoGames(ArrayList<VideoGames> allVideoGames) {
        VideoGames.allVideoGames = allVideoGames;
    }

    public boolean isMultiPlatform() {
        return multiPlatform;
    }

    public int getRank() {
        return rank;
    }

    private void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    private void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    private void setMultiPlatform(boolean multiPlatform) {
        this.multiPlatform = multiPlatform;
    }

    public String toString() {
        return "Rank: " + rank +
                ", Title: " + title +
                ", Release Date: " + releaseDate +
                ", Multi-Platform: " + multiPlatform;
    }



}
