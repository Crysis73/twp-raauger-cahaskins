import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RevisionParser {



    public JsonArray getRevisions() {
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray array = null;

        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");

        }
        return array;
    }

    public String getUsername(JsonArray array, int index){
        String username = array.get(index).getAsJsonObject().get("user").toString().replaceAll("\"","");
        return username;
    }

    public String getTimestamp(JsonArray array, int index){
        String timestamp = array.get(index).getAsJsonObject().get("timestamp").toString().replaceAll("\"","");
        return timestamp;
    }


    public List<Revision> getRevisionList(JsonArray array){
        List<Revision> revisionList = new ArrayList<Revision>();

        for(int i = 0;i<array.size();i++){
            Revision revision = new Revision(getUsername(array,i),getTimestamp(array,i));
            revisionList.add(revision);
        }
        return revisionList;
    }
}

