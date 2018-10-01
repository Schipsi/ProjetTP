/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author grego
 */
public class World {
    //définition de la taille max du monde 
    private final int TAILLEMAX = 100000;

    /**
     * Définition de la Méthode Constructeur de la classe World qui sert plus ici à afficher nos résultats
     */
    public World() {  
        // définition du nombre de créatures présentes 
        Random seed = new Random();
        int nbArcher = seed.nextInt(2);
        int nbGuerrier = seed.nextInt(2);
        int nbMage = seed.nextInt(2);
        int nbPaysan = seed.nextInt(2);
        int nbLapin = seed.nextInt(2);
        int nbLoup = 1000000;
        
        List<Creature> creatureList= new LinkedList<>();
        /*for (int i = 0; i < nbArcher; i++) {
            creatureList.add(new Archer());
        }
        for (int i = 0; i < nbGuerrier; i++) {
            creatureList.add(new Guerrier());
        }
        for (int i = 0; i < nbMage; i++) {
            creatureList.add(new Mage());
        }
        for (int i = 0; i < nbPaysan; i++) {
            creatureList.add(new Paysan());
        }
        for (int i = 0; i < nbLapin; i++) {
            creatureList.add(new Lapin());
        }
        */
        for (int i = 0; i < nbLoup; i++) {
            creatureList.add(new Loup());
        }
        
        creeMondeAlea(creatureList);
        long debutN = System.nanoTime();
        double baryX;
        double baryY;
        Point2D bary = new Point2D(0,0);
        for(Creature c: creatureList ){
            bary.setX(bary.getX()+c.getPos().getX());
            bary.setY(bary.getY()+c.getPos().getY());
        } 
        baryX= (double)bary.getX()/creatureList.size();
        baryY= (double)bary.getY()/creatureList.size();
        System.out.println("le barycentre des creatures se trouve en : ("+baryX+", "+baryY+")");
        long finN = System.nanoTime();
        System.out.println("Le temps écoulé pour le calcul du barycentre est de : "+ (finN-debutN)+" nanosecondes");
        
        long debut2N = System.nanoTime();
        double bary2X = (double)creatureList.get(1).getPos().getX();
        double bary2Y =  (double)creatureList.get(1).getPos().getY();
        Iterator<Creature> listItCrea = creatureList.iterator();
        int i= 1;
        while(listItCrea.hasNext()){
            i++;
            Creature c = listItCrea.next();
            bary2X = (double)c.getPos().getX() + bary2X;
            bary2Y = (double)c.getPos().getY() + bary2Y;
        } 
        bary2X= bary2X/i;
        bary2Y= bary2Y/i;
        System.out.println("le barycentre des creatures se trouve en : ("+bary2X+", "+bary2Y+")");
        long fin2N = System.nanoTime();
        System.out.println("Le temps écoulé pour le calcul du barycentre est de : "+ (fin2N-debut2N)+" nanosecondes");
    }
    
    /**
     * Méthode creeMondeAlea créant un positionnant des personnages se trouvant dans une liste de créature au préalable,
     * de manière à qu'ils ne se trouvent pas sur la même case et que chaque personnage soit à une distance de 5 d'au moins un autre personnage
     * @param creature 
     */
    public void creeMondeAlea(List<Creature> creature){
        List<Point2D> list2Points = new ArrayList<>();
        Random generateurAleatoire = new Random();
        boolean verify = false;
        for(Creature c : creature){
            verify = false;
            while(!verify){
                c.setPos(new Point2D(generateurAleatoire.nextInt(TAILLEMAX), generateurAleatoire.nextInt(TAILLEMAX)));
                if(list2Points.isEmpty()){ //cas particulier pour le premier élément qui ne doit pas vérifier les conditions
                    verify=true;
                    list2Points.add(c.pos);
                }
                else {
                    verify=true;
                    for(Point2D p: list2Points){
                        if(3 > c.pos.distance(p)) {// on regarde si le point n'est pas sur un emplacement déjà pris
                             verify=false;
                             break;
                        }
                    }
                } 
            }
            list2Points.add(c.pos);
        }
        for (Creature c : creature) {
            c.pos.affiche();
        }
    }
    
    public void afficheWorld(){
        
    }
    
    public void tourDeJeu(){
        
    }
}   
