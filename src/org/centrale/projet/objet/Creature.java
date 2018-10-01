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
     * @param ptPar
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param degAtt
     * @param pos 
     */
    public Creature(
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
     * méthode constructeur faisant une copie d'une autre creature
     * @param c creature 
     */
    public Creature(Creature c) {
        this.ptVie = c.ptVie;
        this.ptPar = c.ptPar;
        this.pourcentageAtt = c.pourcentageAtt;
        this.pourcentagePar = c.pourcentagePar;
        this.degAtt = c.degAtt;
        this.pos = new Point2D(c.pos.getX(), c.pos.getY());
    }
    
    /**
     * méthode constructeur de la classe Creature sans paramètres
     */
    public Creature() {
        this.ptVie = 0;
        this.ptPar = 0;
        this.pourcentageAtt = 0;
        this.pourcentagePar = 0;
        this.degAtt = 0;
        this.pos = new Point2D();
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
     * Méthode pour afficher un personnage de façon simple
     */
    public void affiche() {
        System.out.println("Je suis une simple créature.");
    }
    
    /**
     * Méthode de combat au corps à corps commun à la plupart des créatures 
     * @param creature 
     */
    public void combattre(Creature creature) {
        if (1 == this.getPos().distance(creature.getPos())) {
            System.out.println("Attaque au corps à corps");
            Random dice = new Random();
            if (this.getPourcentageAtt() >= dice.nextInt(100) + 1 ) {
                System.out.println("j'ai réussi mon jet d'attaque ");
                if (dice.nextInt(100) + 1 < creature.getPourcentagePar()) {
                    System.out.println("il a réussi a paré ");
                } else if (this.getDegAtt() > creature.getPtPar()) { //on test si les dégats d'attaques sont supérieurs au dégats de parade sinon ça va heal
                    creature.setPtVie(creature.getPtVie() - this.getDegAtt() + creature.getPtPar());
                    System.out.println("il s'est pris "+ (this.getDegAtt() - creature.getPtPar())+" dégats");
                }
            }
            else {
                System.out.println("j'ai raté mon jet d'attaque ");
            }
        }
        else {
            System.out.println("Cette unité est trop loin pour être attaquée !");
        }
    }
}
