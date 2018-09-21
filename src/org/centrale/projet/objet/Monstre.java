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
public class Monstre {
    
    //définition des attributs de la classe
    private int ptVie;
    private int PourcentageAtt;
    private int pourcentagePar;
    private int degAtt;
    private Point2D pos;
    
    //définition des constructeurs

    public Monstre(int ptVie, int PourcentageAtt, int pourcentagePar, int degAtt, Point2D pos) {
        this.ptVie = ptVie;
        this.PourcentageAtt = PourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.pos = pos;
    }

    public Monstre() {
    }
    
    public Monstre( Monstre m) {
        this.ptVie = m.ptVie;
        this.PourcentageAtt = m.PourcentageAtt;
        this.pourcentagePar = m.pourcentagePar;
        this.degAtt = m.degAtt;
        this.pos = m.pos;
    }
    
    
    //définition des accesseurs et Mutateurs

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getPourcentageAtt() {
        return PourcentageAtt;
    }

    public void setPourcentageAtt(int PourcentageAtt) {
        this.PourcentageAtt = PourcentageAtt;
    }

    public int getPourcentagePar() {
        return pourcentagePar;
    }

    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
}
