package com.example.UbonGo.view;

import android.graphics.Canvas;

import com.example.UbonGo.Constants;
import com.example.UbonGo.R;
import com.example.UbonGo.controller.MenuController;

import sheep.game.Sprite;
import sheep.game.State;
import sheep.graphics.Font;
import sheep.graphics.Image;
import sheep.gui.TextButton;
import sheep.gui.WidgetAction;
import sheep.gui.WidgetListener;

/**
 * Created by Sindre on 17.03.2016.
 */
public class MainMenuView implements WidgetListener{

    private MenuController controller;
    private TextButton btnStartGame;
    private Image background;
    private Image backgroundLogo;

    public MainMenuView(MenuController controller){
        this.controller=controller;
        btnStartGame = new TextButton(Constants.WIDTH*0.2f,Constants.HEIGHT*0.7f, "Start game");
        background=new Image(R.drawable.ubongo_background_color);
        backgroundLogo=new Image(R.drawable.ubongo_background_text);

        controller.addTouchListener(btnStartGame);
        btnStartGame.addWidgetListener(this);
    }

    public void drawComponents(Canvas canvas){
        background.draw(canvas,0,0);
        backgroundLogo.draw(canvas,(Constants.WIDTH-backgroundLogo.getWidth())*0.5f,(Constants.HEIGHT)*0.15f);
        btnStartGame.draw(canvas);

    }
    public void actionPerformed(WidgetAction action) {
        if (action.getSource() == btnStartGame) {
            controller.btnStartGameClicked(); //Navigates to the lobby
        }
    }


}
