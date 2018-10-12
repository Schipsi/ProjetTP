/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Scanner;

/**
 *
 * @author grego
 */
abstract class Personnage extends Creature implements Combattant{

    //création des attributs de la classe abstraite Personnage 
    /**
     * nom nom du personnage 
     * ptMana points de mana du personnage (0) pour la plupart des classes
     * pourcentageMag pourcentage de chance de réussir une attaque magique
     * pourcentageResistMag pourcentage de chance de parer une attaque magique
     * distAttMax distance d'attaque maximale
     * jouable le personnage est un personnage joué par un joueur ou non
     */
    protected String nom;
    protected int ptMana;
    protected int pourcentageMag;
    protected int pourcentageResistMag;
    protected int degMag;
    protected int distAttMax;
    protected boolean jouable;
    //création des méthodes constructeurs
    /**
     * Méthode constructeur de la classe Personnage prenant en compte les paramètres suivants
     * @param nom nom du personnage
     * @param ptVie
     * @param ptPar
     * @param ptMana points de mana du personnage (0) pour la plupart des classes
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param pourcentageMag pourcentage de chance de réussir une attaque magique
     * @param pourcentageResistMag
     * @param degAtt
     * @param degMag
     * @param distAttMax distance d'attaque maximale
     * @param pos 
     * @param jouable le personnage est un personnage joué par un joueur ou non
     */
    public Personnage(
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
            boolean jouable
    ) {
        this.nom = nom;
        this.ptVie = ptVie;
        this.ptPar = ptPar;
        this.ptMana = ptMana;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.pourcentageMag = pourcentageMag;
        this.pourcentageResistMag = pourcentageResistMag;
        this.degAtt = degAtt;
        this.degMag = degMag;
        this.distAttMax = distAttMax;
        this.pos = new Point2D(pos.getX(), pos.getY());
        this.jouable = jouable;
    }
    
    /**
     * Méthode Constructeur faisant la copie d'un personnage déjà existant
     * @param p Personnage
     */
    public Personnage(Personnage p) {
        super(
            (Creature)p
        );
        this.nom = p.nom;
        this.ptMana = p.ptMana;
        this.pourcentageMag = p.pourcentageMag;
        this.pourcentageResistMag = p.pourcentageResistMag;
        this.degMag = p.degMag;
        this.distAttMax = p.distAttMax;
        this.jouable = p.jouable;
    }
    
    /**
     * Constructeur de personnage ne prenant pas de paramètres et retournant un personnage null
     */
    public Personnage() {
        super();
        this.nom = null;
        this.ptMana = 0;
        this.pourcentageMag = 0;
        this.pourcentageResistMag = 0;
        this.degMag = 0;
        this.distAttMax = 0;
        this.jouable= false;
    }

    //definition des accesseurs et mutateurs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPtMana() {
        return ptMana;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
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

    /**
     * Méthode faisant l'affichage des attributs du personnage 
     */
    public void affiche() {
        System.out.println(
            "Je suis un personnage, je possède "
            + this.getPtVie()
            + " points de vie et "
            + this.getPtMana()
            + " points de mana. \nJe suis actuellement en ["
            + this.getPos().getX() + "," + this.getPos().getY()
            + "] et je suis en mesure de t'infliger "
            + this.getDegAtt()
            + " dégats avec mes attaques et "
            + this.getDegMag()
            + " dégats avec ma magie \n(probabilité respective de toucher de "
            + this.getPourcentageAtt()
            + " et "
            + this.getPourcentageMag()
            + ")"
        );
    }
    
    /**
     * Méthode faisant l'affichage d'un personnage en donnant sa classe
     * @param classe nom de la classe du personnage
     */
    public void affiche(String classe) {
        System.out.println(
            "Je suis un "+classe+", je possède "
            + this.getPtVie()
            + " points de vie et "
            + this.getPtMana()
            + " points de mana. \nJe suis actuellement en ["
            + this.getPos().getX() + "," + this.getPos().getY()
            + "] et je suis en mesure de t'infliger "
            + this.getDegAtt()
            + " dégats avec mes attaques et "
            + this.getDegMag()
            + " dégats avec ma magie \n(probabilité respective de toucher de "
            + this.getPourcentageAtt()
            + " et "
            + this.getPourcentageMag()
            + ")"
        );
    }
    /**
     * Méthode deplacer où l'on demande au joueur dans quel direction il veut se déplacer.
     */
    public void deplacer(){
        Scanner sc = new Scanner(System.in);
        boolean chosen = false;
        System.out.println("Votre personnage est en position ["+this.getPos().getX()+", "+this.getPos().getY()+"].");
        while(!chosen){
            System.out.println("Dans quel direction voulez vous aller ? "
                    + "\n 1- en haut à gauche "
                    + "\n 2- en haut "
                    + "\n 3- en haut à droite "
                    + "\n 4- à droite "
                    + "\n 5- en bas à droite"
                    + "\n 6- en bas"
                    + "\n 7- en bas à gauche"
                    + "\n 8- à gauche");
            String posi = sc.nextLine();
            if(posi.length()==1){
                chosen=true;
                switch(posi){
                    case "1": this.pos.translater(-1, 1);
                            break;
                    case "2": this.pos.translater(0, 1);
                              break;
                    case "3": this.pos.translater(1, 1);
                              break;
                    case "4": this.pos.translater(1, 0);
                              break;
                    case "5": this.pos.translater(1, -1);
                              break;
                    case "6": this.pos.translater(0, -1);
                              break;
                    case "7": this.pos.translater(-1, -1);
                              break;
                    case "8": this.pos.translater(-1, 0);
                              break;
                    default: chosen=false;
                             break;
                }    
            }
        }
        System.out.println("Votre personnage est maintenant en position ["+this.getPos().getX()+", "+this.getPos().getY()+"].");

    }
    public void combattre(){
        
    }
}
