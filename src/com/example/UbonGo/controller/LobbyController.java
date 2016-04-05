package com.example.UbonGo.controller;



import android.content.Context;
import android.graphics.Canvas;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.example.UbonGo.Main;
import com.example.UbonGo.model.LobbyModel;
import com.example.UbonGo.serverManager.ClientCom;
import com.example.UbonGo.view.StartLobbyView;
import com.example.UbonGo.view.StartedLobbyView;
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
        this.view=new StartLobbyView(this);
    }

    public void update(float dt){

    }

    public void draw(Canvas canvas){
        view.drawComponents(canvas);
    }

    public void btnBackClicked(){
        main.changeMainController(new MenuController(main));
        ((StartLobbyView) view).removeTextFields();
    }

    public void btnStartNewLobbyClicked(String playerName){
        try{
            if(playerName.length()<1){
                throw  new IllegalArgumentException("Missing player name");
            }
            model=new LobbyModel(playerName, ClientCom.getInstance().startLobby());//The model is only used for the owner
            ((StartLobbyView) view).removeTextFields();
            view=new StartedLobbyView(this,true);
        }
        catch(IllegalArgumentException e){//If the pin does not exist
            e.printStackTrace();//TODO:Implement functionality to write a message about this in the view. This is an important usability tactic
        }



    }

    public void btnStartExistingLobbyClicked(String playerName,String pin){
        try{
            if(playerName.length()<1){
                throw  new IllegalArgumentException("Missing player name");
            }
            ClientCom.getInstance().joinPlayer(playerName, pin);
            ((StartLobbyView) view).removeTextFields();
            view=new StartedLobbyView(this,false);
        }
        catch(IllegalArgumentException e){//If the pin does not exist
            e.printStackTrace();//TODO:Implement functionality to write a message about this in the view. This is an important usability tactic
        }


    }

    public void btnBackToLobbyJoiningClicked(){
        view=new StartLobbyView(this);

    }

    public Main getMain(){
        return main;
    }


}
