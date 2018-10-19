/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author grego
 */
abstract class Personnage extends Creature implements Combattant{

    //création des attributs de la classe abstraite Personnage 
    /**
     * nom du personnage
     */
    protected String nom;
    /**
     * points de mana du personnage (0) pour la plupart des classes
     */
    protected int ptMana;
    /**
     * pourcentage de chance de réussir une attaque magique
     */
    protected int pourcentageMag;
    /**
     * pourcentage de chance de résister à une attaque magique
     */
    protected int pourcentageResistMag;
    /**
     * degats infligés avec une attaque magique
     */
    protected int degMag;
    /**
     * distance d'attaque maximale
     */
    protected int distAttMax;
    /**
     * le personnage est un personnage joué par un joueur ou non
     */
    protected boolean jouable;
    /**
     * liste de bonus ou malus donné par la nourriture consommée
     */
    protected List<Nourriture> buffs = new ArrayList<>();
    
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
     * @param pourcentageResistMag pourcentage de chance de résister à une attaque magique
     * @param degAtt
     * @param degMag degats infligés avec une attaque magique
     * @param distAttMax distance d'attaque maximale
     * @param pos 
     * @param jouable le personnage est un personnage joué par un joueur ou non
     * @param buffs bonus ou malus donné par la nourriture consommée
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
            boolean jouable,
            List<Nourriture> buffs
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
        for(Nourriture n: buffs){
            this.buffs.add(n);
        }
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
        for(Nourriture n: p.buffs){
            this.buffs.add(n);
        }
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
        this.buffs = new ArrayList<>();
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

    public boolean isJouable() {
        return jouable;
    }

    public void setJouable(boolean jouable) {
        this.jouable = jouable;
    }

    public List<Nourriture> getBuffs() {
        return buffs;
    }

    public void setBuffs(List<Nourriture> buffs) {
        this.buffs = buffs;
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
    
    /**
     * Méthode manger qui fait consommer la nourriture se trouvant sur une case par lepersonnage se trouvant sur la même case
     * @param n nourriture mangée
     */
    public void manger(Nourriture n){
        if(this.getPos().distance(n.getPos())==0){
            this.buffs.add(n);
            n.pos = null;
        }
    }
}
