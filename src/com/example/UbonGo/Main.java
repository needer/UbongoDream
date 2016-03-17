package com.example.UbonGo;

import android.app.Activity;
import android.os.Bundle;

import com.example.UbonGo.controller.MenuController;
import com.example.UbonGo.serverManager.ServerManager;

import sheep.game.Game;
import sheep.game.State;

public class Main extends Activity {
    /**
     * Called when the activity is first created.
     */
    private Game game;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game(this, null);
        // Push the main state.
        game.pushState(new MenuController()); //This displays the main menu when the game is opened.
        // View the game.
        setContentView(game);
    }

    /**
     * Called when you want to change the state, for instance when you want too go from main menu to lobby
     * @param controller the controller-class you want to change to
     */
public void changeMainController(State controller){
    game.pushState(controller);
}
}

