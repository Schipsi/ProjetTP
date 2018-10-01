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
public class Archer extends Personnage {

    //définition des Attributs
    /**
     * nbFleches nombre de flèches possédées par l'archer
     */
    private int nbFleches;

    //définition des constructeurs
    /**
     * Méthode constructeur prenant en compte les attributs suivants
     * @param nom
     * @param ptVie
     * @param ptPar
     * @param ptMana
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param pourcentageMag
     * @param pourcentageResistMag
     * @param degAtt
     * @param degMag
     * @param distAttMax
     * @param pos
     * @param nbf 
     */
    public Archer(
            String nom,
            int ptVie,
            int ptPar,
            int ptMana,
            int pourcentageAtt,
            int pourcentagePar,
            int pourcentageMag,
            int pourcentageResistMag,
            int degAtt,
            int degMag,
            int distAttMax,
            Point2D pos,
            int nbf
    ) {
        super(
            nom,
            ptVie,
            ptPar,
            ptMana,
            pourcentageAtt,
            pourcentagePar,
            pourcentageMag,
            pourcentageResistMag,
            degAtt,
            degMag,
            distAttMax,
            pos
        );
        this.nbFleches = nbf;
    }

    /**
     * Méthode Constructeur copie faisant la copie d'une instance d'archer déjà existante
     * @param a 
     */
    public Archer(Archer a) {
        super(
            (Personnage)a
        );
        this.nbFleches = a.nbFleches;
    }

    /**
     * Méthode Constructeur vide ne prenant en compte aucun attribut
     */
    public Archer() {
        super();
        this.nbFleches = 0;
    }

    //définition des Accesseurs et Mutateurs
    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     * Méthode affiche de la classe Archer affichant les attributs d'une instance d'archer
     */
    public void affiche() {
        System.out.println(
            "Je suis un archer, je possède "
            + this.getNbFleches()
            + " fleches, "
            + this.getPtVie()
            + " points de vie et "
            + this.getPtMana()
            + " points de mana. \nJe suis actuellement en ["
            + this.getPos().getX() + "," + this.getPos().getY()
            + "] et je suis en mesure de t'infliger "
            + this.getDegAtt()
            + " dégats avec mes attaques et "
            + this.getDegMag()
            + " dégats avec ma magie \n(probabilité respective de toucher de "
            + this.getPourcentageAtt()
            + " et "
            + this.getPourcentageMag()
            + ")"
        );
    }
    
    /**
     * Override de la méthode combattre défini dans la classe Creature, car l'archer peut se battre à distance
     * @param creature 
     */
    public void combattre(Creature creature) {
        System.out.println( this.getNom()+" qui est un "+this.getClass().getSimpleName()+" veut attaquer un " + creature.getClass().getSimpleName());
        Random dice = new Random();
        if (1 == this.getPos().distance(creature.getPos())) {
            System.out.println("Attaque au corps à corps");
            if (this.getPourcentageAtt() <= dice.nextInt(100)) {
                System.out.println(this.getNom() +" réussi son jet d'attaque ");
                if (dice.nextInt(100) > creature.getPourcentagePar()) {
                     System.out.println("Le "+creature.getClass().getSimpleName()+" réussi à parer ");
                } else if (this.getDegAtt() > creature.getPtPar()) { //on test si les dégats d'attaques sont supérieurs au dégats de parade sinon ça va heal
                    creature.setPtVie(creature.getPtVie() - this.getDegAtt() + creature.getPtPar());
                    System.out.println("Le "+creature.getClass().getSimpleName()+" s'est pris "+ (this.getDegAtt() - creature.getPtPar())+" dégats");
                    System.out.println("Il lui reste "+creature.getPtVie()+" points de vie.");
                }
            }
        } else if (this.getDistAttMax() >= this.getPos().distance(creature.getPos())) {
            System.out.println("Je peux attaquer a distance");
            if (1 <= this.getNbFleches()) {
                this.setNbFleches(this.getNbFleches() - 1);
                if (this.getPourcentageAtt() >= dice.nextInt(100)) {
                    System.out.println(this.getNom() +" réussi son jet d'attaque ");
                    creature.setPtVie(creature.getPtVie() - this.getDegAtt());
                    System.out.println("Le "+creature.getClass().getSimpleName()+" s'est pris "+ (this.getDegAtt() - creature.getPtPar())+" dégats");
                    System.out.println("Il lui reste "+creature.getPtVie()+" points de vie.");
                }
                else{
                    System.out.println(this.getNom() +" rate son jet d'attaque ");
                }
            } 
            else {
                System.out.println("Je n'ai plus de flêches...");
            }
        } else {
            System.out.println("Cette unité est trop loin pour être attaquée !");
        }
    }
}
