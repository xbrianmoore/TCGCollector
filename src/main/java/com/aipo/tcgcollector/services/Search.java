package com.aipo.tcgcollector.services;

import net.tcgdex.sdk.models.CardResume;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.aipo.tcgcollector.utils.jsonObjectParser.parseJsonResponse;

public class Search {
    //Every search updates the fetch list with CardResume Objects
    //instead of string
    private CardResume[] lastCardsFetch;

    public CardResume[] getLastCardFetch() {
        return lastCardsFetch;
    }

    public void setLastCardFetch(CardResume[] lastCardFetch) {
        this.lastCardsFetch = lastCardFetch;
    }

    // http client import in order send and receive requests to get data directly
    // from api rather than localize every card object
    public String fetchCards(String search) {
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.tcgdex.net/v2/en/cards?name=" + search))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .GET()
                    .build();
            // response.body() returns json in String format.
            // convert to object using gson by google
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            setLastCardFetch(parseJsonResponse(response.body()));
            return response.body();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}