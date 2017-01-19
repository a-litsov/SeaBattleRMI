/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.*;

/**
 *
 * @author al1as
 */
public interface IServerConsole  extends Remote{
    public int registerClient(String clientServiceName) throws RemoteException;  
    
}
