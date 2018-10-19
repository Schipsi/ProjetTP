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
abstract class Objet extends ElementDeJeu{
    
    /**
     * position actuelle en 2 dimensions de l'objet 
     */
    protected Point2D pos;
    
    /**
     * méthode constructeur de la classe Objet prenant en compte les paramètres suivants 
     * @param pos position de l'objet
     */
    public Objet(
        Point2D pos
    ) {
        this.pos = new Point2D(pos.getX(), pos.getY());
    }
    
    /**
     * méthode constructeur faisant une copie d'un autre objet
     * @param o Objet 
     */
    public Objet(Objet o) {
        this.pos = new Point2D(o.pos.getX(), o.pos.getY());
    }
    
    /**
     * méthode constructeur de la classe Creature sans paramètres
     */
    public Objet() {
        this.pos = new Point2D();
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
}
