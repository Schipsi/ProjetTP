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
    /**
     * Définition de la méthode constructeur de la classe Paysan prenant en compte les attributs suivants
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
    public Paysan(
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
            Point2D pos) {
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
            pos);
    }

    /**
     * Méthode constructeur copie faisant la copie d'un autre paysan
     * @param p paysan
     */
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
    /**
     * Constructeur de la classe Paysan ne prenant pas d'attributs en compte
     */
    public Paysan() {
        super();
    }
    
    /**
     * Override de la méthode combattre défini dans la classe Creature, car le paysan ne peux pas combattre
     * @param creature 
     */
    @Override
    public void combattre(Creature creature){
        System.out.println("je suis un paysan couard, je ne peux pas me battre");
    }
}
