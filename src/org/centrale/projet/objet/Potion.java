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
abstract class Potion extends Objet {
    
    /**
     * Définie tous les attributs des potions
     * ptRegen nombre de point régénérés par la potion 
     */
    protected int ptRegen;
    
    /**
     * méthode constructeur de la classe Potion prenant en compte les paramètres suivants 
     * @param ptRegen
     * @param pos
     */
    public Potion(
        int ptRegen,
        Point2D pos
    ) {
        this.ptRegen = ptRegen;
        this.pos = new Point2D(pos.getX(), pos.getY());
    }
    
    /**
     * méthode constructeur faisant une copie d'une autre potion
     * @param p Objet 
     */
    public Potion(Potion p) {
        super(
            (Objet)p
        );
        this.ptRegen = p.ptRegen;
    }
    
    /**
     * méthode constructeur de la classe Creature sans paramètres
     */
    public Potion() {
        super();
        this.ptRegen = 0;
    }

    public int getPtRegen() {
        return ptRegen;
    }

    public void setPtRegen(int ptRegen) {
        this.ptRegen = ptRegen;
    }
    
    public void boire(Personnage p){
        
    }
}
