/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author grego
 */
public class TestSeance2 {
    public static void main(String[] args) {
        
        int notes[] = {2, 20, 17, 5};
        try {
            System.out.println(notes[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("indice invalide !");
        }
        
        int a = 12;
        int b = 0;
        try {
            int c = a/b;
        } catch (ArithmeticException e) {
            System.out.println("opération mathematique invalide !");
        }
        
        Objet mana = new Mana();
        Objet nuage = new NuageToxique();
        try {
            nuage = (NuageToxique)mana;
            
        } catch (ClassCastException e) {
            System.out.println("Cast invalide !");
        }
        
        try {
            int nombre = Integer.parseInt("Ceci n'est pas un nombre du tout !");
        } catch (NumberFormatException e) {
            System.out.println("Format de nombre invalide !");
        }
        
        World monde =new World();
        monde.tourDeJeu();
        //joueur.perso.affiche();
        //joueur.perso.deplacer();
        
    }
}
