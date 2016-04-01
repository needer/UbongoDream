package com.example.UbonGo.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.ViewGroup;
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
    private android.view.View layout;
    private String playerNameText="";


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

        //Input-field
        //To make EditText work with sheep, we have to put it as an overlay over the canvas which Sheep is using. To do this we must get the main activity class.
        layout = new LinearLayout(controller.getMain());
        playerName = new EditText(controller.getMain());
        playerName.setVisibility(android.view.View.VISIBLE);
        playerName.setHint("name");
        playerName.setX(DisplayElements.getInstance().getWidth() * 0.5f);
        playerName.setY(DisplayElements.getInstance().getHeight()*0.25f);
        ((LinearLayout)layout).addView(playerName);
        controller.getMain().addContentView(layout,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT));


    }

    public void drawComponents(Canvas canvas){
        background.draw(canvas, 0, 0);
        btnBack.draw(canvas);
        btnTest.draw(canvas);

    }

    public void actionPerformed(WidgetAction action){
        if(action.getSource() == btnBack){
            controller.btnBackClicked();
            ((ViewGroup) layout.getParent()).removeView(layout); //This line removes the EditText
        }
        else if(action.getSource()==btnTest){
            controller.btnTestClicked();

        }
    }

    public void setPinText(){

    }

    public void setPlayerNameText(String text){
        playerNameText=text;
    }
    public String getPlayerNameText(){
        return playerNameText;
    }

}
