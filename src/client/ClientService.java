/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;
import server.IServerConsole;

/**
 *
 * @author al1as
 */
public class ClientService extends UnicastRemoteObject implements IClientService{

    javax.swing.JTable myTable, enemyTable;
    javax.swing.JButton saveButton;
    javax.swing.JLabel statusLabel;
    
    IServerConsole serverObject;
    UUID id; // unique hash of client
    int playerId;
    
    public ClientService(javax.swing.JTable myTable, javax.swing.JTable enemyTable, javax.swing.JButton saveButton, 
                javax.swing.JLabel statusLabel) throws RemoteException, MalformedURLException, NotBoundException {
        this.myTable = myTable;
        this.enemyTable = enemyTable;
        this.saveButton = saveButton;
        this.statusLabel = statusLabel;
        
        id = UUID.randomUUID();
        String serviceName = "rmi://localhost/SeaBattleRMIClientService" + id.toString();
        Naming.rebind(serviceName, this);
        
        String objectName = "rmi://localhost/SeaBattleRMIServerService";
        System.out.println("Starting HelloRMI client...");
        serverObject = (IServerConsole)Naming.lookup(objectName);
        System.out.println("Getting remote server object is done!");
        playerId = serverObject.registerClient(id.toString());
        System.out.println("Registered to server with id: " + id.toString() + " and playerId: " + playerId);
        if(playerId != -1) {
            System.out.println("Connecting is done!");
        } else
            System.out.println("Error while connecting..");
    }
    
    @Override
    public void getReadyForTurn() throws RemoteException {
        myTable.setEnabled(true);
        saveButton.setEnabled(true);   
        statusLabel.setText("Your turn!");
    }
}
