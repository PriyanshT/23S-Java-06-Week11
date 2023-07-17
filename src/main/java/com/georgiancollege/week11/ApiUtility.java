package com.georgiancollege.week11;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiUtility {
    /*
    This method will parse JSON data from a file and store
    to java objects
     */
    public static ApiResponse getDataFromFile(String filename){
        ApiResponse response = null;
        Gson gson = new Gson();

        // try with resources block
        try(
                FileReader fileReader = new FileReader(filename);
                JsonReader jsonReader = new JsonReader(fileReader);
                ){
            response = gson.fromJson(jsonReader, ApiResponse.class);
        } catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }

    /*
    This method will do a http request like we did in browser
    and get the object data from the file stored from api
     */
    public static ApiResponse getDataFromAPI(String searchName){
        searchName = searchName.replace(" ", "%20");
        String url = "https://www.omdbapi.com/?apikey=8127fd11&s=" + searchName;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<Path> response = httpClient.send(httpRequest, HttpResponse
                    .BodyHandlers
                    .ofFile(Paths.get("javaApiFetched.json")));
        } catch (Exception e){
            e.printStackTrace();
        }

        return ApiUtility.getDataFromFile("javaApiFetched.json");
    }

    /*
    This method will create objects without storing it to the hard drive
     */
    public static ApiResponse getDataFromApiQuick(String searchName){
        searchName = searchName.replace(" ", "%20");
        String url = "https://www.omdbapi.com/?apikey=8127fd11&s=" + searchName;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), ApiResponse.class);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
