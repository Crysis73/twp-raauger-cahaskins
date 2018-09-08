import org.junit.Assert;
import org.junit.Test;

public class testTWP {
    @Test
    public void testRevisionParser(){
        RevisionParser parser = new RevisionParser();
        int count = parser.countRevisions();
        Assert.assertEquals(4,count);
        //hello
    }
}
