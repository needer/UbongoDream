package com.example.UbonGo;

        import android.app.Activity;
        import android.os.Bundle;

        import sheep.game.Game;

public class Main extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Game game = new Game(this, null);
        setContentView(game);
    }
}
