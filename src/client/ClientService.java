/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.rmi.*;
import java.rmi.server.*;
import server.IServerConsole;
/**
 *
 * @author al1as
 */
public class ClientService extends UnicastRemoteObject implements IClientService {
    public ClientService() throws RemoteException {
      
    }
}
