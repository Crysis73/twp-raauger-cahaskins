package edu.bsu.cs222;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import edu.bsu.cs222.Revision;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class RevisionParser {



    public List<Revision> getRevisions(String searchTerm) {
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
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray array = null;

        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");

        }
        List<Revision> revisionList = new ArrayList<Revision>();

        for (int i = 0; i < array.size(); i++) {
            Revision revision = new Revision(getUsername(array, i), getTimestamp(array, i));
            revisionList.add(revision);
        }
        return revisionList;

    }

    public String getUsername(JsonArray array, int index) {
        String username = array.get(index).getAsJsonObject().get("user").toString().replaceAll("\"", "");
        return username;
    }

    public Timestamp getTimestamp(JsonArray array, int index) {
        String timestampString = array.get(index).getAsJsonObject().get("timestamp").toString().replaceAll("\"", "");
        Timestamp timestamp = convertStringToTimestamp(timestampString);
        return timestamp;
    }

    public Timestamp convertStringToTimestamp(String inputString) {
        inputString = inputString.replace("Z", "");
        inputString = inputString.replace("T", " ");
        Timestamp timestamp = Timestamp.valueOf(inputString);
        return timestamp;

    }
}

