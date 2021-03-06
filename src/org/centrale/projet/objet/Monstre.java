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
abstract class Monstre {

    //définition des attributs de la classe
    protected int ptVie;
    protected int pourcentageAtt;
    protected int pourcentagePar;
    protected int degAtt;
    protected Point2D pos;

    //définition des constructeurs
    public Monstre(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos) {
        this.ptVie = ptVie;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.pos = new Point2D(pos.getX(), pos.getY());
    }

    public Monstre() {
    }

    public Monstre(Monstre m) {
        this.ptVie = m.ptVie;
        this.pourcentageAtt = m.pourcentageAtt;
        this.pourcentagePar = m.pourcentagePar;
        this.degAtt = m.degAtt;
        this.pos.setX(m.pos.getX());
        this.pos.setY(m.pos.getY());
    }

    //définition des accesseurs et Mutateurs
    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
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

    public void affiche() {
        System.out.println(" Bonjour gentil voyageur , je suis un gentil Monstre et voici mes stats :");
        System.out.println("Point de Vie :" + this.ptVie);
        System.out.println("Dégat d'attaque :" + this.degAtt);
        System.out.println("Pourcentage d'attaque :" + this.pourcentageAtt);
        System.out.println("pourcentage de Parade :" + this.pourcentagePar);
        System.out.println("position : (" + this.getPos().getX() + "," + this.getPos().getX() + ")");
    }

    public void affiche(String nomMonstre) {
        System.out.println(" Bonjour gentil voyageur , je suis un gentil " + nomMonstre + " et voici mes stats :");
        System.out.println("Point de Vie :" + this.ptVie);
        System.out.println("Dégat d'attaque :" + this.degAtt);
        System.out.println("Pourcentage d'attaque :" + this.pourcentageAtt);
        System.out.println("pourcentage de Parade :" + this.pourcentagePar);
        System.out.println("position : (" + this.getPos().getX() + "," + this.getPos().getY() + ")");
    }

    public void deplace() {

    }
    
}
