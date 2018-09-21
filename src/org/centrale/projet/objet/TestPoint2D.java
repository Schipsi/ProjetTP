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
public class TestPoint2D {

    public static void main(String[] args) {
        System.out.println("on créé 3 points avec les 3 constructeurs différents et on les affiche.");
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(10, 20);
        Point2D p3 = new Point2D(p2);
        p1.affiche();
        p2.affiche();
        p3.affiche();
        System.out.println("on transalte le 3ème point de (5,10) et on l'affiche.");
        p3.translater(5, 10);
        p3.affiche();
        System.out.println("on vérifie que p2 n'a pas été modifié et on le modifie pour le point (5,20).");
        p2.affiche();
        p2.modifier(5, 20);
        p2.affiche();
        System.out.println("on affiche les coordonnées du point 1 avec les accesseurs : x=" + p1.getX() + ", y=" + p1.getY());
        System.out.println("on modifie les coordonnées du point 1 avec les modificateurs");
        p1.setX(99);
        p1.setY(100);
        p1.affiche();
    }
}
