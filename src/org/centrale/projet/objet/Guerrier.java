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
public class Guerrier extends Personnage {
    
    public Guerrier(
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

    public Guerrier(Guerrier g) {
        this.nom = g.nom;
        this.ptVie = g.ptVie;
        this.ptMana = g.ptMana;
        this.pourcentageAtt = g.pourcentageAtt;
        this.pourcentagePar = g.pourcentagePar;
        this.pourcentageMag = g.pourcentageMag;
        this.pourcentageResistMag = g.pourcentageResistMag;
        this.degAtt = g.degAtt;
        this.degMag = g.degMag;
        this.distAttMax = g.distAttMax;
        this.pos = g.pos;
    }

    public Guerrier() {
    }
    
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
