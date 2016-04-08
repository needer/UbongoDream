package com.example.UbonGo.model;

import java.util.ArrayList;

/**
 * Created by Sindre on 17.03.2016.
 */
public class LobbyModel {
    private ArrayList<String> players;
    private String owner;
    private int difficulty;
    private String pin;

    public LobbyModel(String owner, String pin){
        players=new ArrayList<String>();
        this.owner=owner;
        players.add(owner);
        difficulty=0;
        this.pin=pin;
    }

    public void addplayer(String player){
        int count=0;//Uses this to make sure that players can't have the same name
        for(String p:players){
            if(p.equals(player)){
                count++;
            }
        }
        if(count==0) {
            players.add(player);
        }
        else{
            players.add(player+""+count);
        }
    }

    public void removePlayer(String player){
        players.remove(player);
    }
    public void setDifficulty(int difficulty){
        if(difficulty==0||difficulty==1||difficulty==2){
            this.difficulty=difficulty;
        }
        else{
            throw new IllegalArgumentException("Difficulty can only be 0, 1 og 2");
        }
    }
    public int getDifficulty(){
        return difficulty;
    }
}
