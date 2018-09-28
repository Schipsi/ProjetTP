/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author Thibs
 */
public class Mage extends Personnage {
    
    public Mage(
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
    }

    public Mage(Mage m) {
        this.nom = m.nom;
        this.ptVie = m.ptVie;
        this.ptMana = m.ptMana;
        this.pourcentageAtt = m.pourcentageAtt;
        this.pourcentagePar = m.pourcentagePar;
        this.pourcentageMag = m.pourcentageMag;
        this.pourcentageResistMag = m.pourcentageResistMag;
        this.degAtt = m.degAtt;
        this.degMag = m.degMag;
        this.distAttMax = m.distAttMax;
        this.pos = m.pos;
    }

    public Mage() {
    }
    
    public void affiche() {
        System.out.println(
            "Je suis un mage, je possède "
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
    
    @Override
    public void combattre(Creature creature) {
       Random dice = new Random();
       if (this.getDistAttMax() >= this.getPos().distance(creature.getPos())) {
           System.out.println("Je peux toucher avec mes sorts !");
           if (1 <= this.getPtMana()) {
               this.setPtMana(this.getPtMana() - 1);
               if (this.getPourcentageMag() <= dice.nextInt(100) + 1) {
                    creature.setPtVie(creature.getPtVie() - this.getDegMag());
                }
           } else {
               System.out.println("Je n'ai pas assez de mana pour lancer un sort...");
           }
       }
    }
}
