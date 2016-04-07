package com.example.UbonGo.model;

/**
 * Created by Sindre on 17.03.2016.
 */
public class GameModel {

    private GameBoard board;
    private int pin;

   public void setBoard(GameBoard board){
        this.board = board;
   }

    public void setPin(int pin){
        this.pin = pin;
    }

    public GameBoard getBoard(){
        return board;
    }

    public int getPin(){
        return pin;
    }
}

