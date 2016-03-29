package com.example.UbonGo.controller;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.UbonGo.model.GameModel;
import com.example.UbonGo.view.View;

import sheep.game.State;
import sheep.input.TouchListener;

/**
 * Created by Sindre on 17.03.2016.
 */
public class GameController extends State implements TouchListener{
    View view;
    GameModel gameModel;

    public void update(float dt){
        
    }

    public void draw(Canvas canvas){
        view.drawComponents(canvas);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        return super.onTouchDown(event);
    }

    @Override
    public boolean onTouchMove(MotionEvent event) {
        return super.onTouchMove(event);
    }

    @Override
    public boolean onTouchUp(MotionEvent event) {
        return super.onTouchUp(event);
    }
}
