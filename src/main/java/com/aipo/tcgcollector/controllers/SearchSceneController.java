package com.aipo.tcgcollector.controllers;

import java.util.ArrayList;

import com.aipo.tcgcollector.services.Search;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import net.tcgdex.sdk.models.CardResume;

public class SearchSceneController {
    @FXML
    private ListView<String> searchQueryList;
    private ArrayList<Label> searchResultLabels;
    private Search search;

    @FXML
    private Button searchBarButton;
    @FXML
    private TextField searchBar;

    public SearchSceneController() {
        this.searchResultLabels = new ArrayList<>();
        this.search = new Search();

    }

    public void onSearchBarButtonClicked(ActionEvent event) {
        searchQueryList.getItems().clear();
        try {
            search.fetchCards(searchBar.getText());
            CardResume[] resultList = search.getLastCardFetch();
            for (int i = 0; i < resultList.length-1; i++) {
                //System.out.println("At " + i + " :" + resultList[i]);
                Label label = new Label(resultList[i].getName() + " " + resultList[i].getId());
                //System.out.println(label.getText());
                searchResultLabels.add(label);
                searchQueryList.getItems().add(label.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onItemClicked(MouseEvent event) {
        String selected = searchQueryList.getSelectionModel().getSelectedItem();
        CardResume[] cards = search.getLastCardFetch();
        for(CardResume card : cards) {
            if(card.getName().equals(selected)) {

            }
        }

    }

    public void initialize() {
    }
}