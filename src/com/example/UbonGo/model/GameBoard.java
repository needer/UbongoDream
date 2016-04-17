package com.example.UbonGo.model;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 05/04/2016.
 */
public class GameBoard{

    private int maxNumberOfSlotsHorizontal;
    private int maxNumberOfSlotsVertical;

    private ArrayList<GamePiece> piecesOnBoard;
    private ArrayList<Pair<Integer, Integer>> slots;

    public GameBoard(int maxNumberOfSlotsHorizontal, int maxNumberOfSlotsVertical, ArrayList<Pair<Integer, Integer>> slots){
        piecesOnBoard = new ArrayList<>();
        this.maxNumberOfSlotsHorizontal = maxNumberOfSlotsHorizontal;
        this.maxNumberOfSlotsVertical = maxNumberOfSlotsVertical;
        this.slots = slots;
    }

    public void addPiece(GamePiece piece){
        piecesOnBoard.add(piece);
    }

    public boolean isCompleted(){
        for (Pair<Integer, Integer> slot : slots){
            boolean slotHasPiece = false;
            for (GamePiece piece : piecesOnBoard){
                Pair<Integer, Integer> piecePosition = piece.getPositionOfUpperLeftPiece();
                for (Pair<Integer,Integer> pieceSlot : piece.getSlots()) {
                    if (piecePosition != null) {
                        if (piecePosition.first + pieceSlot.first == slot.first && piecePosition.second + pieceSlot.second == slot.second) {
                            slotHasPiece = true;
                        }
                    }
                }
            }
            if (slotHasPiece == false) {
                return false;
            }
        }
        return true;
    }


    /***
     * Is the position free from other pieces and belongs to the available part of the gameboard?
     * @param newPiece
     * @param newPosition
     * @return true, if piece can be placed; false, if piece can not be placed.
     */
    private boolean isPositionFree(GamePiece newPiece, Pair<Integer, Integer> newPosition){

        for (Pair<Integer, Integer> newPieceSlot : newPiece.getSlots()){
            //check if there is a slot at the board
            boolean slotAvailable = false;
            for (Pair<Integer,Integer> boardSlot : slots){
                if (newPosition.first + newPieceSlot.first == boardSlot.first && newPosition.second + newPieceSlot.second == boardSlot.second){
                    slotAvailable = true;
                }
            }
            if (slotAvailable == false){
                return false;
            }

            //check if the slot is free
            for (GamePiece otherPiece : piecesOnBoard){
                Pair<Integer, Integer> otherPiecePosition = otherPiece.getPositionOfUpperLeftPiece();
                if (otherPiecePosition != null) {
                    for (Pair<Integer, Integer> otherPieceSlot : otherPiece.getSlots()) {
                        if (otherPiecePosition.first + otherPieceSlot.first == newPosition.first + newPieceSlot.first &&
                                otherPiecePosition.second + otherPieceSlot.second == newPosition.second + newPieceSlot.second){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /***
     * Tries to set a piece to a new positions.
     * @param piece
     * @param newPosition
     */
    public void setNewPiecePosition(GamePiece piece, Pair<Integer, Integer> newPosition){
        if (isPositionFree(piece, newPosition)){
            Pair<Float, Float> totalPosition = calculateTotalPosition(newPosition);
            piece.setPosition(totalPosition.first, totalPosition.second);
            piece.setNewBoardPosition(newPosition);
        }
    }

    private Pair<Float, Float> calculateTotalPosition(Pair<Integer, Integer> slot){
        float x = slot.first / maxNumberOfSlotsVertical * 0.5f + 0.5f; //magic numbers -> only right half
        float y = slot.second / maxNumberOfSlotsHorizontal;
        return new Pair<Float, Float>(x, y);
    }

    private Pair<Integer, Integer> calculateSlot(float x, float y){
        int slotXIndex = (int)((x - 0.5f) * 2.0f * maxNumberOfSlotsVertical); //magic numbers -> only right half
        int slotYIndex = (int)(y * maxNumberOfSlotsHorizontal);

        return new Pair<Integer, Integer>(slotXIndex, slotYIndex);
    }

    public GamePiece getPiece(float x, float y) {
        Pair<Integer, Integer> boardSlot = calculateSlot(x, y);
        for (GamePiece piece : piecesOnBoard){
            for (Pair<Integer,Integer> pieceSlot : piece.getSlots()){
                Pair<Integer, Integer> piecePosition = piece.getPositionOfUpperLeftPiece();
                if (piecePosition != null) {
                    if (piecePosition.first + pieceSlot.first == boardSlot.first &&
                            piecePosition.second + pieceSlot.second == boardSlot.second) {
                        return piece;
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Pair<Integer, Integer>> getSlots()
    {
        return slots;
    }

    public ArrayList<GamePiece> getPiecesOnBoard()
    {
        return piecesOnBoard;
    }
}


