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
abstract class Nourriture extends Objet{
    
    protected static final int DUREEMAX =5;
    protected int duree;
    protected Point2D pos;
    
    public Nourriture(){
        this.duree = 3;
        this.pos = new Point2D();
    }
    
    public void tourPasse(){
        this.duree= this.duree-1;
    }
    
}
