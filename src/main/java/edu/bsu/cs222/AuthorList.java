package edu.bsu.cs222;

import java.util.List;

public class AuthorList {
    private List<Author> authors;

    public AuthorList(String searchTerm){
        RevisionList revisions = new RevisionList(searchTerm);
        this.authors = revisions.generateAuthors();
    }
    public String toString(){
        String result = "";
        for(int i = 0;i<authors.size();i++){
            result += "Editor #" + (i+1) + " | "+authors.get(i).toString();
        }
        return result;
    }
}
