package com.example.UbonGo.controller;

import android.graphics.Canvas;
import android.widget.Button;

import com.example.UbonGo.Main;
import com.example.UbonGo.view.MainMenuView;

import sheep.game.State;
import sheep.gui.WidgetAction;
import sheep.gui.WidgetListener;

/**
 * Created by Sindre on 17.03.2016.
 */

public class MenuController extends State{
    private MainMenuView view;
    private Main main;

    public MenuController(Main main){
        view =new MainMenuView(this);
        this.main=main;
    }

    public void update(float dt){

    }

    public void draw(Canvas canvas){
        view.drawComponents(canvas);

    }
    /**
     * Navigates to the lobby by setting the LobbyController as the new state
     */
    public void btnStartGameClicked(){
        main.changeMainController(new LobbyController(main));
    }



}
