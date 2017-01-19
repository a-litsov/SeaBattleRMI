/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

/**
 *
 * @author al1as
 */
public class Ship {
    private int size = 1; // how many alive cells has ship from 0 to 4
    
    public int getSize() {
        return size;
    }
    
    public void incSize() {
        size++;
    }
    
    public void decSize() {
        size--;
    }
}
