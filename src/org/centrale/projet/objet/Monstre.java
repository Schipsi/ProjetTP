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
abstract class Monstre extends Creature{

    //définition des constructeurs
    /**
     * Constructeur de la classe Monstre prenant en compte les attributs suivants
     * @param ptVie
     * @param ptPar
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param degAtt
     * @param pos 
     */
    public Monstre(
        int ptVie, 
        int ptPar,
        int pourcentageAtt, 
        int pourcentagePar, 
        int degAtt, 
        Point2D pos
    ) {
        this.ptVie = ptVie;
        this.ptPar = ptPar;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.pos = new Point2D(pos.getX(), pos.getY());
    }
    
    /**
     * Constructeur copie de la classe Monstre sortant une copie de l'entrée
     * @param m Mosntre qu'on veut copier
     */
    public Monstre(Monstre m) {
        super(
            (Creature)m
        );
    }
    
    /**
     * Constructeur vide de la classe Monstre retournant un Monstre null
     */
    public Monstre() {
        super();
    }
    
    /**
     * Méthode affichant les attributs d'un Monstre sans prendre en compte le type de monstre
     */
    public void affiche() {
        System.out.println(" Bonjour gentil voyageur , je suis un gentil Monstre et voici mes stats :");
        System.out.println("Point de Vie :" + this.ptVie);
        System.out.println("Dégat d'attaque :" + this.degAtt);
        System.out.println("Pourcentage d'attaque :" + this.pourcentageAtt);
        System.out.println("pourcentage de Parade :" + this.pourcentagePar);
        System.out.println("position : (" + this.getPos().getX() + "," + this.getPos().getX() + ")");
    }
    
    /**
     *  Méthode affichant les attributs d'un Monstre en prenant en compte le nom du type de Monstre
     * @param nomMonstre 
     */
    public void affiche(String nomMonstre) {
        System.out.println(" Bonjour gentil voyageur , je suis un gentil " + nomMonstre + " et voici mes stats :");
        System.out.println("Point de Vie :" + this.ptVie);
        System.out.println("Dégat d'attaque :" + this.degAtt);
        System.out.println("Pourcentage d'attaque :" + this.pourcentageAtt);
        System.out.println("pourcentage de Parade :" + this.pourcentagePar);
        System.out.println("position : (" + this.getPos().getX() + "," + this.getPos().getY() + ")");
    }   
}
