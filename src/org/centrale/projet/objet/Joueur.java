/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Scanner;

/**
 *
 * @author grego
 */
public class Joueur {
    
    protected Personnage perso;
    /**
     * Méthode Constructeur de joueur permettant de créer un nouveau personnage jouable
     */
    public Joueur(){
        Boolean chosen = false;
        Scanner sc = new Scanner(System.in);
        while(!chosen){
            System.out.println("quel type classe voulez vous être : \n 1- Archer \n 2- Guerrier \n 3- Mage");
            String clas = sc.nextLine();
            if (clas.equals("1")){
               this.perso = new Archer();
               chosen = true;
            }
            else if(clas.equals("2")){
                this.perso = new Guerrier();
                chosen = true;
            }
            else if(clas.equals("3")){
                this.perso = new Mage();
                chosen = true; 
            }
            else{
                System.out.println("Rentrez un chiffre compris entre 1 et 3 pour choisir votre classe");
            }
        }
        sc.nextLine();
        System.out.println("Rentrez le nom de votre personnage");
        this.perso.nom = sc.nextLine();
        System.out.println("Le nom de votre personnage est donc :"+ this.perso.nom);
        this.perso.jouable=true;
    }
}
