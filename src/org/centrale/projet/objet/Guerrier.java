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
public class Guerrier extends Personnage implements Combattant {
   
    /**
     * Méthode Cosntructeur de la classe Guerrier prenant en compte les attributs suivants
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
    public Guerrier(
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
     * Méthode Constructeur Copie de la classe Guerrier copiant une instance déjà existante de la classe Guerrier
     * @param g guerrier
     */
    public Guerrier(Guerrier g) {
        super(
            (Personnage)g
        );
    }
    
     /**
     * Méthode Constructeur vide de la classe Guerrier ne prenant en compte aucun attribut
     */
    public Guerrier() {
        super();
        Random lancerDeDes1 = new Random();
        Random lancerDeDes2 = new Random();
        this.degAtt= 5 + lancerDeDes1.nextInt(7) + lancerDeDes2.nextInt(7);
        this.distAttMax =1;
        this.pourcentageAtt = 30 + lancerDeDes1.nextInt(20)+ lancerDeDes2.nextInt(20);
        this.pourcentagePar = 40 + lancerDeDes1.nextInt(15)+ lancerDeDes2.nextInt(15);
        this.pourcentageResistMag = 20 + lancerDeDes1.nextInt(15)+ lancerDeDes2.nextInt(15);
        this.ptPar = 8;
        this.ptVie = 35 + lancerDeDes1.nextInt(10) + lancerDeDes2.nextInt(10);
    }
    
    public void combattre(Creature creature) {
        System.out.println( "Un Guerrier nommé "+this.nom+" veut attaquer un " + creature.getClass().getSimpleName());
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
                System.out.println("Le "+this.getClass().getSimpleName() +"rate son jet d'attaque ");
            }
        }
        else {
            System.out.println("Cette unité est trop loin pour être attaquée !");
        }
    }
    
    /**
     * Méthode affiche de la classe Guerrier affichant les attributs d'une instance de guerrier
     */
    public void affiche() {
        System.out.println(
            "Je suis un guerrier, je possède "
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
}
