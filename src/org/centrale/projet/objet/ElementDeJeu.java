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
abstract class ElementDeJeu {
     protected Point2D pos;

     /**
      * Méthode constructeur de la classe ElementDeJeu
      * @param pos position de l'élément
      */
    public ElementDeJeu(Point2D pos) {
        this.pos = pos;
    }
    
     /**
      * Méthode constructeur de la classe ElementDeJeu
      */
    public ElementDeJeu(){
        this.pos=null;
    }
     
    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos.setX(pos.getX());
        this.pos.setY(pos.getY());
    }


}
