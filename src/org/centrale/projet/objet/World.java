/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author grego
 */
public class World {
    //définition de la taille max du monde 
    private final int TAILLEMAX = 50;
    private List<ElementDeJeu> elementList = new ArrayList<>();
           
    /**
     * Définition de la Méthode Constructeur de la classe World qui sert plus ici à afficher nos résultats
     */
    public World() {  
        // définition du nombre de créatures présentes 
        Random seed = new Random();
        int nbArcher = 0;
        int nbGuerrier = 0;
        int nbMage = 0;
        int nbPaysan = 0;
        int nbLapin = 0;
        int nbLoup = seed.nextInt(10) + 45;
        int nbPotionSoin = 5;
        int nbPotionMana = 5;
        
        
        for (int i = 0; i < nbArcher; i++) {
            elementList.add(new Archer());
        }
        for (int i = 0; i < nbGuerrier; i++) {
            elementList.add(new Guerrier());
        }
        for (int i = 0; i < nbMage; i++) {
            elementList.add(new Mage());
        }
        for (int i = 0; i < nbPaysan; i++) {
            elementList.add(new Paysan());
        }
        for (int i = 0; i < nbLapin; i++) {
            elementList.add(new Lapin());
        }
        for (int i = 0; i < nbLoup; i++) {
            elementList.add(new Loup());
        }
        for (int i = 0; i < nbPotionSoin; i++) {
            elementList.add(new Soin());
        }
        for (int i = 0; i < nbPotionMana; i++) {
            elementList.add(new Mana());
        }
        
        Joueur player1 = new Joueur();
        elementList.add(player1.perso);
        try {
            player1.perso.pos.affiche();
        } catch (NullPointerException e) {
            System.out.println("Accès à un objet définit comme null !");
        }
        
        creeMondeAlea(elementList);
        
        //test de la vitesse de calcul du barycentre 
        //test pour une boucle basé sur les indices
       /* long debutN = System.nanoTime();
        double baryX = 0;
        double baryY = 0;
        for(Creature c: creatureList ){
            baryX += (double)c.pos.getX();
            baryY += (double)c.pos.getY();
        } 
        baryX= baryX/creatureList.size();
        baryY= baryY/creatureList.size();
        System.out.println("le barycentre des creatures se trouve en : ("+baryX+", "+baryY+")");
        long finN = System.nanoTime();
        System.out.println("Le temps écoulé pour le calcul du barycentre est de : "+ (finN-debutN)+" nanosecondes");
        
        
        //Test pour une boucle utilisant les itérateurs
        long debut2N = System.nanoTime();
        double bary2X = 0;
        double bary2Y =  0;
        Iterator<Creature> listItCrea = creatureList.iterator();
        int i= 0;
        while(listItCrea.hasNext()){
            i++;
            Creature c = listItCrea.next();
            bary2X = (double)c.getPos().getX() + bary2X;
            bary2Y = (double)c.getPos().getY() + bary2Y;
        } 
        bary2X= bary2X/i;
        bary2Y= bary2Y/i;
        System.out.println("le barycentre des creatures se trouve en : ("+bary2X+", "+bary2Y+")");
        long fin2N = System.nanoTime();
        System.out.println("Le temps écoulé pour le calcul du barycentre est de : "+ (fin2N-debut2N)+" nanosecondes");*/
    }
    
    /**
     * Méthode creeMondeAlea créant un positionnant des personnages se trouvant dans une liste de créature au préalable,
     * de manière à qu'ils ne se trouvent pas sur la même case et que chaque personnage soit à une distance de 5 d'au moins un autre personnage
     * @param creature 
     */
    public void creeMondeAlea(List<ElementDeJeu> elements){
        List<Point2D> list2Points = new ArrayList<>();
        Random generateurAleatoire = new Random();
        boolean verify = false;
        for(ElementDeJeu e : elements){
            verify = false;
            while(!verify){
                e.setPos(new Point2D(generateurAleatoire.nextInt(TAILLEMAX), generateurAleatoire.nextInt(TAILLEMAX)));
                if(list2Points.isEmpty()){ //cas particulier pour le premier élément qui ne doit pas vérifier les conditions
                    verify=true;
                    list2Points.add(e.getPos());
                }
                else {
                    verify=true;
                    for(Point2D p: list2Points){
                        if(3 > e.getPos().distance(p)) {// on regarde si le point n'est pas sur un emplacement déjà pris
                             verify=false;
                        }
                    }
                } 
            }
            list2Points.add(e.getPos());
        }
        for (ElementDeJeu e : elements) {
            e.getPos().affiche();
        }
    }
    
