package com.aipo.tcgcollector.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Search {
    // http client import in order send and receive requests to get data directly
    // from api rather than localize every card object
    public static String retrieveCards(String search) {
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.tcgdex.net/v2/en/cards?name=" + search))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .GET()
                    .build();
            // response.body() returns json in String format.
            // convert to object using gson by google
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}