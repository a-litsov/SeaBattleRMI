/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.io.Serializable;
import java.util.Hashtable;
import javax.swing.JTable;

/**
 *
 * @author al1as
 */
public class battleField implements Serializable{
    final int maxShipSize = 4;
    final int countShipsBySize[] = {0, 4, 3, 2, 1};
    Hashtable<Cell, Ship> field = new Hashtable<Cell, Ship>();
    
    public boolean initByTableData(Object[][] data) {
        boolean res = true;
        for(int i = 1; i < 11; i++)
            for(int j = 1; j < 11; j++) {
                Object value = data[i][j];
                String content = "";
                if(value != null)
                    content = value.toString();
                if(content.equals("◼")) {
                    Cell c = new Cell(i, j);
                    Ship sh;
                    if(field.get(c) == null) {
                        sh = new Ship();
                      //  field.put(c, sh);
                        scanNear(c, sh, data);
                    } 
                }
            }
        return true; // signals if field correct or not
    }
    
    public Ship getAndRemoveShip(int row, int column) {
        Cell tmpCell = new Cell(row, column);
        Ship tmpShip = field.get(tmpCell);
        if(tmpShip != null) {
            // may be error here (not decreasing in hash, but decreasing in object here)
            tmpShip.decSize();
            field.remove(tmpCell);
        }
        return tmpShip;
    }
    
    public boolean isEmpty() {
        return (field.size() == 0);
    }
   
    private boolean scanByColumn(Cell c, Ship sh, Object[][] data) {
        boolean res = false;
        String content = "◼";
        Object value;
        while(content.equals("◼") && sh.getSize() < maxShipSize && c.row < 11) {
            sh.incSize();
            field.put(c, sh);
            res = true;
            
            c = new Cell(c.row + 1, c.column);
            if(c.row >= 11)
                break;
            else {
                value = data[c.row][c.column];
                content = "";
                if (value != null) {
                    content = value.toString();
                }
            }
        }
        return res;
    }
    
    private boolean scanByRow(Cell c, Ship sh, Object[][] data) {
        boolean res = false;
        String content = "◼";
        Object value;
        while(content.equals("◼") && sh.getSize() < maxShipSize && c.column < 11) {
            sh.incSize();
            field.put(c, sh);
            res = true;
            
            c = new Cell(c.row, c.column + 1);
            if(c.column >= 11)
                break;
            else {
                value = data[c.row][c.column];
                content = "";
                if (value != null) {
                    content = value.toString();
                }
            }
        }
        return res;
    }
    private void scanNear(Cell c, Ship sh, Object[][] data) {
        if(!scanByRow(c, sh, data))
            scanByColumn(c, sh, data);
    }
    
}