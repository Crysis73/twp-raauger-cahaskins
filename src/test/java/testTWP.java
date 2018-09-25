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
        RevisionList revisionList = new RevisionList("soup");
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
    public void testcountEditsPerUser(){
        RevisionList revisionList = new RevisionList("Soup");
        Map<String,Integer> sortedListOfRevisions = revisionList.countEditsPerUser();
        System.out.println(sortedListOfRevisions);
       // Assert.assertEquals(expectedResult,sortedListOfRevisions);
    }

    @Test
    public void testMakeAuthor(){
        RevisionList revisionList = new RevisionList("Soup");
        Author author = new Author("Jph",2);
        System.out.print(author);
    }

    @Test
    public void testSortByNumberOfRevisions(){
        RevisionList revisionList = new RevisionList("Soup");
        System.out.println(revisionList.sortByNumberOfRevisions());
    }

}
