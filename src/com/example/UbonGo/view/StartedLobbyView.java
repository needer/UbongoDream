package com.example.UbonGo.view;

import android.graphics.Canvas;

import com.example.UbonGo.DisplayElements;
import com.example.UbonGo.controller.LobbyController;

import sheep.graphics.Image;
import sheep.gui.WidgetAction;
import sheep.gui.WidgetListener;

/**
 * Created by Sindre on 17.03.2016.
 */
public class StartedLobbyView implements View, WidgetListener {

    private boolean isOwner;
    private Image background;
    private LobbyController controller;
    private PictureButton btnBackToLobbyJoining;

    public StartedLobbyView(LobbyController controller, boolean isOwner){
        this.controller=controller;
        this.isOwner=isOwner;
        background= DisplayElements.getInstance().getBackground();

        //Back-button
        btnBackToLobbyJoining = DisplayElements.getInstance().getBackButton();
        controller.addTouchListener(btnBackToLobbyJoining);
        btnBackToLobbyJoining.addWidgetListener(this);

    }

    public void drawComponents(Canvas canvas){
        background.draw(canvas, 0, 0);
        btnBackToLobbyJoining.draw(canvas);
    }

    public void actionPerformed(WidgetAction action){
        if(action.getSource() == btnBackToLobbyJoining){
            controller.btnBackToLobbyJoiningClicked();
        }
    }
}
