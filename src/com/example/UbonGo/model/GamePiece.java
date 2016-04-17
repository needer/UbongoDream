package com.example.UbonGo.model;

import android.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 05/04/2016.
 */
public class GamePiece{

    private float x;
    private float y;
    private Pair<Integer, Integer> positionOfUpperLeftPiece;
    private ArrayList<Pair<Integer, Integer>> slots; // TODO: Rename if it's weird

    public GamePiece(ArrayList<Pair<Integer, Integer>> slots){
        this.slots = slots;
    }

    public void setNewBoardPosition(Pair<Integer, Integer> newBoardPosition){
        positionOfUpperLeftPiece = newBoardPosition;
    }

    public void setPosition(float x, float y)
    {
        this.x = x;
        this.y = y;
        if (x < 0.5){
            positionOfUpperLeftPiece = null;
        }
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public ArrayList<Pair<Integer, Integer>> getSlots() {
        return slots;
    }

    public Pair<Integer, Integer> getPositionOfUpperLeftPiece() {
        return positionOfUpperLeftPiece;
    }
}
