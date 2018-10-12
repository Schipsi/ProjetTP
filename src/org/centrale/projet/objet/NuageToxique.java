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
public class NuageToxique extends Objet implements Combattant, Deplacable{
   
    
    public NuageToxique() {
        
    }
    
    
    
    public void deplacer() {
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
    
    public void combattre(Creature c){
        
    }
    
}
