package com.example.gamedataviewer;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GameRating extends VideoGames {

    int metaScore;
    String rating;

    public GameRating(int rank, String title, LocalDate releaseDate, boolean multiPlatform, int metaScore, String rating) {
        super(rank, title, releaseDate, multiPlatform);
        this.metaScore = metaScore;
        this.rating = rating;
    }

    public String toString() {
        return super.toString() +
                ", MetaScore: " + metaScore +
                ", Rating: " + rating;
    }

    public static void readGameRatingData() throws Exception {

        File file = new File("GameRatingData");
        Scanner sc = new Scanner(file);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM d, yyyy");

        while (sc.hasNextLine()) {

            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            if (!line.equalsIgnoreCase("must-play"))
                continue;




            String titleLine = sc.nextLine().trim();
            int dotIndex = titleLine.indexOf(".");
            int rank = Integer.parseInt(titleLine.substring(0, dotIndex));
            String title = titleLine.substring(dotIndex + 1).trim();

            String dateRateLine = sc.nextLine().trim();
            String datePart = dateRateLine.split("•")[0].trim();
            LocalDate date = LocalDate.parse(datePart, dateFormat);

            String rating = "Unknown";
            if (dateRateLine.contains("Rated"))
                rating = dateRateLine.substring(dateRateLine.indexOf("Rated")).replace("Rated", "").trim();

            boolean multiPlatform = false;

            String scoreLine = "";
            while (sc.hasNextLine()) {
                scoreLine = sc.nextLine().trim();
                if (scoreLine.matches("\\d+")) break;
            }

            int metaScore = Integer.parseInt(scoreLine);

            sc.nextLine();


            new GameRating(rank, title, date, multiPlatform, metaScore, rating);
        }

        sc.close();
    }
}