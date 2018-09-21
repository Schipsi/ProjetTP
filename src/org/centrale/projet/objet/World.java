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
public class World {
    
    //création des personnages du monde 
    Archer robin = new Archer();
    Paysan peon= new Paysan();
    Lapin bugs = new Lapin();
    
    //définition de la taille max du monde 
    private final int TAILLEMAX= 100;
     
    public World () {
        
    }

    public void creeMondeAlea() {
        
    }
}
