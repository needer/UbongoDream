package com.example.UbonGo.model;

import android.util.Pair;

import sheep.game.Game;

/**
 * Created by Sindre on 17.03.2016.
 */
public class GameModel {

    private GameBoard board;

    public GameModel(String boardData)
    {
        // TODO: Use board data to generate board.
    }

    public GameBoard getBoard()
    {
        return board;
    }

    public void movePieceToOn(Pair<Float, Float> position, Pair<Integer, Integer> boardRelativeCoordinate)
    {
        // TODO: This function will checks if it can be moved, and do so if yes.
    }

    public void movePieceToOff(Pair<Float, Float> startPosition, Pair<Float, Float> endPosition)
    {
        GamePiece p = getPiece(startPosition);
        p.setPosition(endPosition.first, endPosition.second);
    }

    public GamePiece getPiece(Pair<Float, Float> pos)
    {
        // TODO: Return the piece at that location on the "screen"
        return null;
    }

    public void rotate(Pair<Float, Float> pos)
    {
        // TODO: Rotate the piece at that location
    }

    public void flip(Pair<Float, Float> pos)
    {
        // TODO: Flip it along the y axis
    }

    public void undo()
    {
        // TODO: Make this undo your last move.
    }

    public boolean isCompleted()
    {
        // TODO: Is the board completed yet?
        return false;
    }



}

