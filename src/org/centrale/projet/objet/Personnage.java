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
    private String nom;
    private int ptVie;
    private int ptMana;
    private int pourcentageAtt;
    private int pourcentagePar;
    private int pourcentageMag;
    private int pourcentageResistMag;
    private int degAtt;
    private int degMag;
    private int distAttMax;
    private Point2D pos;

    //création des méthodes constructeurs
    public Personnage(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResistMag, int degAtt, int degMag, int distAttMax) {
        this.nom= nom;
        this.ptVie=ptVie;
        this.ptMana= ptMana;
        this.pourcentageAtt= pourcentageAtt;
        this.pourcentagePar= pourcentagePar;
        this.pourcentageMag= pourcentageMag;
        this.pourcentageResistMag= pourcentageResistMag;
        this.degAtt= degAtt;
        this.degMag= degMag;
        this.distAttMax= distAttMax;
        this.pos= pos;
        
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
        this.pos= p.pos;
    }
    
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

    public int getPourcentageResistaMag() {
        return pourcentageResistMag;
    }

    public void setPourcentageResistaMag(int pourcentageResistaMag) {
        this.pourcentageResistMag = pourcentageResistMag;
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
    
    
    
}
