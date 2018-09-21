/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author grego
 */
public class Paysan extends Personnage {

    //définition des Attributs
    //définition des constructeurs
    public Paysan(
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
            Point2D pos) {
        super(nom,
                ptVie,
                ptMana,
                pourcentageAtt,
                pourcentagePar,
                pourcentageMag,
                pourcentageResistMag,
                degAtt,
                degMag,
                distAttMax,
                pos);
    }

    public Paysan(Paysan p) {
        this.nom = p.nom;
        this.ptVie = p.ptVie;
        this.ptMana = p.ptMana;
        this.pourcentageAtt = p.pourcentageAtt;
        this.pourcentagePar = p.pourcentagePar;
        this.pourcentageMag = p.pourcentageMag;
        this.pourcentageResistMag = p.pourcentageResistMag;
        this.degAtt = p.degAtt;
        this.degMag = p.degMag;
        this.distAttMax = p.distAttMax;
        this.pos = p.pos;
    }

    public Paysan() {
    }
    //définition des Accesseurs et Mutateurs

}
