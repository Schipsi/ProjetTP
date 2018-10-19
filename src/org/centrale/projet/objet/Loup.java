/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author grego
 */
public class Loup extends Monstre implements Combattant{
    /**
     * Méthode Constructeur de la classe Loup prenant en compte les attributs suivants
     * @param ptVie
     * @param ptPar
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param degAtt
     * @param pos 
     */
    public Loup(
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
     * Méthode Constructeur Copie de la classe Loup faisant une copie d'une instance de loup déjà existante
     * @param m 
     */
    public Loup(Monstre m) {
        super(m);
    }
    
    /**
     * Méthode Constructeur de la classe Loupne prenant en compte aucun attribut
     */
        public Loup() {
            super(
                 10,
                  0,
                  40,
                  0,
                  2,
                  new Point2D()
                   );
    }
    
    /**
     * Méthode affiche utilisant la méthode affiche de la classe monstre et affichant le type de Monstre
     */
    public void affiche(){
        super.affiche("Loup");
    }
    /**
     * Méthode de l'interface Combattant impléméntée dans cette classe Loup pour le combat au corps à corps
     * @param creature Creature visée par le combattant
     */
    
    public void combattre(Creature creature) {
        System.out.println( "Un "+this.getClass().getSimpleName()+" veut attaquer un " + creature.getClass().getSimpleName());
        if (1 == this.getPos().distance(creature.getPos())) {
            System.out.println("Attaque au corps à corps");
            Random dice = new Random();
            if (this.getPourcentageAtt() >= dice.nextInt(100) + 1 ) {
                System.out.println("Le "+this.getClass().getSimpleName() +" réussi son jet d'attaque ");
                if (dice.nextInt(100) + 1 < creature.getPourcentagePar()) {
                    System.out.println("Le "+creature.getClass().getSimpleName()+" réussi à parer ");
                } else if (this.getDegAtt() > creature.getPtPar()) { //on test si les dégats d'attaques sont supérieurs au dégats de parade sinon ça va heal
                    creature.setPtVie(creature.getPtVie() - this.getDegAtt() + creature.getPtPar());
                    System.out.println("Le "+creature.getClass().getSimpleName()+" s'est pris "+ (this.getDegAtt() - creature.getPtPar())+" dégats");
                    System.out.println("Il lui reste "+creature.getPtVie()+" points de vie.");
                }
            }
            else {
                System.out.println("Le "+this.getClass().getSimpleName() +" rate son jet d'attaque ");
            }
        }
        else {
            System.out.println("Cette unité est trop loin pour être attaquée !");
        }
    }
    
}
