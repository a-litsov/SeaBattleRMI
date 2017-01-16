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
    int userId = 0;
    int currentId = 0;
    
    public ServerConsole() throws RemoteException {

    }   
    
    @Override
    public boolean Connect(String clientId) throws RemoteException {
        if(userId > 1)
            return false;
        String objectName = "rmi://localhost/SeaBattleClientService" + clientId;
        boolean res = false;
        if(userId == 0)
            clientObjects = new IClientService[2];
        try {
            clientObjects[userId] = (IClientService) Naming.lookup(objectName);
            System.out.println("Getting remote object is done!");
            System.out.println("Connected client with id:" + clientId);
            System.out.println("His internal id is:" + String.valueOf(userId));
            userId++;
            res = true;
        } catch (NotBoundException ex) {
            Logger.getLogger(ServerConsole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServerConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public static void main (String[] args) throws Exception {
        System.out.println("Initializing SeaBattleRMI server...");
        IServerConsole service = new ServerConsole();
        String serviceName = "rmi://localhost/SeaBattleRMIService";
        Naming.rebind(serviceName, service);
        System.out.println("Server object binded");
    }    
}
