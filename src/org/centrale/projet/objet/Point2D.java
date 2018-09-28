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
public class Point2D {
    
    /**
     * définition des attributs de la classe Point2D
     * x absciise dans le monde en 2D du point
     * y ordonnées dans le monde ne 2D du point
     */
    private int x;
    private int y;

    /**
     * Méthode constructeur vide de la classe Point2D, retournant le point (0,0)
     */
    public Point2D() {
        x = 0;
        y = 0;
    }

    /**
     * Méthode constructeur de la classe Point2D prenant en compte les attributs suivants
     * @param x 
     * @param y 
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Méthode Constructeur copie de la classe Point2D faisant une copie d'une instance déjà existante
     * @param p 
     */
    public Point2D(Point2D p) {
        x = p.x;
        y = p.y;
    }
    
    //définition des getters et setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Méthode affiche de la classe Point2D affichant la position d'un point dans l'espace 2D
     */
    public void affiche() {
        System.out.println("[" + this.x + ";" + this.y + "]");
    }
    
    /**
     * Méthode translater permettant de translater un point dans l'espace 2D
     * @param x valeur de translation selon x, pas de la position finale
     * @param y valeur de translation selon x, pas de la position finale
     */
    public void translater(int x, int y) {
        this.x += x;
        this.y += y;
    }
    
    /**
     * Méthode modifier permettant de modifier la position du point
     * @param x
     * @param y 
     */
    public void modifier(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Méthode distance retournant la distance entre deux points , en considérant le nombre de cases/points entre deux entitées  
     * @param point
     * @return 
     */
    public int distance(Point2D point) {
        return (Math.abs(this.getX() - point.getX()) + Math.abs(this.getY() - point.getY()));
    }
}
