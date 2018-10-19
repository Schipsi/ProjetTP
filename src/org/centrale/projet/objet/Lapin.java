/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Thibs
 */
public class Lapin extends Monstre {

    // création des attributs de la classe Lapin
    // pas de nouveaux attributs pour les lapins
    //création des méthodes constructeurs
    /**
     * Méthode Constructeur de la classe Lapin prenant en compte les attributs suivants
     * @param ptVie points de vie du lapin
     * @param ptPar points de parade du lapin
     * @param pourcentageAtt pourcentage de chance de réussir une attaque
     * @param pourcentagePar pourcentage de chance de réussir une parade
     * @param degAtt dégats d'attaque du lapin 
     * @param pos position du lapin
     */
    public Lapin(
            int ptVie,
            int ptPar,
            int pourcentageAtt,
            int pourcentagePar,
            int degAtt,
            Point2D pos
    ) {
        super(
            ptVie,
            ptPar,
            pourcentageAtt,
            pourcentagePar,
            degAtt,
            pos
        );
    }
    
    /**
     * Méthode Constructeur copie de la classe Lapin faisant une copie d'une instance de Lapin déjà existante
     * @param l Lapin
     */
    public Lapin(Lapin l) {
        super(
            (Monstre)l
        );
    }
    
    /**
     * Méthode Constructeur vide de la classe Lapin ne prenant en compte aucun attribut
     */
    public Lapin() {
        super();
    }

    /**
     * Méthode affiche de Lapin affichant les attributs de l'instance et utilisant la méthoe affiche de la classe Monstre
     */
    public void affiche() {
        super.affiche("Lapin");
    }
    
    
    /**
     * Méthode fuir, permettant au lapin de se déplacer deux fois aléatoirement lorsqu'il est proche d'une autre créature
     * @param creature 
     */
    public void fuir(Creature creature){
        if (1 == this.getPos().distance(creature.getPos())){
            this.deplacer();
            this.deplacer();
        }
    }
           
}
