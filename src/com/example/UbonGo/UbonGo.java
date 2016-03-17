package com.example.UbonGo;

import android.app.Activity;
import android.os.Bundle;
import com.example.UbonGo.serverManager.ServerManager;

public class UbonGo extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ServerManager.getInstance().makeTestCall();
        setContentView(R.layout.main);
    }
}
