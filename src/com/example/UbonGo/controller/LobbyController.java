package com.example.UbonGo.controller;



import android.content.Context;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.example.UbonGo.Main;
import com.example.UbonGo.model.LobbyModel;
import com.example.UbonGo.view.StartLobbyView;
import com.example.UbonGo.view.View;

import sheep.game.State;
import sheep.input.KeyboardListener;

/**
 * Created by Sindre on 17.03.2016.
 */
public class LobbyController extends State implements KeyboardListener {
    private Main main;
    private LobbyModel model;
    private View view;

    public LobbyController(Main main){
        this.main=main;
        this.model=new LobbyModel();
        this.view=new StartLobbyView(this);
    }

    public void update(float dt){

    }

    public void draw(Canvas canvas){
        view.drawComponents(canvas);
    }

    public void btnBackClicked(){
        main.changeMainController(new MenuController(main));

    }

    public void btnTestClicked(){
        System.out.println("wdesfdhbjsaksODJHVBNM");
        main.openKeyboard();
    }

    public Main getMain(){
        return main;
    }
    public boolean onKeyUp(KeyEvent event){
        char pressedKey = (char) event.getUnicodeChar();
        System.out.println(pressedKey);
        return false;
    }
}
