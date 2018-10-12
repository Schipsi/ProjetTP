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
public class ViandeDeZombie extends Nourriture{
    
    private int dimPourcentagePar;
    
    public ViandeDeZombie(){
       super(); 
       dimPourcentagePar = -20;
    }
    
    public void effet(Personnage p){
        p.setPourcentagePar(p.getPourcentagePar() + dimPourcentagePar);
    }
    
    public void finEffet(Personnage p){
        if(this.duree==0){
            p.setPourcentagePar(p.getPourcentagePar() - dimPourcentagePar);
        }
    }
}
