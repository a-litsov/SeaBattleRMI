/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.rmi.*;
import shared.battleField;
/**
 *
 * @author al1as
 */
public interface IClientService extends Remote {
    public void getReadyForTurn() throws RemoteException;
    public boolean sendTableData() throws RemoteException;
    public Object[][] getTableData() throws RemoteException;
    public int makeTurn(int row, int column) throws RemoteException;
    public void takeDamage(int row, int column, int damage) throws RemoteException;
    public void makeLooser() throws RemoteException;
    public void makeWinner() throws RemoteException;
}
