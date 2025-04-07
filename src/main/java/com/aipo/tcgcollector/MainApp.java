package com.aipo.tcgcollector;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.tcgdex.sdk.TCGdex;
import net.tcgdex.sdk.models.Card;
import net.tcgdex.sdk.models.CardResume;

import java.io.IOException;
import java.util.Arrays;

import  com.aipo.tcgcollector.services.Search;
import static com.aipo.tcgcollector.utils.jsonObjectParser.parseJsonResponse;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        TCGdex tcgdex = new TCGdex("en");
        Card card = tcgdex.fetchCard("swsh3-136");

        Search search = new Search();
        String cardSearch = search.fetchCards("pikachu");
        CardResume[] card3 = parseJsonResponse(cardSearch);

        System.out.println(Arrays.toString(card3));
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("search-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 720);
        stage.setTitle("PoKellector");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}