package edu.bsu.cs222;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Stream;

public class RevisionList{
    private List<Revision> revisionList;

    public RevisionList(String searchTerm){
        RevisionParser parser = new RevisionParser(searchTerm);
        this.revisionList = parser.getRevisions();

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
        Set<String> set = new HashSet();
        Integer numberofEdits = 1;
        List<Author> authors = new LinkedList<Author>();
        for(int i =0;i<revisionList.size();i++){
            String username = revisionList.get(i).getUsername();
            Revision revision = revisionList.get(i);

            if( set.add(username) == true){
                Author author = new Author(revisionList.get(i).getUsername(),numberofEdits);
                set.add(username);
                author.addRevision(revision);
                authors.add(author);
            } else{

                for(int j =0;j<authors.size();j++){
                    if(authors.get(j).getAuthorUsername().equals(username)) {
                        authors.get(j).addRevision(revision);
                        authors.get(j).incrementCount();
                    }
                }

            }
        }
        for(int i=0;i<authors.size();i++){
            Integer compareNumberOfEntries = authors.get(i).getCount();
            for(int j=i+1;j<authors.size();j++){
                Integer secondCompareNumberOfEntries = authors.get(j).getCount();
                if(compareNumberOfEntries<secondCompareNumberOfEntries){
                    Author tempAuthor = authors.get(i);
                    authors.set(i,authors.get(j));
                    authors.set(j,tempAuthor);
                }
            }
        }
        authors = sortByNumberOfRevisions(authors);
        return authors;
    }


    public List<Author> sortByNumberOfRevisions(List<Author> authorList){
        for(int i=0;i<authorList.size();i++){
            Integer compareNumberOfEntries = authorList.get(i).getCount();
            for(int j=i+1;j<authorList.size();j++){
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
        if(this.revisionList.isEmpty()){
            return true;
        }
        return false;
    }

    public String toString(){
        String result = "";
        for(int i =0;i<revisionList.size();i++){
            result+= "Editor " + (i+1) + " -- " + revisionList.get(i).toString() + "\n";
        }
        return result;
    }
}