    public void afficheWorld() {
        for(int i = 0; i < TAILLEMAX; i++) {
            for(int j = 0; j < TAILLEMAX; j++) {
                Point2D pos = new Point2D(i, j);
                if (null != getCrea(pos) && getCrea(pos) instanceof Personnage && !getObj(pos).isEmpty()) {
                    System.out.print("q");
                } else if (null != getCrea(pos) && getCrea(pos) instanceof Creature && !getObj(pos).isEmpty()) {
                    System.out.print("n");
                } else if (null != getCrea(pos) && getCrea(pos) instanceof Personnage) {
                    System.out.print("p");
                } else if (null != getCrea(pos) && getCrea(pos) instanceof Creature) {
                    System.out.print("m");
                } else if (!getObj(pos).isEmpty()) {
                    System.out.print("o");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
        
    }
    
    public Creature getCrea(Point2D pos){
        for(ElementDeJeu e: this.elementList){
            if(pos.distance(e.getPos()) == 0 && e instanceof Creature){
                return ((Creature) e);
            }
        }
        return null;
    }
    
    public List<Objet> getObj(Point2D pos){
        List<Objet> objetList= new ArrayList<>();
        for(ElementDeJeu e: this.elementList){
            if(pos.distance(e.getPos()) == 0 && e instanceof Objet){
                objetList.add((Objet) e);
            }
        }
        return objetList;
    }
    
    public void jouerPerso(Personnage e){
        Scanner sc = new Scanner(System.in);
        boolean chosen = false;
        boolean chosen2 = false;
        e.affiche();
        this.afficheWorld();
        while(!chosen){
            System.out.println("Que voulez vous faire ? "
                + "\n 1- combattre "
                + "\n 2- se déplacer");
            String choix = sc.nextLine();
            if(choix.equals("1")){
                while(!chosen2){
                    System.out.println("Désignez la position de la créature que vous voulez attaquer : \n x = ?");
                    sc.nextLine();
                    int x = sc.nextInt();
                    System.out.println("y = ?");
                    sc.nextLine();
                    int y = sc.nextInt();
                    Point2D ennemi = new Point2D(x,y);
                    Creature creaEnnemi = getCrea(ennemi);
                    if(creaEnnemi!= null && e.getPos().distance(ennemi)!=0){// on regarde qu'il y ait bien une creature sur cette position et qu'elle est différente du personnage
                        ((Personnage) e).combattre(creaEnnemi);
                        chosen2=true;
                        chosen=true;
                    }
                    else{
                        System.out.println(" Il n'y a aucune créature en cette position.");
                    }
                }
            }
            else if(choix.equals("2")){
                ((Personnage) e).deplacer();
                chosen=true;
            }
            else{
                System.out.println("Veuillez choisir le chiffre 1(combattre) ou 2(se deplacer) ");
            }
        }  
    }
    
    
    public void jouerMonstre(Monstre m){
        
    }
    
    
    public void tourDeJeu(){
        for(ElementDeJeu e : this.elementList){
            if(e instanceof Personnage){// on regarde si notre élément de jeu est un personnage
                if(((Personnage) e).jouable){ // on rvérifie que le personnage est jouable
                    this.jouerPerso((Personnage) e);
                }
                else{
                    ((Creature) e).deplacer();
                }
            }
            else if(e instanceof Monstre){
                this.jouerMonstre((Monstre) e);
            }
        }
    }
}   
