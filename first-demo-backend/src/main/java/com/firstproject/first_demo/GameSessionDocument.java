package com.firstproject.first_demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GameSessionDocument {
    @Id
    private String gameId;
    private int guessingNumber;
    private String userFullName;
    private Boolean isGameFinished=false;
    public GameSessionDocument(int guessingNumber,String userFullName){
        super();
        this.guessingNumber = guessingNumber;
        this.userFullName = userFullName;
    }
    // set methods----------------------------------------------------------------------
    public void setGuessingNumber(int number){
        this.guessingNumber = number;
    }
    public void setUserFullName(String fullName){
        this.userFullName = fullName;
    }
    public void setIsGameFinished(Boolean isFinished){
        this.isGameFinished = isFinished;
    }

    //get methods-----------------------------------------------------------------------------
    public String getGameId(){
        return this.gameId;
    }
    public int getGuessingNumber(){
        return this.guessingNumber;
    }
    public String getUserFullName(){
        return this.userFullName;
    }
    public boolean getIsGameFinished(){
        return this.isGameFinished;
    }
}
