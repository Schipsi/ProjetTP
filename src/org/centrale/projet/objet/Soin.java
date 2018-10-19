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
public class Soin extends Potion{
       
    /**
     * méthode constructeur de la classe Soin prenant en compte les paramètres suivants 
     * @param ptRegen
     * @param pos
     */
    public Soin(
        int ptRegen,
        Point2D pos
    ) {
        this.ptRegen = ptRegen;
        this.pos = new Point2D(pos.getX(), pos.getY());
    }
    
    /**
     * méthode constructeur faisant une copie d'une autre potion de soin
     * @param s Soin 
     */
    public Soin(Soin s) {
        super(
            (Potion)s
        );
    }
    
    /**
     * méthode constructeur de la classe Creature sans paramètres
     */
    public Soin() {
        super();
    }
    
    /**
     * Méthode faisant soigner des points de vie à l'unité sur la potion.
     * @param p personnage sur lequelappliquer la potion
     */
    public void boire(Personnage p) {
        if (0 == this.pos.distance(p.getPos())) {
            p.setPtVie(p.getPtVie() + this.ptRegen);
            this.pos = null;
            System.out.println("Potion de Soin bue");
        }
    }
}
