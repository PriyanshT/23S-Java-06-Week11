package com.georgiancollege.week10;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("Search")
    private Movie[] search;

    private String totalResults;

    @SerializedName("Response")
    private String response;
}
