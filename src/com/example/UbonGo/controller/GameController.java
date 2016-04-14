package com.example.UbonGo.controller;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.UbonGo.Main;
import com.example.UbonGo.model.GameBoard;
import com.example.UbonGo.model.GameModel;
import com.example.UbonGo.view.GameView;
import com.example.UbonGo.view.View;

import sheep.game.State;
import sheep.input.TouchListener;

/**
 * Created by Sindre on 17.03.2016.
 */
public class GameController extends State {
    Main main;
    View view;
    GameModel gameModel;

    public GameController(Main m) // TODO: change this so that networking decides what board is played, or something
    {
        main = m;
        view = new GameView(this);
        gameModel = new GameModel(""); //TODO: set boardString
    }

    public void update(float dt){

    }

    public void draw(Canvas canvas){
        view.drawComponents(canvas);
    }

}
