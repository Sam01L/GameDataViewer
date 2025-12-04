package com.example.gamedataviewer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    public TextField gameTitle;
    public TextField gameType;
    public TextField gameRank;
    public TextArea toStringText;
    public ListView<VideoGames> allGamesListView;

    public void initialize() throws Exception{
        GameRating.readGameRatingData();
        GameCopiesSold.readGameCopiesData();
    }
    }




