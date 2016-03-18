package com.example.UbonGo.view;

import android.graphics.Canvas;
import android.graphics.Typeface;

import com.example.UbonGo.DisplayElements;
import com.example.UbonGo.R;
import com.example.UbonGo.controller.MenuController;

import sheep.graphics.Font;
import sheep.graphics.Image;
import sheep.gui.TextButton;
import sheep.gui.WidgetAction;
import sheep.gui.WidgetListener;

/**
 * Created by Sindre on 18.03.2016.
 */
public class OptionsView implements View, WidgetListener {

    private MenuController controller;
    private Image background;
    private TextButton btnBackToMain;
    private TextButton btnVolumeDown;
    private TextButton btnVolumeUp;
    private String volume;



    public OptionsView(MenuController controller){
        this.controller=controller;
        background=new Image(R.drawable.ubongo_background_color);

        //Back-button
        btnBackToMain=new TextButton(DisplayElements.getInstance().getWidth()*0.01f, DisplayElements.getInstance().getHeight()*0.85f, "back", DisplayElements.getInstance().getButtonFont(DisplayElements.getInstance().getHeight()));
        controller.addTouchListener(btnBackToMain);
        btnBackToMain.addWidgetListener(this);

        //Volume down-button
        btnVolumeDown=new TextButton(DisplayElements.getInstance().getWidth()*0.1f, DisplayElements.getInstance().getHeight()*0.5f, "-", DisplayElements.getInstance().getButtonFont(DisplayElements.getInstance().getHeight()));
        controller.addTouchListener(btnVolumeDown);
        btnVolumeDown.addWidgetListener(this);

        //Volume up-button
        btnVolumeUp=new TextButton(DisplayElements.getInstance().getWidth()*0.3f, DisplayElements.getInstance().getHeight()*0.5f, "+", DisplayElements.getInstance().getButtonFont(DisplayElements.getInstance().getHeight()));
        controller.addTouchListener(btnVolumeUp);
        btnVolumeUp.addWidgetListener(this);



    }

    public void drawComponents(Canvas canvas){
        background.draw(canvas, 0, 0);
        btnBackToMain.draw(canvas);
        btnVolumeDown.draw(canvas);
        btnVolumeUp.draw(canvas);
        //canvas.drawText(volume, 30, 30, new Font(0, 0, 0, 30, Typeface.SANS_SERIF, 1));
        canvas.drawText(volume, DisplayElements.getInstance().getWidth() * 0.2f, DisplayElements.getInstance().getHeight()*0.5f, DisplayElements.getInstance().getTextFont(DisplayElements.getInstance().getHeight()));
    }

    public void changeVolumeText(String volume){
        this.volume=volume;
    }

    public void actionPerformed(WidgetAction action){
        if(action.getSource()==btnBackToMain){
            controller.btnBackToMainClicked();
        }
        else if(action.getSource()==btnVolumeUp){
            controller.btnVolumeUpClicked();
        }
        else if(action.getSource()==btnVolumeDown){
            controller.btnVolumeDownClicked();
        }
    }
}
