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
    /**
     * Méthode Constructeur de la classe Loup prenant en compte les attributs suivants
     * @param ptVie
     * @param ptPar
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param degAtt
     * @param pos 
     */
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
    
    /**
     * Méthode Constructeur Copie de la classe Loup faisant une copie d'une instance de loup déjà existante
     * @param m 
     */
    public Loup(Monstre m) {
        super(m);
    }
    
    /**
     * Méthode Constructeur de la classe Loupne prenant en compte aucun attribut
     */
        public Loup() {
    }
    
    /**
     * Méthode affiche utilisant la méthode affiche de la classe monstre et affichant le type de Monstre
     */
    public void affiche(){
        super.affiche("Loup");
    }
    
}
