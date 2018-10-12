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
public class PommeDoree extends Nourriture{ 
        
    private int augPointPar;
    
    public PommeDoree(){
       super(); 
       augPointPar = 90;
    }
    
    public void effet(Personnage p){
        p.setPourcentagePar(p.getPourcentagePar() + augPointPar);
    }
    
    public void finEffet(Personnage p){
        if(this.duree==0){
            p.setPourcentagePar(p.getPourcentagePar() - augPointPar);
        }
    }
    
}
