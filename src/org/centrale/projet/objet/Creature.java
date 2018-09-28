/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author grego
 */
public class Creature {
    
    /**
     * Définie tous les attributs des creatures
     * ptVie Points de Vie actuelles de la creature
     * ptPar Points de Parades que possède la créature
     * pourcentageAtt pourcentage de chance de réussir son attaque
     * pourcentagePar pourcentage de chance de contrer une attaque réussi
     * degAtt degat infligé à l'adversaire dans le cas d'une attaque réussi
     * pos position actuelle en 2 dimensions de la creature 
     */
    protected int ptVie;
    protected int ptPar;
    protected int pourcentageAtt;
    protected int pourcentagePar;
    protected int degAtt;
    protected Point2D pos;
    
    
     /**
      * méthode constructeur de la classe Creature prenant en compte les paramètres suivants 
      * @param ptVie
      * @param pourcentageAtt
      * @param pourcentagePar
      * @param degAtt
      * @param pos 
      */
    public Creature(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos) {
        this.ptVie = ptVie;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.pos = new Point2D(pos.getX(), pos.getY());
    }
   
    /**
     * méthode constructeur de la classe Creature sans paramètres
     */
    public Creature() {
    }
    
    /**
     * méthode constructeur faisant une copie d'une autre creature
     * @param m creature 
     */
    public Creature(Creature m) {
        this.ptVie = m.ptVie;
        this.pourcentageAtt = m.pourcentageAtt;
        this.pourcentagePar = m.pourcentagePar;
        this.degAtt = m.degAtt;
        this.pos.setX(m.pos.getX());
        this.pos.setY(m.pos.getY());
    }
    
    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }
    
    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
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
    
    /**
     * Méthode permettant le déplacement d'une créature de manière aléatoire sur une des cases adjacentes sans prendre en compte les positions déjà prises
     */
    public void deplace() {
        int x = 0;
        int y = 0;
        Random generateurAleatoire = new Random();
        //on prend au hasard une valeur de x et de y telle que x appartient à [-1;1] et de même pour y, mais (x,y) est différent de (0,0)
        
        while(x==0 && y==0){
            x=generateurAleatoire.nextInt(3)-1;
            y=generateurAleatoire.nextInt(3)-1;
        }
    this.setPos(new Point2D(x+this.getPos().getX(),y+this.getPos().getY()));
    }
    
    /**
     * Méthode de combat au corps à corps commun à la plupart des créatures 
     * @param creature 
     */
    public void combattre(Creature creature) {
        if (1 == this.getPos().distance(creature.getPos())) {
            System.out.println("Attaque au corps à corps");
            Random dice = new Random();
            if (this.getPourcentageAtt() <= dice.nextInt(100) + 1 ) {
                if (dice.nextInt(100) + 1 > creature.getPourcentagePar()) {
                
                } else if (this.getDegAtt() > creature.getPtPar()) { //on test si les dégats d'attaques sont supérieurs au dégats de parade sinon ça va heal
                    creature.setPtVie(creature.getPtVie() - this.getDegAtt() + creature.getPtPar());
                }
            }
        } else {
            System.out.println("Cette unité est trop loin pour être attaquée !");
        }
    }
}
