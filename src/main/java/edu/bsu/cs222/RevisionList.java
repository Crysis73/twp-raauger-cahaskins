package edu.bsu.cs222;

import java.sql.Timestamp;
import java.util.*;

public class RevisionList{
    private List<Revision> revisionList;

    public RevisionList(String searchTerm){
        RevisionParser parser = new RevisionParser();
        this.revisionList = parser.getRevisions(searchTerm);
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

    public Map<String,Integer> countEditsPerUser(){
        Map<String,Integer> revisionCounter = new HashMap<String, Integer>();
        Integer numberOfRevisions = 1;
        for(int i=0;i<revisionList.size();i++) {
            if(revisionCounter.containsKey(get(i).getUsername())) {
                String key = revisionList.get(i).getUsername();
                Integer replacementValue = revisionCounter.get(key).intValue()+1;
                revisionCounter.replace(key,replacementValue);
            } else {
                revisionCounter.put(revisionList.get(i).getUsername(), numberOfRevisions);
            }
        }
        /*
        Integer[] values = revisionCounter.values().toArray(new Integer[revisionCounter.size()]);
        QuickSort quickSort = new QuickSort(values);
        quickSort.quickSort(values,0,revisionCounter.size());
        System.out.println(quickSort.toString());
        */
        return revisionCounter;

    }

    /*
    public List<Revision> sortByNumberOfEdits(){
       Map<String,Integer> editsPerUser = countEditsPerUser();
       Integer largest = 0;
       for(int i=0;i<editsPerUser.size();i++){
           if(editsPerUser.get(i).intValue()>largest){
               largest = editsPerUser.get(i).intValue();
               sortByNumberOfEdits();
           } else{

           }
       }
    }
    */


    public int size(){
        return revisionList.size();
    }
    public Revision get(int i){
        return revisionList.get(i);
    }


}
