package com.example.UbonGo.model;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 05/04/2016.
 */
public class GamePiece{

    private float x;
    private float y;
    private List<Pair<Integer, Integer>> slots; // TODO: Rename if it's weird

    public GamePiece(List<Integer> blockedCells){

        //TODO fill blocked cells
    }

    public void setPosition(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

}
