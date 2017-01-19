/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.io.Serializable;

/**
 *
 * @author al1as
 */
public class Cell implements Serializable {
    int row, column;
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(!(o instanceof Cell))
            return false;
        Cell other = (Cell)o;
        return (row == other.row) && (column == other.column);
    }
    
    public int hashCode() {
        return row * 31 + column;
    }
}
