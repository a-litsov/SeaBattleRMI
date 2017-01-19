/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.*;
import java.rmi.server.*;
import client.IClientService;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author al1as
 */
public class ServerConsole extends UnicastRemoteObject implements IServerConsole {
    final int playersMaxCount = 2;
    int playersConnected = 0;
    int victimId;
    IClientService[] clientObjects;
    
    
    public ServerConsole() throws Exception {
        // Server initialization here
        System.out.println("Initializing SeaBattleRMI server...");
        String serviceName = "rmi://localhost/SeaBattleRMIServerService";
        Naming.rebind(serviceName, this);
        System.out.println("Server object binded");
    }   
     
    
    @Override
    public int registerClient(String clientId) throws RemoteException {
        if(playersConnected > playersMaxCount)
            return -1;
        String objectName = "rmi://localhost/SeaBattleRMIClientService" + clientId;
        if(playersConnected == 0)
            clientObjects = new IClientService[2];
        try {
            clientObjects[playersConnected] = (IClientService) Naming.lookup(objectName);
            System.out.println("Connected client with id:" + clientId);
            System.out.println("His internal id is:" + String.valueOf(playersConnected));
            playersConnected++;
            // who's gonna make first turn?
            if(playersConnected == playersMaxCount) {
                Random rn = new Random();
                int firstTurnPlayerId = rn.nextInt(playersConnected);
                clientObjects[firstTurnPlayerId].getReadyForTurn();
                victimId = playersConnected - firstTurnPlayerId - 1;
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(ServerConsole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServerConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return playersConnected-1;
    }
    
    
    public static void main (String[] args) throws Exception {
        ServerConsole server = new ServerConsole();  
    }    
}
