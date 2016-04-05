package com.example.UbonGo.serverManager;

/**
 * Created by Sindre on 17.03.2016.
 */
public class ClientCom implements ServerListener {
    private static ClientCom instance=null;

    public static ClientCom getInstance(){
        if(instance==null){
            instance=new ClientCom();
        }
        return instance;
    }


    /**
     * Called by the startLobbyView. Creates a new lobby with a unique pin on the server.
     * @return The unique pin received from the server
     */
    public String startLobby(){
        //TODO: Implement this method
        return "0000";//Temporary return
    }

    /**
     * Adds a player to a lobby
     * @param player The name of the player
     * @param pin The pin for the lobby which the player should be joined to
     */
    public void joinPlayer(String player, String pin){
        //TODO: Implement this method
        //Should throw IllegalArgumentException if the pin does not exist!!
    }


}
