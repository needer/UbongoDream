package com.example.UbonGo.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.UbonGo.DisplayElements;
import com.example.UbonGo.R;
import com.example.UbonGo.controller.LobbyController;

import sheep.graphics.Image;
import sheep.gui.WidgetAction;
import sheep.gui.WidgetListener;

/**
 * Created by Sindre on 17.03.2016.
 */
public class StartLobbyView implements View, WidgetListener {

    private LobbyController controller;
    private Image background;
    private PictureButton btnBack;
    private EditText playerName;
    private PictureButton btnTest;


    public StartLobbyView(LobbyController controller){
        this.controller=controller;
        background=new Image(R.drawable.ubongo_background_color);

        //Back-button
        btnBack= DisplayElements.getInstance().getBackButton();
        controller.addTouchListener(btnBack);
        btnBack.addWidgetListener(this);

        //Test-button
        btnTest= DisplayElements.getInstance().getPlussButton(50,50);
        controller.addTouchListener(btnTest);
        btnTest.addWidgetListener(this);


    }

    public void drawComponents(Canvas canvas){
        background.draw(canvas, 0, 0);
        btnBack.draw(canvas);
        btnTest.draw(canvas);



        
    }

    public void actionPerformed(WidgetAction action){
        if(action.getSource() == btnBack){
            controller.btnBackClicked();
        }
        else if(action.getSource()==btnTest){
            controller.btnTestClicked();
        }
    }
}
