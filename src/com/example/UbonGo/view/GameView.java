package com.example.UbonGo.view;

import android.graphics.Canvas;
import android.util.Pair;
import android.view.MotionEvent;

import com.example.UbonGo.DisplayElements;
import com.example.UbonGo.controller.GameController;
import com.example.UbonGo.model.GameBoard;
import com.example.UbonGo.model.GamePiece;

import sheep.graphics.Image;
import sheep.input.TouchListener;


/**
 * Created by Sindre on 17.03.2016.
 */
public class GameView implements View, TouchListener {
    GameController controller;
    private Image background;
    private GameBoard gameBoard;
    private GamePiece ghostedPiece;

    public GameView(GameController controller)
    {
        this.controller = controller;
        controller.addTouchListener(this);

        background = DisplayElements.getInstance().getBackground();
    }

    public void drawComponents(Canvas canvas){
        background.draw(canvas, 0, 0);

        // Draw board and pieces


        // Draw ghost
        if (ghostedPiece != null)
        {

        }
    }

    /**
     * Updates the board that is drawn.
     * @param board
     */
    public void setGameBoard(GameBoard board)
    {
        gameBoard = board;
    }

    /**
     * Set the ghosted piece.
     * @param ghost
     */
    public void setGhostedPiece(GamePiece ghost)
    {
        ghostedPiece = ghost;
    }

    /**
     * If there's a ghost, this changes its position.
     * @param position
     */
    public void setGhostedPiecePosition(Pair<Float, Float> position)
    {
        if (ghostedPiece != null)
            ghostedPiece.setPosition(position.first, position.second);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        controller.touchDown(
                event.getX() / DisplayElements.getInstance().getWidth(),
                event.getY() / DisplayElements.getInstance().getHeight());
        return false;
    }

    @Override
    public boolean onTouchUp(MotionEvent event) {
        controller.touchUp(
                event.getX() / DisplayElements.getInstance().getWidth(),
                event.getY() / DisplayElements.getInstance().getHeight());
        return false;
    }

    @Override
    public boolean onTouchMove(MotionEvent event) {
        controller.touchMove(
                event.getX() / DisplayElements.getInstance().getWidth(),
                event.getY() / DisplayElements.getInstance().getHeight());
        return false;
    }
}
