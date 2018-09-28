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

    //création des personnages du monde 
    Archer robin = new Archer("robin", 99, 10, 15, 90, 70, 20, 40, 15, 15, 15, new Point2D(), 16);
    Paysan peon = new Paysan("peon", 20, 1, 16, 50, 10, 0, 0, 2, 1, 1, new Point2D());
    Lapin bugs1 = new Lapin(6, 5, 20, 10, 1, new Point2D());
    Lapin bugs2 = new Lapin(6, 5, 20, 10, 1, new Point2D());
    Loup wolfie = new Loup(100, 5, 100, 30, 5, new Point2D());
    Archer guillaumeT = new Archer(robin);
    Guerrier grosBill = new Guerrier("grosBill", 99, 20, 0 , 90, 80, 5, 50, 0, 0, 1, new Point2D());
    Mage merlin= new Mage("merlin", 50, 10, 100, 40, 20, 80, 70, 15, 10, 15, new Point2D());
    //définition de la taille max du monde 
    private final int TAILLEMAX = 100;

    /**
     * Définition de la Méthode Constructeur de la classe World qui sert plus ici à afficher nos résultats
     */
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
        peon.setPos(new Point2D(merlin.getPos().getX()+2, merlin.getPos().getY()));
        merlin.combattre(peon);
        peon.affiche();
    }

    /**
     *  Méthode creeMondeAlea créant un positionnant des personnages bien défini au préalable, utilisée dans le tp1
     */
    public void creeMondeAlea() {

        Random generateurAleatoire = new Random();
        
        //On positionne l'archer robin
        robin.setPos(new Point2D(generateurAleatoire.nextInt(TAILLEMAX), generateurAleatoire.nextInt(TAILLEMAX)));
        
        boolean verifyP = false;

        //on positionne le paysan peon
        while (!verifyP) {
            peon.setPos(new Point2D((generateurAleatoire.nextInt(10) - 5 + robin.getPos().getX()), (generateurAleatoire.nextInt(10) - 5 + robin.getPos().getY())));// place le paysan a 5 moins de 5 de distance de robin
            if (peon.getPos().getX() <= TAILLEMAX //vérifie que le paysan  est dans le monde et pas en dehors
                    && peon.getPos().getY() <= TAILLEMAX
                    && peon.getPos().getX() >= 0
                    && peon.getPos().getY() >= 0) {
                if (peon.getPos().getX() == robin.getPos().getX() // vérifie les collisions avec robin
                        && peon.getPos().getY() == robin.getPos().getY()) {
                    verifyP = false;
                } else {
                    verifyP = true;
                }
            }
        }
        boolean verifyL = false;

        //on positionne le lapin bugs
        while (!verifyL) {
            bugs.setPos(new Point2D((generateurAleatoire.nextInt(10) - 5 + robin.getPos().getX()), (generateurAleatoire.nextInt(10) - 5 + robin.getPos().getY()))); // place le lapin à moins de 5 de distances de robin
            if (bugs.getPos().getX() <= TAILLEMAX // vérifie que le lapin est dans le monde et pas en dehors
                    && bugs.getPos().getY() <= TAILLEMAX
                    && bugs.getPos().getX() >= 0
                    && bugs.getPos().getY() >= 0) {
                if ((bugs.getPos().getX() == robin.getPos().getX()//vérifie les collisions avec robin
                        && 
                        bugs.getPos().getY() == robin.getPos().getY())
                        || (bugs.getPos().getX() == peon.getPos().getX()//vérifie les collisions avec peon
                        && 
                        bugs.getPos().getY() == peon.getPos().getY())) {
                    verifyL = false;
                } else {
                    if (Math.abs(bugs.getPos().getX() - peon.getPos().getX()) < 5 //vérifie que la distance avec peon soit à moins de 5
                            && Math.abs(bugs.getPos().getY() - peon.getPos().getY()) < 5) {
                        verifyL = true;
                    }
                }
            }
        }
        robin.affiche();
        peon.affiche();
        bugs.affiche();
        Archer guillaumeT = new Archer();
        guillaumeT.affiche();
        
        robin.deplace();
        peon.deplace();
        bugs.deplace();
        
        robin.affiche();
        peon.affiche();
        bugs.affiche();
        guillaumeT.affiche();
        

        
        
        
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
            verify=false;
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
        
    }
    
    public void afficheWorld(){
        
    }
    
    public void tourDeJeu(){
        
    }
}   
