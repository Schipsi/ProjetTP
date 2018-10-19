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
public class PommeDoree extends Nourriture{ 
    
    /**
     * augmente le nombre de points de parades
     */    
    private int augPointPar;
    
    /**
     * Méthode constructeur de la classe PommeDoree
     */
    public PommeDoree(){
        super(); 
        augPointPar = 90;
    }
    
    public PommeDoree(
        int duree,
        Point2D pos
    ) {
        this.duree = duree;
        this.pos = new Point2D(pos.getX(), pos.getY()); 
    }
    
    /**
     * Méthode effet déclarant le début d'un effet sur un personnage ayant consommée la nourriture
     * @param p personnage mangeant la nourriture
     */
    public void effet(Personnage p){
        p.setPourcentagePar(p.getPourcentagePar() + augPointPar);
    }
    
    /**
     * Méthode finEffet déclarant la fin de l'effet de la nourriture 
     * @param p personnage ayant mangé la nourriture
     */
    public void finEffet(Personnage p){
        if(this.duree==0){
            p.setPourcentagePar(p.getPourcentagePar() - augPointPar);
        }
    }
    
}
