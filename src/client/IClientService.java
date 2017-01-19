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
    public void sendTableData(Object[][] data) throws RemoteException;
    public void makeTurn(int row, int column) throws RemoteException;
    public void takeDamage(int row, int column, int damage) throws RemoteException;
}
