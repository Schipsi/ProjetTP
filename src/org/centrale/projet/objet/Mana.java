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
public class Mana extends Potion {
    
    /**
     * méthode constructeur de la classe Mana prenant en compte les paramètres suivants 
     * @param ptRegen
     * @param pos
     */
    public Mana(
        int ptRegen,
        Point2D pos
    ) {
        this.ptRegen = ptRegen;
        this.pos = new Point2D(pos.getX(), pos.getY());
    }
    
    /**
     * méthode constructeur faisant une copie d'une autre potion de soin
     * @param m Mana 
     */
    public Mana(Mana m) {
        super(
            (Potion)m
        );
    }
    
    /**
     * méthode constructeur de la classe Creature sans paramètres
     */
    public Mana() {
        super();
    }
    
    /**
     * Méthode faisant soigner des points de mana à l'unité sur la potion.
     * @param p personnage sur lequel appliquer la potion
     */
    public void boire(Personnage p) {
        if (0 == this.pos.distance(p.pos)) {
            p.setPtMana(p.getPtMana() + this.ptRegen);
            this.pos = null;
        }
    }
}
