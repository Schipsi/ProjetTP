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
public class Lapin extends Monstre {

    // création des attributs de la classe Lapin
    // pas de nouveaux attributs pour les lapins
    //création des méthodes constructeurs
    public Lapin(
            int ptVie,
            int pourcentageAtt,
            int pourcentagePar,
            int degAtt,
            Point2D pos
    ) {
        super(
                ptVie,
                pourcentageAtt,
                pourcentagePar,
                degAtt,
                pos
        );
    }

    public Lapin(Lapin l) {
        this.ptVie = l.ptVie;
        this.pourcentageAtt = l.pourcentageAtt;
        this.pourcentagePar = l.pourcentagePar;
        this.degAtt = l.degAtt;
        this.pos = l.pos;

    }

    public Lapin() {
    }

    public void affiche() {
        super.affiche("Lapin");
    }
}
