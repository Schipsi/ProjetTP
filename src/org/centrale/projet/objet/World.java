/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author grego
 */
public class World {
    //définition de la taille max du monde 
    private final int TAILLEMAX = 50;

    /**
     * Définition de la Méthode Constructeur de la classe World qui sert plus ici à afficher nos résultats
     */
<<<<<<< HEAD
    public World() {  
        // définition du nombre de créatures présentes 
        Random seed = new Random();
        int nbArcher = seed.nextInt(2);
        int nbGuerrier = seed.nextInt(2);
        int nbMage = seed.nextInt(2);
        int nbPaysan = seed.nextInt(2);
        int nbLapin = seed.nextInt(2);
        int nbLoup = 100;
=======
    public World() {
        guillaumeT.setNom("guillaumeT");
        List<Creature> creaList = new ArrayList<>();
        creaList.add(peon);
        creaList.add(robin);
        creaList.add(bugs1);
        creaList.add(bugs2);
        creaList.add(wolfie);
        creaList.add(grosBill);
        creaList.add(merlin);
        creaList.add(guillaumeT);
        creeMondeAlea(creaList);
        peon.affiche();
        peon.setPos(new Point2D(merlin.getPos().getX()+3, merlin.getPos().getY()));
        merlin.combattre(peon);
        peon.affiche();
    }

    /**
     * Méthode creeMondeAlea créant un positionnant des personnages bien défini au préalable, utilisée dans le tp1
     */
    public void creeMondeAlea() {

        Random generateurAleatoire = new Random();
>>>>>>> small change combattre
        
        List<Creature> creatureList= new ArrayList<>();
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
                    for(Point2D p: list2Points){
                        if(0 == c.pos.distance(p)) {// on regarde si le point n'est pas sur un emplacement déjà pris
                             verify=false;
                             break;
                        }
                        else{
                            if(5 >= c.pos.distance(p)){//on regarde si un autre point est à moins de 5 cases de distances à part si c'est le premier
                                verify=true;
                            }
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
