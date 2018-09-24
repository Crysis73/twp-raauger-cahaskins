package edu.bsu.cs222;

import java.sql.Timestamp;
import java.util.*;

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



   /* public List<Revision> sortByEditsPerUser(){
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

        List<Revision> sortedRevisionList = new LinkedList<Revision>();
        while(!revisionCounter.isEmpty()) {
            Map.Entry<String, Integer> max = null;
            for (Map.Entry<String, Integer> e : revisionCounter.entrySet()) {
                if (max == null || e.getValue() > max.getValue())
                    max = e;
            }
            String mostCommonUsername = max.getKey();
            for (int i = 0; i < revisionList.size(); i++) {
                if (mostCommonUsername == revisionList.get(i).getUsername()) {
                    sortedRevisionList.add(revisionList.get(i));
                    revisionList.remove(i);
                }
            }
            revisionCounter.remove(max);
        }

        return sortedRevisionList;
    }
*/

   /* public List<Revision> sortByNumberOfEdits(){

        Map<String, Integer> editsPerUser = countEditsPerUser();
        Stack<String> usernameStack = new Stack<String>();
        for (Map.Entry<String, Integer> entry : editsPerUser.entrySet())
        {
            for (Map.Entry<String, Integer> secondEntry : editsPerUser.entrySet()){
                if(secondEntry.getValue()>entry.getValue()){
                    usernameStack.push(secondEntry.getKey());
                }
            }
            System.out.println(usernameStack);
        }

        List<Revision> sortedRevisionList = new ArrayList<Revision>();
        while(!usernameStack.empty()) {
            for (int i = 0; i < revisionList.size(); i++) {
                if (usernameStack.peek() == revisionList.get(i).getUsername()){
                    sortedRevisionList.add(revisionList.get(i));
                }

            }
            usernameStack.pop();
        }
        return sortedRevisionList;
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
