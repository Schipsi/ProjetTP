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

    public Lapin(Lapin l) {
        super(
            (Monstre)l
        );
    }

    public Lapin() {
        super();
    }

    public void affiche() {
        super.affiche("Lapin");
    }
    
    public void combattre(Creature creature){
        System.out.println("je suis un faible lapin qui ne peut pas combattre");
    }
    
    public void fuir(Creature creature){
        if (1 == this.getPos().distance(creature.getPos())){
            this.deplace();
            this.deplace();
        }
    }
           
}
