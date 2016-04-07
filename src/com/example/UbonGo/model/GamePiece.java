package com.example.UbonGo.model;

import java.util.List;

/**
 * Created by Julia on 05/04/2016.
 */
public class GamePiece{

    private final int height;
    private final int width;
    private final boolean[][] blockedCells;

    public GamePiece(int width, int height, List<Integer> blockedCells){
        this.height = height;
        this.width = width;

        //TODO fill blocked cells
        this.blockedCells = new boolean[width][height];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean[][] getBlockedCells() {
        return blockedCells;
    }
}
