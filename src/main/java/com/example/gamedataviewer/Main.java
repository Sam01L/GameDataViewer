package com.example.gamedataviewer;

import java.time.LocalDate;

public class Main { public static void main(String[] args) throws Exception {
    {
        LocalDate game1Date = LocalDate.of(1998, 11, 23);
        GameCopiesSold.readGameCopiesData();
        for (VideoGames eachCopy : VideoGames.getAllVideoGames()) {
            System.out.println(eachCopy);
        }
    }

        for (VideoGames eachGame : VideoGames.getAllVideoGames()) {
            System.out.println(eachGame);
        }


}
}