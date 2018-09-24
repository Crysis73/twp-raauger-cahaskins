package edu.bsu.cs222;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private List<Revision> revisionsByAuthor;
    private String authorUsername;
    private Integer count;

    public Author(String username){
        this.authorUsername = username;
        this.revisionsByAuthor = new ArrayList<Revision>();
        this.count = revisionsByAuthor.size();
    }

    public void addRevision(Revision revision){
        revisionsByAuthor.add(revision);
    }

    public Integer getCount(){
        return count;
    }


}
