package com.example.UbonGo.view;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.UbonGo.DisplayElements;
import com.example.UbonGo.controller.GameController;

import sheep.graphics.Image;
import sheep.input.TouchListener;


/**
 * Created by Sindre on 17.03.2016.
 */
public class GameView implements View, TouchListener {
    GameController controller;
    private Image background;

    public GameView(GameController controller)
    {
        this.controller = controller;
        controller.addTouchListener(this);

        background = DisplayElements.getInstance().getBackground();
    }

    public void drawComponents(Canvas canvas){
        background.draw(canvas,0,0);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        System.out.println("Touch down");
        return false;
    }

    @Override
    public boolean onTouchUp(MotionEvent event) {
        System.out.println("Touch up");
        return false;
    }

    @Override
    public boolean onTouchMove(MotionEvent event) {
        System.out.println("Touch move");
        return false;
    }
}
