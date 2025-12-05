package com.example.gamedataviewer;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GameCopiesSold extends VideoGames {

    private int copiesSold;
    private static ArrayList<GameCopiesSold> allGameCopies = new ArrayList<GameCopiesSold>();


    public GameCopiesSold(int rank, String title, LocalDate releaseDate, boolean multiPlatform, int copiesSold) {
        super(rank, title, releaseDate, multiPlatform);
        this.copiesSold = copiesSold;
        allGameCopies.add(this);
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public static ArrayList<GameCopiesSold> getAllGameCopies() {
        return allGameCopies;
    }

    public static void setAllGameCopies(ArrayList<GameCopiesSold> allGameCopies) {
        GameCopiesSold.allGameCopies = allGameCopies;
    }


    public String toString() {
        String superString = super.toString();
        return superString + ", Copies Sold: " + copiesSold + "M";
    }

    public static void readGameCopiesData() throws Exception {
        File myData = new File("GameCopiesData");
        Scanner myReader = new Scanner(myData);
        String firstLine = myReader.nextLine();

        while (myReader.hasNextLine()) {
            String dataLine = myReader.nextLine().trim();
            if (dataLine.isEmpty()) continue;

            String[] parts = dataLine.split("\\s+");
            if (parts.length < 3) continue;

            try {
                int rank = Integer.parseInt(parts[0]);
                String title = parts[1];
                String copiesChunk = parts[2].replaceAll("[^0-9]", "");
                int copiesSold = copiesChunk.isEmpty() ? 0 : Integer.parseInt(copiesChunk);

                boolean multiPlatform = dataLine.toLowerCase().contains("multi-platform");

                int year = 2000;
                for (String p : parts) {
                    if (p.matches("\\d{4}")) {
                        year = Integer.parseInt(p);
                        break;
                    }
                }

                LocalDate gameDate = LocalDate.of(year, 1, 1);
                new GameCopiesSold(rank, title, gameDate, multiPlatform, copiesSold);
            } catch (NumberFormatException e) {
                System.out.println("Skipping malformed line: " + dataLine);
            }
        }

    }
}
