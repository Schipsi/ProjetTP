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
    
    protected final int DUREEMAX =5;
    protected int duree;
    protected Point2D pos;
    
    /**
     * Méthode constructeur de la classe Nourriture
     */
    public Nourriture(){
        this.duree = 3;
        this.pos = new Point2D();
    }
    
    /**
     * méthode faisant diminué l'effet d'une nourriture sur le personnage l'ayant mangé
     */
    public void tourPasse(){
        this.duree= this.duree-1;
    }
    
    /**
     * méthode 
     * @param p 
     */
    public void effet(Personnage p){
        
    }
    
    public void finEffet(Personnage p){
        
    }
}
