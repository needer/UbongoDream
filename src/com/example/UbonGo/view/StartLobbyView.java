package com.example.UbonGo.view;

import android.graphics.Canvas;
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
    private EditText txtPlayerName;
    private PictureButton btnStartNewLobby;
    private android.view.View playerNameLayout;
    private android.view.View pinLayout;
    private EditText txtPin;
    private PictureButton btnStartExistingLobby;
    private String startLobby="Start a new lobby:";
    private String joinLobby="Join existing lobby:";
    private String playerName="Player name:";


    public StartLobbyView(LobbyController controller){
        this.controller=controller;
        background=new Image(R.drawable.ubongo_background_color);

        //Back-button
        btnBack = DisplayElements.getInstance().getBackButton();
        controller.addTouchListener(btnBack);
        btnBack.addWidgetListener(this);

        //Start-new-lobby-button
        btnStartNewLobby = DisplayElements.getInstance().getPlussButton(DisplayElements.getInstance().getWidth() * 0.75f, DisplayElements.getInstance().getHeight() * 0.3f);
        controller.addTouchListener(btnStartNewLobby);
        btnStartNewLobby.addWidgetListener(this);

        //Start-existing-lobby-button
        btnStartExistingLobby = DisplayElements.getInstance().getPlussButton(DisplayElements.getInstance().getWidth()*0.75f,DisplayElements.getInstance().getHeight()*0.5f);
        controller.addTouchListener(btnStartExistingLobby);
        btnStartExistingLobby.addWidgetListener(this);


        //To make EditText work with sheep, we have to put it as an overlay over the canvas which Sheep is using. To do this we must get the main activity class.
        playerNameLayout = new LinearLayout(controller.getMain());

        //Input-field for name
        txtPlayerName = new EditText(controller.getMain());
        txtPlayerName.setWidth(Math.round(DisplayElements.getInstance().getWidth() * 0.4f));
        txtPlayerName.setVisibility(android.view.View.VISIBLE);
        txtPlayerName.setHint("name");
        txtPlayerName.setX(DisplayElements.getInstance().getWidth() * 0.45f);
        txtPlayerName.setY(DisplayElements.getInstance().getHeight()*0.05f);
        ((LinearLayout) playerNameLayout).addView(txtPlayerName);

        //Input-field for PIN
        txtPin = new EditText(controller.getMain());
        txtPin.setWidth(Math.round(DisplayElements.getInstance().getWidth()*0.15f));
        txtPin.setVisibility(android.view.View.VISIBLE);
        txtPin.setHint("PIN");
        txtPin.setX(txtPlayerName.getX() - DisplayElements.getInstance().getWidth() * 0.4f);
        txtPin.setY(DisplayElements.getInstance().getHeight() * 0.5f);
        ((LinearLayout) playerNameLayout).addView(txtPin);

        //The LinearLayout is added on top of the canvas
        controller.getMain().addContentView(playerNameLayout,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT));

    }

    public void drawComponents(Canvas canvas){
        background.draw(canvas, 0, 0);
        btnBack.draw(canvas);
        btnStartNewLobby.draw(canvas);
        btnStartExistingLobby.draw(canvas);
        canvas.drawText(playerName, DisplayElements.getInstance().getWidth() * 0.1f, DisplayElements.getInstance().getHeight() * 0.15f, DisplayElements.getInstance().getTextFont(DisplayElements.getInstance().getHeight()));
        canvas.drawText(startLobby, DisplayElements.getInstance().getWidth() * 0.1f, DisplayElements.getInstance().getHeight() * 0.4f, DisplayElements.getInstance().getTextFont(DisplayElements.getInstance().getHeight()));
        canvas.drawText(joinLobby, DisplayElements.getInstance().getWidth()*0.1f, DisplayElements.getInstance().getHeight()*0.6f,DisplayElements.getInstance().getTextFont(DisplayElements.getInstance().getHeight()));
    }

    public void actionPerformed(WidgetAction action){
        if(action.getSource() == btnBack){
            controller.btnBackClicked();
            ((ViewGroup) playerNameLayout.getParent()).removeView(playerNameLayout); //This line removes the EditText
        }
        else if(action.getSource()== btnStartNewLobby){
            controller.btnStartNewLobbyClicked();

        }
        else if(action.getSource()==btnStartExistingLobby){
            controller.btnStartExistingLobbyClicked();
        }
    }



}
