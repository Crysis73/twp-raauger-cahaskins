package edu.bsu.cs222;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;

public class Parser {
    public JsonObject rootObject(String searchTerm){
        JsonParser parser = new JsonParser();
        Query query = new Query();
        Reader reader = null;
        try {
            reader = query.getContents(searchTerm);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
    }
}
