/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.List;

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
     * @param jouable
     * @param buffs
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
            buffs);
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
        this.jouable = p.jouable;
    }
    /**
     * Constructeur de la classe Paysan ne prenant pas d'attributs en compte
     */
    public Paysan() {
        super();
    }
    public void combattre(Creature c){
        System.out.println("Crebondiou d'bonsoir j'suis qu'un péquenau, d'où tu veux que je me batte");
    }
}
