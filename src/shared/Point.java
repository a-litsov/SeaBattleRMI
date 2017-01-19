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
public class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(!(o instanceof Point))
            return false;
        Point other = (Point)o;
        return (x == other.x) && (y == other.y);
    }
    
    public int hashCode() {
        return x * 31 + y;
    }
}
