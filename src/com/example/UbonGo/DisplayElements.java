package com.example.UbonGo;

import android.graphics.Paint;
import android.graphics.Typeface;

import com.example.UbonGo.view.PictureButton;

import sheep.graphics.Font;

/**
 * Created by Sindre on 17.03.2016.
 */
public class DisplayElements {

    private static DisplayElements instance=null;

    public static DisplayElements getInstance(){
        if(instance==null){
            instance=new DisplayElements();
        }
        return instance;
    }
    //The screen width, set in main inCreate
    private int width;

    //The screen height, set in main inCreate
    private int height;



    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return  height;
    }

    public void setHeight(int height){
        this.height=height;
    }

    public void setWidth(int width){
        this.width=width;
    }


    //Font used for all the buttons in the game
    public Paint[] getButtonFont(int screenHeight){
        Paint[] font= {new Font(255, 255, 255, screenHeight*0.07F, Typeface.SANS_SERIF, 1),new Font(255, 0, 0, screenHeight*0.07F, Typeface.SANS_SERIF, 1)};
        return font;

    }

    //Font used for text in the game
    public Paint getTextFont(int screenHeight){
        Paint font= new Font(255, 255, 255, screenHeight*0.07F, Typeface.SANS_SERIF, 1);
        return font;

    }

    public PictureButton getBackButton(){
        return new PictureButton(R.drawable.back_button,getWidth()*0.05f,getHeight()*0.7f);
    }

}
