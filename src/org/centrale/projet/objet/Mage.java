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
public class Mage extends Personnage implements Combattant{
    
    /**
     * Méthode Constructeur de la classe Mage prenant en compte les attributs suivants
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
     */
    public Mage(
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
            Point2D pos
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
    }
    
    /**
     * Méthode Constructeur copie de la classe Mage faisant une copie d'une instance de mage déjà existante
     * @param m 
     */
    public Mage(Mage m) {
        super(
            (Personnage)m
        );
    }
    
    /**
     * Méthode Constructeur vide de la classe Mage
     */
    public Mage() {
        super();
    }
    
    /**
     * Méthode affiche permettant d'afficher les attributs d'une instance de mage
     */
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
    
    /**
     * Override de la méthode combattre défini dans la classe Creature, car le mage ne se bat pas au corps à corps et se bat avec de la magie
     * @param creature 
     */
    @Override
    public void combattre(Creature creature) {
       Random dice = new Random();
       System.out.println( this.getNom()+" qui est un "+this.getClass().getSimpleName()+" veut attaquer un " + creature.getClass().getSimpleName());
       if (this.getDistAttMax() >= this.getPos().distance(creature.getPos())) {
           System.out.println("Je peux toucher avec mes sorts !");
           if (1 <= this.getPtMana()) {
               this.setPtMana(this.getPtMana() - 1);
               if (this.getPourcentageMag() >= dice.nextInt(100) + 1) {
                  System.out.println(this.getNom() +" réussi son jet d'attaque ");
                  creature.setPtVie(creature.getPtVie() - this.getDegMag());
                  System.out.println("Le "+creature.getClass().getSimpleName()+" s'est pris "+ (this.getDegAtt() - creature.getPtPar())+" dégats");
                  System.out.println("Il lui reste "+creature.getPtVie()+" points de vie.");
                }
               else{
                   System.out.println(this.getNom() +" rate son jet d'attaque ");
               }
           } 
           else {
               System.out.println("Je n'ai pas assez de mana pour lancer un sort...");
           }
       }
    }
}
