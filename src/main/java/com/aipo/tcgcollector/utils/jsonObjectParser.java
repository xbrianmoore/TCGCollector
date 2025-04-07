package com.aipo.tcgcollector.utils;

import com.google.gson.Gson;
import net.tcgdex.sdk.models.CardResume;

public class jsonObjectParser {
    //returns an array of CardResume (CardBrief) objects
    public static CardResume[] parseJsonResponse(String jsonResponse) {
        CardResume[] parsedCardResume = new Gson().fromJson(jsonResponse, CardResume[].class);
        System.out.println(parsedCardResume);
        return parsedCardResume;
    }
}
