package com.aipo.tcgcollector.services;

import com.google.gson.Gson;
import net.tcgdex.sdk.models.CardResume;

public class jsonObjectParser {
    public static CardResume[] parseJsonResponse(String jsonResponse) {
        CardResume[] parsedCardResume = new Gson().fromJson(jsonResponse, CardResume[].class);
        System.out.println(parsedCardResume);
        return parsedCardResume;
    }
}
