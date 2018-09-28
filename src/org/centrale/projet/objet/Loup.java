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
public class Loup extends Monstre{

    public Loup(
        int ptVie, 
        int ptPar, 
        int pourcentageAtt, 
        int pourcentagePar, 
        int degAtt, 
        Point2D pos
    ) {
        super(
            ptVie, 
            ptPar, 
            pourcentageAtt, 
            pourcentagePar, 
            degAtt, 
            pos
        );
    }

    public Loup(Monstre m) {
        super(m);
    }
    
        public Loup() {
    }
    
    public void affiche(){
        super.affiche("Loup");
    }
    
}
