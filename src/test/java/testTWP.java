import com.google.gson.JsonArray;
import edu.bsu.cs222.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testTWP {

    @Test
    public void testgetRevisions(){
        RevisionParser parser = new RevisionParser("Soup");
        List<Revision> revisionList = parser.getRevisions();
        for(int i =0;i<revisionList.size();i++) {
            System.out.println(revisionList.get(i).toString());
        }

    }
    @Test
    public void testgetSortedByTimestampRevisions(){

        RevisionList revisionList = new RevisionList("Soup");
        revisionList.sortByTimestamp();
        for(int i =0;i<revisionList.size();i++) {
            System.out.println(revisionList.get(i).toString());
        }
    }

    @Test
    public void testgetContents(){
        Query query = new Query();
        Reader result = null;
        try {
            result = query.getContents("soup");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    @Test
    public void testgetRedirects(){
        RevisionParser revisionParser = new RevisionParser("Soups");
        System.out.println(revisionParser.getRedirects());
    }

  /*  @Test
    public void testgetSortedByNumberOfRevisions(){
        RevisionList revisionList = new RevisionList("Soup");
        System.out.println(revisionList.sortByEditsPerUser());
    }*/

    @Test
    public void testAuthorCreation(){
        RevisionList revisionList = new RevisionList("Soup");
    }

    /*
    public void testcountEditsPerUser(){
        RevisionList revisionList = new RevisionList("sample.json");
        Map<String,Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put("Jph",1);
        expectedResult.put("SemiHypercube",5);
        expectedResult.put("2605:6000:E501:E700:5C13:42F:83ED:316D",2);
        Map<String,Integer> sortedListOfRevisions = revisionList.countEditsPerUser();
        System.out.println(expectedResult + " " + sortedListOfRevisions);
       // Assert.assertEquals(expectedResult,sortedListOfRevisions);
    }
    */
    /*
   @Test
    public void testgetUsername(){
        RevisionParser parser = new RevisionParser();
        JsonArray array = parser.getRevisions();
        String result = parser.getUsername(array,0);
        Assert.assertEquals("SemiHypercube",result);
    }
    @Test
    public void testgetTimestamp(){
        RevisionParser parser = new RevisionParser();
        JsonArray array = parser.getRevisions();
        String result = parser.getTimestamp(array,0);
        Assert.assertEquals("2018-08-14T20:34:45Z",result);
    }
    @Test
    public void testgetRevisionList(){
        RevisionParser parser = new RevisionParser();
        JsonArray array = parser.getRevisions();
        List<Revision> revisionList = parser.getRevisionList(array);
        for(int i =0;i<revisionList.size();i++) {
            System.out.println(revisionList.get(i).toString());
        }
    }
    */
}
