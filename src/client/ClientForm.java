/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.MalformedURLException;
import java.rmi.*;
import server.IServerConsole;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import shared.battleField;

/**
 *
 * @author al1as
 */
public class ClientForm extends javax.swing.JFrame {
    IClientService clientService;
    /**
     * Creates new form clientForm
     */
    public ClientForm() throws RemoteException, MalformedURLException, NotBoundException {
        initComponents();
        clientService = new ClientService(myTable, enemyTable, saveButton, turnButton, statusLabel);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        enemyTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        turnButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        enemyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К"},
                {"1", null, null, null, null, null, null, null, null, null, null},
                {"2", null, null, null, null, null, null, null, null, null, null},
                {"3", null, null, null, null, null, null, null, null, null, null},
                {"4", null, null, null, null, null, null, null, null, null, null},
                {"5", null, null, null, null, null, null, null, null, null, null},
                {"6", null, null, null, null, null, null, null, null, null, null},
                {"7", null, null, null, null, null, null, null, null, null, null},
                {"8", null, null, null, null, null, null, null, null, null, null},
                {"9", null, null, null, null, null, null, null, null, null, null},
                {"10", null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "null", "Title 5", "null", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enemyTable.setColumnSelectionAllowed(true);
        enemyTable.setEnabled(false);
        enemyTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(enemyTable);
        enemyTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (enemyTable.getColumnModel().getColumnCount() > 0) {
            enemyTable.getColumnModel().getColumn(0).setResizable(false);
            enemyTable.getColumnModel().getColumn(1).setResizable(false);
            enemyTable.getColumnModel().getColumn(2).setResizable(false);
            enemyTable.getColumnModel().getColumn(3).setResizable(false);
            enemyTable.getColumnModel().getColumn(4).setResizable(false);
            enemyTable.getColumnModel().getColumn(5).setResizable(false);
            enemyTable.getColumnModel().getColumn(6).setResizable(false);
            enemyTable.getColumnModel().getColumn(7).setResizable(false);
            enemyTable.getColumnModel().getColumn(8).setResizable(false);
            enemyTable.getColumnModel().getColumn(9).setResizable(false);
            enemyTable.getColumnModel().getColumn(10).setResizable(false);
        }

        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К"},
                {"1", null, null, null, null, null, null, null, null, null, null},
                {"2", null, null, null, null, null, null, null, null, null, null},
                {"3", null, null, null, null, null, null, null, null, null, null},
                {"4", null, null, null, null, null, null, null, null, null, null},
                {"5", null, null, null, null, null, null, null, null, null, null},
                {"6", null, null, null, null, null, null, null, null, null, null},
                {"7", null, null, null, null, null, null, null, null, null, null},
                {"8", null, null, null, null, null, null, null, null, null, null},
                {"9", null, null, null, null, null, null, null, null, null, null},
                {"10", null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "null", "Title 5", "null", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11"
            }
        ));
        myTable.setColumnSelectionAllowed(true);
        myTable.setEnabled(false);
        myTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(myTable);
        myTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (myTable.getColumnModel().getColumnCount() > 0) {
            myTable.getColumnModel().getColumn(0).setResizable(false);
            myTable.getColumnModel().getColumn(1).setResizable(false);
            myTable.getColumnModel().getColumn(2).setResizable(false);
            myTable.getColumnModel().getColumn(3).setResizable(false);
            myTable.getColumnModel().getColumn(4).setResizable(false);
            myTable.getColumnModel().getColumn(5).setResizable(false);
            myTable.getColumnModel().getColumn(6).setResizable(false);
            myTable.getColumnModel().getColumn(7).setResizable(false);
            myTable.getColumnModel().getColumn(8).setResizable(false);
            myTable.getColumnModel().getColumn(9).setResizable(false);
            myTable.getColumnModel().getColumn(10).setResizable(false);
        }

        saveButton.setText("Сохранить поле");
        saveButton.setEnabled(false);
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        turnButton.setText("Сделать ход");
        turnButton.setEnabled(false);
        turnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnButtonActionPerformed(evt);
            }
        });

        statusLabel.setText("Статус");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(saveButton)
                                .addGap(217, 217, 217)
                                .addComponent(turnButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(statusLabel)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(turnButton))
                .addGap(18, 18, 18)
                .addComponent(statusLabel)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void turnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnButtonActionPerformed
        int row = enemyTable.getSelectedRow();
        int column = enemyTable.getSelectedColumn();
        try {
            turnButton.setEnabled(false);
            enemyTable.setEnabled(false);
            clientService.makeTurn(row, column);
            // Переместить в проверку попадания
        } catch (RemoteException E) {
            
        }
    }//GEN-LAST:event_turnButtonActionPerformed

    public Object[][] getTableData (javax.swing.JTable table) {
        javax.swing.table.TableModel dtm = table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0 ; i < nRow ; i++)
            for (int j = 0 ; j < nCol ; j++)
                tableData[i][j] = dtm.getValueAt(i,j);
        return tableData;
    }
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Object[][] data = getTableData(myTable);
        try {
            saveButton.setEnabled(false);
            myTable.setEnabled(false);
            // Add checking result later (rules for field)
            clientService.sendTableData(data);
        } catch(RemoteException e) {
            System.out.println("Error!Can't send battlefield to server!");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ClientForm().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable enemyTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable myTable;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton turnButton;
    // End of variables declaration//GEN-END:variables
}
