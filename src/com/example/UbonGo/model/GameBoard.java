package com.example.UbonGo.model;

import android.util.Pair;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Julia on 05/04/2016.
 */
public class GameBoard{

    private int width;
    private int height;

    private boolean[][] cellBlockedInBoard;
    private boolean[][] cellFilledWithPiece;

    private List<GamePiece> piecesOnBoard;
    private HashMap<GamePiece, Pair<Integer, Integer>> piecePositions;

    //TODO pieces that are not placed on the board

    public GameBoard(int width, int height, List<Integer> blockedCells){
        this.height = height;
        this.width = width;

        //TODO fill blocked cells
        cellBlockedInBoard = new boolean[width][height];
        cellFilledWithPiece = new boolean[width][height];
    }

    public void addPiece(GamePiece piece){
        piecesOnBoard.add(piece);
        piecePositions.put(piece, null);
    }

    public void removePiece(GamePiece piece){
        piecesOnBoard.remove(piece);
        piecePositions.remove(piece);
    }

    public boolean isCompleted(){
        for (int x = 0; x < cellFilledWithPiece.length; x++){
              for (int y = 0; y < cellFilledWithPiece[x].length; y++){
                  if(cellFilledWithPiece[x][y] == false && cellBlockedInBoard[x][y] == false){
                      return false;
                  }
              }
        }
        return true;
    }


    /***
     * Is the position free from other pieces and belongs to the available part of the gameboard?
     * @param piece
     * @param newPosition
     * @return true, if piece can be placed; false, if piece can not be placed.
     */
    private boolean isPositionFree(GamePiece piece, Pair<Integer, Integer> newPosition){

        for (int x = 0; x <  piece.getWidth(); x++){
            int gameBoardX = newPosition.first + x;
            for (int y = newPosition.second; y < piece.getHeight(); y++){
                int gameBoardY = newPosition.second + y;
                if ((cellFilledWithPiece[gameBoardX][gameBoardY] ||
                        cellBlockedInBoard[gameBoardX][gameBoardY]) && piece.getBlockedCells()[x][y] == false){

                    return false;
                }
            }
        }
        return true;
    }

    /***
     * Tries to set a piece to a new positions.
     * @param piece
     * @param newPosition
     * @return true, if possible; false, if cell already blocked.
     */
    public boolean setNewPiecePosition(GamePiece piece, Pair<Integer, Integer> newPosition){
        //remove piece from old Position
        Pair<Integer, Integer> oldPosition = piecePositions.get(piece);
        for (int x = oldPosition.first; x < oldPosition.first + piece.getWidth(); x++){
            for (int y = oldPosition.second; y < oldPosition.second + piece.getHeight(); y++){
                cellFilledWithPiece[x][y] = false;
                oldPosition = null;
            }
        }

        //set piece to new position, if possible
        if (isPositionFree(piece, newPosition)){
            for (int x = newPosition.first; x < newPosition.first + piece.getWidth(); x++){
                for (int y = newPosition.second; y < newPosition.second + piece.getHeight(); y++){
                    cellFilledWithPiece[x][y] = true;
                    oldPosition = newPosition;
                    return true;
                }
            }
        }
        return false;
    }
}
