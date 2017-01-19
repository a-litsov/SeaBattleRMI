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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author al1as
 */
public class ServerConsole extends UnicastRemoteObject implements IServerConsole {
    
    IClientService[] clientObjects;
    int curPlayerId = 0; // id of player whose turn is now
    
    public ServerConsole() throws Exception {
        // Server initialization here
        System.out.println("Initializing SeaBattleRMI server...");
        String serviceName = "rmi://localhost/SeaBattleRMIServerService";
        Naming.rebind(serviceName, this);
        System.out.println("Server object binded");
    }   
    
    @Override
    public int registerClient(String clientId) throws RemoteException {
        if(curPlayerId > 1)
            return -1;
        String objectName = "rmi://localhost/SeaBattleRMIClientService" + clientId;
        if(curPlayerId == 0)
            clientObjects = new IClientService[2];
        try {
            clientObjects[curPlayerId] = (IClientService) Naming.lookup(objectName);
            System.out.println("Connected client with id:" + clientId);
            System.out.println("His internal id is:" + String.valueOf(curPlayerId));
        } catch (NotBoundException ex) {
            Logger.getLogger(ServerConsole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServerConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curPlayerId++;
    }
    
    
    public static void main (String[] args) throws Exception {
        ServerConsole server = new ServerConsole();  
    }    
}
