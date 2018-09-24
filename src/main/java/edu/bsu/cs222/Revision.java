package edu.bsu.cs222;

import java.sql.Timestamp;

public class Revision {
    private String username;
    private Timestamp timestamp;

    public Revision(String username, Timestamp timestamp){
        this.username = username;
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp(){
        return timestamp;
    }
    public String getUsername(){
        return this.username;
    }


    public String toString(){
        return "Username: "+username+" , Time: "+timestamp;
    }

}
