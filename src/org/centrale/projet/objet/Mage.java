/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Thibs
 */
public class Mage extends Personnage implements Combattant{
    
    /**
     * Méthode Constructeur de la classe Mage prenant en compte les attributs suivants
     * @param nom nom du mage   
     * @param ptVie points de vie du mage
     * @param ptPar points de parade du mage
     * @param ptMana points de Mana du mage
     * @param pourcentageAtt pourcentage de chance de réussir une attaque physique
     * @param pourcentagePar pourcentage de chance de réussir une parade
     * @param pourcentageMag pourcentage de chance de réussir une attaque magique 
     * @param pourcentageResistMag pourcentage de chance de résister à une attaque magique
     * @param degAtt degats physique infligés sur une attaque réussie
     * @param degMag degats magique infligés sur une attaque réussie
     * @param distAttMax distance d'attaque maximale
     * @param pos position du mage en 2 dimensions
     * @param jouable le personnage est un jouable ou non
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
            Point2D pos,
            boolean jouable,
            List<Nourriture> buffs
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
            pos,
            jouable,
            buffs
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
        Random lancerDeDes1 = new Random();
        Random lancerDeDes2 = new Random();
        this.degMag= 6 + lancerDeDes1.nextInt(5) + lancerDeDes2.nextInt(5);
        this.distAttMax = 3;
        this.pourcentageMag = 30 + lancerDeDes1.nextInt(15)+ lancerDeDes2.nextInt(15);
        this.pourcentagePar = 15 + lancerDeDes1.nextInt(15)+ lancerDeDes2.nextInt(15);
        this.pourcentageResistMag = 25 + lancerDeDes1.nextInt(20)+ lancerDeDes2.nextInt(20);
        this.ptMana = 30;
        this.ptPar = 5;
        this.ptVie = 25 + lancerDeDes1.nextInt(15) + lancerDeDes2.nextInt(15);
    }
    
    /**
     * Méthode affiche permettant d'afficher les attributs d'une instance de mage
     */
    public void affiche() {
        System.out.println(
            "Je suis un mage,  je m'appelle "
            + this.nom
            +" je possède "
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
     * Implémentation de la méthode combattre de l'interface combattant, sachant que le mage se bat exclusivement avec de la magie.
     * @param creature créature visée par le mage
     */
    
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
                  System.out.println("Il lui reste "+creature.getPtVie()+" points de vie.\n");
                }
               else{
                   System.out.println(this.getNom() +" rate son jet d'attaque \n");
               }
           } 
           else {
               System.out.println("Je n'ai pas assez de mana pour lancer un sort...\n");
           }
       }
    }
}
