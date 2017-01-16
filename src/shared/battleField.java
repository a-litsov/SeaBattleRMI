/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.util.Hashtable;
import javax.swing.JTable;

/**
 *
 * @author al1as
 */
public class battleField {
    Hashtable<Point, Ship> field = new Hashtable<Point, Ship>();
    public battleField(JTable table) {
        for(int i = 1; i < 11; i++)
            for(int j = 1; j < 11; j++) {
                Object value = (String)table.getModel().getValueAt(i, j);
                String content = "";
                if(value != null)
                    content = value.toString();
                if(content.equals("*")) {
                    Point p = new Point(i, j);
                    Ship sh;
                    if(field.get(p) == null) {
                        sh = new Ship();
                        field.put(p, sh);
                        scanNear(p, sh, table);
                    } 
                }
            }
    }
   
    
    private void scanNear(Point p, Ship sh, JTable table) {
        if(sh.getSize() > 3)
            return;
        boolean flag = false;
        Point newPoint;
        newPoint = new Point(p.x + 1, p.y);
        Object value = (String)table.getModel().getValueAt(newPoint.x, newPoint.y);
        String content = "";
        if(value != null)
            content = value.toString();
        while(content.equals("*") && sh.getSize() < 4 && p.x < 11) {
            field.put(newPoint, sh);
            sh.incSize();
            newPoint.x++;
            value = (String)table.getModel().getValueAt(newPoint.x, newPoint.y);
            content = "";
            if(value != null)
                content = value.toString();
            flag = true;
        }
        if(flag) return;
        newPoint = new Point(p.x, p.y + 1);
        value = (String)table.getModel().getValueAt(newPoint.x, newPoint.y);
        content = "";
        if(value != null)
            content = value.toString();
        newPoint = new Point(p.x, p.y + 1);
        while(content.equals("*") && sh.getSize() < 4 && p.y < 11) {
            field.put(new Point(p.x, p.y + 1), sh);
            sh.incSize();
            newPoint.y++;
            value = (String)table.getModel().getValueAt(newPoint.x, newPoint.y);
            content = "";
            if(value != null)
                content = value.toString();

        }
    }
    
}