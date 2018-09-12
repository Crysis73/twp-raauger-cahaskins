import com.google.gson.JsonArray;
import edu.bsu.cs222.Revision;
import edu.bsu.cs222.RevisionList;
import edu.bsu.cs222.RevisionParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class testTWP {

    @Test
    public void testgetRevisions(){
        RevisionParser parser = new RevisionParser("sample.json");
        List<Revision> revisionList = parser.getRevisions();
        for(int i =0;i<revisionList.size();i++) {
            System.out.println(revisionList.get(i).toString());
        }

    }
    @Test
    public void testgetSortedByTimestampRevisions(){

        RevisionList revisionList = new RevisionList("sample.json");
        revisionList.sortByTimestamp();
        for(int i =0;i<revisionList.size();i++) {
            System.out.println(revisionList.get(i).toString());
        }

    }
//    @Test
//    public void testgetUsername(){
//        RevisionParser parser = new RevisionParser();
//        JsonArray array = parser.getRevisions();
//        String result = parser.getUsername(array,0);
//        Assert.assertEquals("SemiHypercube",result);
//    }
//    @Test
//    public void testgetTimestamp(){
//        RevisionParser parser = new RevisionParser();
//        JsonArray array = parser.getRevisions();
//        String result = parser.getTimestamp(array,0);
//        Assert.assertEquals("2018-08-14T20:34:45Z",result);
//    }
//    @Test
//    public void testgetRevisionList(){
//        RevisionParser parser = new RevisionParser();
//        JsonArray array = parser.getRevisions();
//        List<Revision> revisionList = parser.getRevisionList(array);
//        for(int i =0;i<revisionList.size();i++) {
//            System.out.println(revisionList.get(i).toString());
//        }
//    }
}
