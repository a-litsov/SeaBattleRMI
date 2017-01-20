/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.awt.Font;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import server.IServerConsole;

/**
 *
 * @author al1as
 */
public class ClientService extends UnicastRemoteObject implements IClientService{

    javax.swing.JTable myTable, enemyTable;
    javax.swing.JButton saveButton, turnButton, viewEnemyFieldButton;
    javax.swing.JLabel statusLabel, gameResultLabel;
    public Object[][] enemyField;
    
    IServerConsole serverObject;
    UUID id; // unique hash of client
    int playerId;
    
    public ClientService(javax.swing.JTable myTable, javax.swing.JTable enemyTable, javax.swing.JButton saveButton, javax.swing.JButton turnButton,
                javax.swing.JButton viewEnemyFieldButton, javax.swing.JLabel statusLabel, javax.swing.JLabel gameResultLabel) throws RemoteException, MalformedURLException, NotBoundException {
        this.myTable = myTable;
        this.enemyTable = enemyTable;
        this.saveButton = saveButton;
        this.turnButton = turnButton;
        this.statusLabel = statusLabel;
        this.gameResultLabel = gameResultLabel;
        this.viewEnemyFieldButton = viewEnemyFieldButton;
        
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
            myTable.setEnabled(true);
            saveButton.setEnabled(true);
        } else
            System.out.println("Error while connecting..");
    }
    
    @Override
    public void getReadyForTurn() throws RemoteException {
        enemyTable.setEnabled(true);
        turnButton.setEnabled(true);
        statusLabel.setText(statusLabel.getText() + "Ваш ход!");
    }
    
    public int makeTurn(int row, int column) throws RemoteException {
        return serverObject.makeTurn(row, column);
    }
    
    public void takeDamage(int row, int column, int damage) throws RemoteException {
        DefaultTableModel model = (DefaultTableModel)myTable.getModel();
        if(damage == -1)
            model.setValueAt("◉", row, column);
        else
            model.setValueAt("✘", row, column);
        String status = "";
        switch(damage) {
            case -1:
                status = "Соперник промахнулся!";
                break;
            case 0:
                status = "Ваш корабль убит! Соперник ходит снова..";
                break;
            case 1:
                status = "Ваш корабль поврежден! Соперник ходит снова..";
                break;
        }
        statusLabel.setText(status);
    }
    
    public void makeLooser() throws RemoteException {
        gameResultLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        gameResultLabel.setForeground(Color.RED);
        gameResultLabel.setText("Вы проиграли!");
        statusLabel.setText("Ваш последний корабль убит!");
        
        enemyField = serverObject.getEnemyFiled(1 - playerId);
        viewEnemyFieldButton.setVisible(true);
    }
    public void makeWinner() throws RemoteException {
        gameResultLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        gameResultLabel.setForeground(Color.GREEN);
        gameResultLabel.setText("Вы победили!");  
    }
    
    public Object[][] convertTableData (javax.swing.JTable table) {
        javax.swing.table.TableModel dtm = table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0 ; i < nRow ; i++)
            for (int j = 0 ; j < nCol ; j++)
                tableData[i][j] = dtm.getValueAt(i,j);
        return tableData;
    }
    
    public void sendTableData() throws RemoteException {
        Object[][] data = convertTableData(myTable);
        serverObject.sendTableData(data, playerId);
    }
    
    public Object[][] getTableData() throws RemoteException {
        Object[][] data = convertTableData(myTable);
        return data;
    }
}
