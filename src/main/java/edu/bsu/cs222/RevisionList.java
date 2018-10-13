package edu.bsu.cs222;

import java.sql.Timestamp;
import java.util.*;

public class RevisionList{
    private List<Revision> revisionList;
    private String redirects;

    public RevisionList(String searchTerm){
        RevisionParser parser = new RevisionParser(searchTerm);
        this.revisionList = parser.getRevisions();
        this.redirects = parser.getRedirects();
    }

    public List<Revision> sortByTimestamp(){
        for (int i=0;i<revisionList.size();i++){
            for(int j=i+1;j<revisionList.size();j++){
                Timestamp firstTimestamp = revisionList.get(i).getTimestamp();
                Timestamp secondTimestamp = revisionList.get(j).getTimestamp();
                if(firstTimestamp.before(secondTimestamp)){
                    Revision temp = revisionList.get(i);
                    revisionList.set(i,revisionList.get(j) );
                    revisionList.set(j,temp);
                }
            }
        }
        return revisionList;
    }

    public List<Author> generateAuthors(){
        HashSet set = new HashSet();
        Integer numberofEdits = 1;
        List<Author> authors = new LinkedList<>();
        for (Revision aRevisionList : revisionList) {
            String username = aRevisionList.getUsername();

            if (set.add(username)) {
                Author author = new Author(aRevisionList.getUsername(), numberofEdits);
                set.add(username);
                author.addRevision(aRevisionList);
                authors.add(author);
            } else {

                for (Author author : authors) {
                    if (author.getAuthorUsername().equals(username)) {
                        author.addRevision(aRevisionList);
                        author.incrementCount();
                    }
                }

            }
        }
        authors = sortByNumberOfRevisions(authors);
        return authors;
    }

    private List<Author> sortByNumberOfRevisions(List<Author> authorList){
        for(int i=0;i<authorList.size();i++){
            for(int j=i+1;j<authorList.size();j++){
                Integer compareNumberOfEntries = authorList.get(i).getCount();
                Integer secondCompareNumberOfEntries = authorList.get(j).getCount();
                if(compareNumberOfEntries<secondCompareNumberOfEntries){
                    Author tempAuthor = authorList.get(i);
                    authorList.set(i,authorList.get(j));
                    authorList.set(j,tempAuthor);
                }
            }
        }
        return authorList;

    }

    public int size(){
        return revisionList.size();
    }

    public Revision get(int i){
        return revisionList.get(i);
    }

    public boolean isEmpty(){
        return this.revisionList.isEmpty();
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        if(this.redirects!=null){
            result.append("You were redirected to : ").append(redirects).append("\n");
        }
        for(int i =0;i<revisionList.size();i++){
            result.append("Editor ").append(i + 1).append(" -- ").append(revisionList.get(i).toString()).append("\n");
        }
        return result.toString();
    }
}
