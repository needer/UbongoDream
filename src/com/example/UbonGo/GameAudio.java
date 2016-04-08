package com.example.UbonGo;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

/**
 * Created by Naptop on 08.04.2016.
 */
public class GameAudio implements OnLoadCompleteListener
{
    private static GameAudio instance;

    public static GameAudio getInstance()
    {
        if (instance == null)
            instance = new GameAudio();
        return instance;
    }

    private GameAudio()
    {

    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status)
    {

    }

    public void play(int id)
    {

    }

    public void forcePlay(int id)
    {

    }

    public void stopAll()
    {
        
    }
}
