package com.georgiancollege.week10;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

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
}
