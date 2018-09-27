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
    private int nbFleches;

    //définition des constructeurs
    public Archer(
            String nom,
            int ptVie,
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

    public Archer(Archer a) {
        this.nom = a.nom;
        this.ptVie = a.ptVie;
        this.ptMana = a.ptMana;
        this.pourcentageAtt = a.pourcentageAtt;
        this.pourcentagePar = a.pourcentagePar;
        this.pourcentageMag = a.pourcentageMag;
        this.pourcentageResistMag = a.pourcentageResistMag;
        this.degAtt = a.degAtt;
        this.degMag = a.degMag;
        this.distAttMax = a.distAttMax;
        this.pos = a.pos;
        this.nbFleches = a.nbFleches;
    }

    public Archer() {
    }

    //définition des Accesseurs et Mutateurs
    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

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
    
    public void combattre(Creature creature) {
        Random dice = new Random();
        if (1 == this.getPos().distance(creature.getPos())) {
            System.out.println("Attaque au corps à corps");
            if (this.getPourcentageAtt() <= dice.nextInt(100)) {
                if (dice.nextInt(100) > creature.getPourcentagePar()) {
                
                } else if (this.getDegAtt() > creature.getPtPar()) { //on test si les dégats d'attaques sont supérieurs au dégats de parade sinon ça va heal
                    creature.setPtVie(creature.getPtVie() - this.getDegAtt() + creature.getPtPar());
                }
            }
        } else if (this.getDistAttMax() >= this.getPos().distance(creature.getPos())) {
            System.out.println("Je peux attaquer a distance");
            if (1 <= this.getNbFleches()) {
                this.setNbFleches(this.getNbFleches() - 1);
                if (this.getPourcentageAtt() <= dice.nextInt(100)) {
                    creature.setPtVie(creature.getPtVie() - this.getDegAtt());
                }
            } else {
                System.out.println("Je n'ai plus de flêches...");
            }
        } else {
            System.out.println("Cette unité est trop loin pour être attaquée !");
        }
    }
}
