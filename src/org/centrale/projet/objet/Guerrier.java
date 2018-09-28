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
public class Guerrier extends Personnage {
   
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
