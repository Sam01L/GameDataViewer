package com.example.gamedataviewer;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GameCopiesSold extends VideoGames {

    private int copiesSold;
    private static ArrayList<GameCopiesSold> allGameCopies = new ArrayList<GameCopiesSold>();

    // Constructor
    public GameCopiesSold(int rank, String title, LocalDate releaseDate, boolean multiPlatform, int copiesSold) {
        super(rank, title, releaseDate, multiPlatform);
        this.copiesSold = copiesSold;
        allGameCopies.add(this); // track all objects
    }

    // Getter and setter for copiesSold
    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    // Getter and setter for all objects
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

    // Read data from file
    public static void readGameCopiesData() throws Exception {
        File myData = new File("GameCopiesData");
        Scanner myReader = new Scanner(myData);
        String firstLine = myReader.nextLine();

        while (myReader.hasNextLine()) {
            String dataLine = myReader.nextLine().trim();
            if (dataLine.isEmpty()) continue; // skip blank lines

            // Split on any amount of whitespace (tabs or spaces)
            String[] parts = dataLine.split("\\s+");
            if (parts.length < 3) continue; // skip malformed lines

            try {
                int rank = Integer.parseInt(parts[0]);
                String title = parts[1];
                String copiesChunk = parts[2].replaceAll("[^0-9]", "");
                int copiesSold = copiesChunk.isEmpty() ? 0 : Integer.parseInt(copiesChunk);

                // crude heuristic for platform detection
                boolean multiPlatform = dataLine.toLowerCase().contains("multi-platform");

                int year = 2000;
                for (String p : parts) {
                    if (p.matches("\\d{4}")) {  // find a 4-digit year
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
