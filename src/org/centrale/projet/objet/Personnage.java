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
abstract class Personnage extends Creature{

    //création des attributs de la classe abstraite Personnage 
    /**
     * nom nom du personnage 
     * ptMana points de mana du personnage (0) pour la plupart des classes
     * pourcentageMag pourcentage de chance de réussir une attaque magique
     * pourcentageResistMag pourcentage de chance de parer une attaque magique
     * distAttMax distance d'attaque maximale
     */
    protected String nom;
    protected int ptMana;
    protected int pourcentageMag;
    protected int pourcentageResistMag;
    protected int degMag;
    protected int distAttMax;

    //création des méthodes constructeurs
    /**
     * Méthode constructeur de la classe Personnage prenant en compte les paramètres suivants
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
            Point2D pos
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
}
