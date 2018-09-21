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
public class Archer extends Personnage {

    //définition des Attributs
    private int nbFleches;
    
    //définition des constructeurs
    public Archer(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int degMag, int distAttMax, Point2D pos, int nbf) {
        super(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResistMag, degAtt, degMag, distAttMax, pos);
        this.nbFleches=nbf;
    }
    
    public Archer( Archer a){
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
    
}
