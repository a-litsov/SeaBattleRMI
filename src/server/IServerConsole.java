/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.*;
import server_additional.battleField;

/**
 *
 * @author al1as
 */
public interface IServerConsole  extends Remote{
    public int registerClient(String clientServiceName) throws RemoteException;  
    public boolean sendTableData(Object[][] data, int playerId) throws RemoteException;
    public int makeTurn(int row, int column) throws RemoteException;
    public Object[][] getEnemyFiled(int enemyId) throws RemoteException;
}
