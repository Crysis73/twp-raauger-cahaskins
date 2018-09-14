package edu.bsu.cs222;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Query {

    public String getContents(String search){
        URL url = null;
        try {
            url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="+search+"&r%20vprop=timestamp|user&rvlimit=25&redirects");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Scanner s = new Scanner(url.openStream());
            String fileContents = "";
            while(s.hasNext()){
                fileContents += s.nextLine();
            }
            return fileContents;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "nope";
    }
}
