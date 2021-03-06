package edu.bsu.cs222;

import com.sun.org.apache.regexp.internal.RE;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Author {
    private List<Revision> revisionsByAuthor;
    private String authorUsername;
    private Integer count;

    public Author(String username, Integer count){
        this.authorUsername = username;
        this.revisionsByAuthor = new ArrayList<Revision>();
        this.count = count;
    }

    public void addRevision(Revision revision){
        revisionsByAuthor.add(revision);

    }

    public Integer getCount(){
        return count;
    }

    public String getAuthorUsername(){
        return authorUsername;
    }

    public String toString(){
        String result = "";
        result += authorUsername + "\n \tNumber of Edits: " + count ;
        for(int i =0;i<revisionsByAuthor.size();i++) {
            result += "\n \t\tRevision# : " + (i+1) + " " + revisionsByAuthor.get(i);
            if(i == revisionsByAuthor.size()-1){
                result+= "\n";
            }
        }
        result.replaceAll(",","");
        return result;
    }

    public void incrementCount(){
        count++;
    }



}
