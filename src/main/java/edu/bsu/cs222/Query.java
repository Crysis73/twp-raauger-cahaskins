package edu.bsu.cs222;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Query {

    public Reader getContents(String search) throws IOException {
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="+search+"&r%20vprop=timestamp%7Cuser&rvlimit=25&redirects");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "Revision Tracker/0.1 (me@bsu.edu)");
        Reader in = new InputStreamReader(connection.getInputStream());

        return in;

    }
}
