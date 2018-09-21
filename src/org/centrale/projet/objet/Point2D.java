/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author grego
 */
public class Point2D {
    
    private int x;
    private int y;
    
    public Point2D(){
            x=0;
            y=0;
        }
    
    public Point2D(int i, int j){
            x=i;
            y=j;
        }
    
    public Point2D(Point2D p){
        x=p.x;
        y=p.y;       
    } 
    
    public void affiche(){
        System.out.println("["+this.x+";"+this.y+"]");
    }
    
    public void translater(int x, int y){
        this.x+=x;
        this.y+=y;
    }
    
    public void modifier(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
