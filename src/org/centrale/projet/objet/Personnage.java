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
abstract class Personnage {
    
    //création des attributs de la classe abstraite parente
    protected String nom;
    protected int ptVie;
    protected int ptMana;
    protected int pourcentageAtt;
    protected int pourcentagePar;
    protected int pourcentageMag;
    protected int pourcentageResistMag;
    protected int degAtt;
    protected int degMag;
    protected int distAttMax;
    protected Point2D pos;

    //création des méthodes constructeurs
    public Personnage(
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
        Point2D pos
    ) {
        this.nom = nom;
        this.ptVie = ptVie;
        this.ptMana = ptMana;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.pourcentageMag = pourcentageMag;
        this.pourcentageResistMag = pourcentageResistMag;
        this.degAtt = degAtt;
        this.degMag = degMag;
        this.distAttMax = distAttMax;
        this.pos = new Point2D(pos.getX(), pos.getY());
    }
    
    public Personnage( Personnage p){
        this.nom= p.nom;
        this.ptVie= p.ptVie;
        this.ptMana= p.ptMana;
        this.pourcentageAtt= p.pourcentageAtt;
        this.pourcentagePar= p.pourcentagePar;
        this.pourcentageMag= p.pourcentageMag;
        this.pourcentageResistMag= p.pourcentageResistMag;
        this.degAtt= p.degAtt;
        this.degMag= p.degMag;
        this.distAttMax= p.distAttMax;
        this.pos.setX(p.pos.getX());
        this.pos.setY(p.pos.getY());
    }

    public Personnage() {
    }
    
    //definition des accesseurs et mutateurs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getPtMana() {
        return ptMana;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
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

    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    public void setPourcentageResistMag(int pourcentageResistaMag) {
        this.pourcentageResistMag = pourcentageResistaMag;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getDegMag() {
        return degMag;
    }

    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    public void deplace() {
        // TODO : faire une fonction de déplacement
    }
    
    public void affiche() {
        System.out.println(
            "Je suis un personnage, je possède " 
            + this.getPtVie() 
            + " points de vie et "
            + this.getPtMana()
            + " points de mana. Je suis actuellement en ["
            + this.getPos().getX()+","+this.getPos().getY()
            + "] et je suis en mesure de t'infliger "
            + this.getDegAtt()
            + " dégats avec mes attaques et "
            + this.getDegMag()
            + " dégats avec ma magie (probabilité respective de toucher de "
            + this.getPourcentageAtt()
            + " et "
            + this.getPourcentageMag()
        );
    }
    
}
