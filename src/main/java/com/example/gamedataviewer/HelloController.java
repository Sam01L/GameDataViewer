package com.example.gamedataviewer;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    public TextField gameTitle;
    public TextField gameType;
    public TextField gameRank;
    public TextArea toStringText;
    public TableView<VideoGames> allGamesListView;

    public void initialize() throws Exception{
        GameRating.readGameRatingData();
        GameCopiesSold.readGameCopiesData();

        for (VideoGames eachGame : VideoGames.getAllVideoGames()) {
            allGamesListView.getItems().add(eachGame);
        }

        allGamesListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (newValue != null) {
                        gameRank.setText(String.valueOf(newValue.getRank()));
                        gameTitle.setText(newValue.getTitle());
                    } else {
                        gameRank.setText("");
                        gameTitle.setText("");
                    }
                });
    }
    }




