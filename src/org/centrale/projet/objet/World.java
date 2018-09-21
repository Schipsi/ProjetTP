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
public class World {
    
    //création des personnages du monde 
    Archer robin = new Archer("robin", 99, 98, 80, 0, 2, 6, 13, 4, 6, new Point2D(), 16);
    Paysan peon= new Paysan("peon", 20, 16, 50, 10, 0, 0, 2, 1, 1, new Point2D());
    Lapin bugs = new Lapin(6, 20, 10, 1, new Point2D());
    
    //définition de la taille max du monde 
    private final int TAILLEMAX= 100;
     
    public World () {
        creeMondeAlea();
    }

    public void creeMondeAlea() {
       
        Random generateurAleatoire = new Random();
        
        //On positionne l'archer robin
        robin.setPos(new Point2D(generateurAleatoire.nextInt(TAILLEMAX),generateurAleatoire.nextInt(TAILLEMAX)));

        boolean verifyP = false;
        
        //on positionne le paysan peon
        while(!verifyP){
            peon.setPos(new Point2D((generateurAleatoire.nextInt(10)-5+robin.getPos().getX()),(generateurAleatoire.nextInt(10)-5+robin.getPos().getY())));
            if(peon.getPos().getX()<=TAILLEMAX &&
               peon.getPos().getY()<=TAILLEMAX &&
               peon.getPos().getX()>=0 &&
               peon.getPos().getY()>=0){
                if(peon.getPos().getX()==robin.getPos().getX() &&
                   peon.getPos().getY()==robin.getPos().getY()){
                   verifyP=false;
                }
                else{
                   verifyP=true;
                }
            }
        }
        System.out.println("ok boucle 1");
        boolean verifyL =false;
        
        //on positionne le lapin bugs
        while(!verifyL){
            bugs.setPos(new Point2D((generateurAleatoire.nextInt(10)-5+robin.getPos().getX()),(generateurAleatoire.nextInt(10)-5+robin.getPos().getY())));
            if(bugs.getPos().getX()<=TAILLEMAX &&
               bugs.getPos().getY()<=TAILLEMAX &&
               bugs.getPos().getX()>=0 &&
               bugs.getPos().getY()>=0){
                if((bugs.getPos().getX()==robin.getPos().getX() && //vérifie les collisions avec robin
                   bugs.getPos().getY()==robin.getPos().getY()) ||
                   (bugs.getPos().getX()==peon.getPos().getX() && //vérifie les collisions avec peon
                   bugs.getPos().getY()==peon.getPos().getY())){
                   verifyL=false;
                }
                else{
                    if(Math.abs(bugs.getPos().getX()-peon.getPos().getX())<5 && 
                       Math.abs(bugs.getPos().getY()-peon.getPos().getY())<5 ){
                       verifyL=true;
                    }
                }
            }
        }
        robin.affiche();
        peon.affiche();
        bugs.affiche();
    }
}
