/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
        int nbArcher = seed.nextInt(2);
        int nbGuerrier = seed.nextInt(2);
        int nbMage = seed.nextInt(2);
        int nbPaysan = seed.nextInt(2);
        int nbLapin = seed.nextInt(2);
        int nbLoup = 50;
        
        
        /*for (int i = 0; i < nbArcher; i++) {
            creatureList.add(new Archer());
        }
        for (int i = 0; i < nbGuerrier; i++) {
            creatureList.add(new Guerrier());
        }
        for (int i = 0; i < nbMage; i++) {
            creatureList.add(new Mage());
        }
        for (int i = 0; i < nbPaysan; i++) {
            creatureList.add(new Paysan());
        }
        for (int i = 0; i < nbLapin; i++) {
            creatureList.add(new Lapin());
        }
        */
        for (int i = 0; i < nbLoup; i++) {
            elementList.add(new Loup());
        }
        Joueur player1 = new Joueur();
        elementList.add(player1.perso);
        
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
                             break;
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
                if (null != getCrea(pos) && !getObj(pos).isEmpty()) {
                    System.out.print("x");
                } else if (null != getCrea(pos)) {
                    System.out.print("c");
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
    
    /**
     * Méthode cerner dont le but est de savoir si une creature est cernée par d'autre créature, dans ce cas ci la créature ne peut pas bouger
     * pb de la méthode : est consomme beaucoup de temps de calcul
     * @param c creature 
     * @param elements list composée de tout les éléments de jeu
     * @return 
     */
    public boolean cerner(Creature c, List<ElementDeJeu> elements){
        int compteur =0;
        Point2D test = new Point2D(c.getPos());
        for(int i=-1; i<2;i++){
             for(int j=-1; i<2;i++){
                 test = new Point2D(c.getPos());
                 test.translater(i, j);
                 for(ElementDeJeu e:elements){
                     if(test.distance(e.getPos())==0 && e instanceof Creature){
                         compteur+=1;
                         break;
                     }
                 }
             }
        }
        if(compteur==9){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Méthode renvoyant true si la case est occupée par une créature, false sinon 
     * @param Creature creature caractérisée par sa position
     * @param elements liste des éléments constituants le monde
     * @return 
     */
    public boolean collision(Creature c,  List<ElementDeJeu> elements){
        for(ElementDeJeu e:elements){
            if(c.getPos().distance(e.getPos())==0 && e instanceof Creature)
                return true;
        }
        return false;
    }
    /**
     * Méthode proposant de combattre une créature ou de se déplacer sur une case où ne se trouve pas d'autres créatures, ne s'occupe pas de récupérer les potions
     * @param e Personnage jouable
     */
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
                        System.out.println("Voulez vous vous déplacer plutot [y/n]");// Pour sortir de la boucle si on ne peut attaquer aucune créature
                        sc.nextLine();
                        String choix2 = sc.nextLine();
                        if(choix2.equals("y")){
                            choix="2";
                            chosen2=true;
                        }
                    }
                }
            }
            else if(choix.equals("2")){
                boolean collision = true;
                if(!this.cerner(e, this.elementList)){
                Personnage copie = new Guerrier();
                    while(collision){
                        copie.setPos(e.getPos());
                        copie.deplacer();
                        collision = this.collision(copie, this.elementList);
                    }
                    e.setPos(copie.getPos());
                }
            }
            else{
                System.out.println("Veuillez choisir le chiffre 1(combattre) ou 2(se deplacer) ");
            }
        }  
    }
    
    
    public void jouerMonstre(Monstre m){
        if(m instanceof Loup){
            for(ElementDeJeu e : this.elementList){
                if(m.getPos().distance(e.getPos())==1 && e instanceof Creature){
                    ((Loup) m).combattre((Creature) e);
                    return ;
                }
            }
        }
        boolean collision =true;
        if(!this.cerner(m, this.elementList)){
            Creature copie = new Loup();
            while(collision){
                copie.setPos(m.getPos());
                copie.deplacer();
                collision = this.collision(copie, this.elementList);
            }
            m.setPos(copie.getPos());
        }
    }
    
    /**
     * Méthode pour faire "jouer" les objets , i.e. les faire se consommer si quelqu'un se trouve dessus et faire bouger le nuage
     * @param o objet qui peut être une potion, de la nourriture ou un nuage toxique
     */
    public void jouerObjet(Objet o){
        for(ElementDeJeu e: this.elementList){
            if(o.getPos().distance(e.getPos())==0 && e instanceof Personnage){
                if(o instanceof Potion){//l potion est bue
                    ((Potion)o).boire((Creature)e);
                }
                else if(o instanceof Nourriture){//on mange la nourriture
                    ((Personnage)e).Manger((Nourriture)o);
                }
                else if(o instanceof NuageToxique){
                    ((NuageToxique)o).combattre((Creature)e);
                }    
            }
        }
        if(o instanceof NuageToxique){
            ((NuageToxique)o).deplacer();
        }
    }
    
    public void tourDeJeu(){
        for(ElementDeJeu e : this.elementList){//on fait jouer tout les personnages, monstres, objets
            if(e instanceof Personnage){// on regarde si notre élément de jeu est un personnage
                if(((Personnage) e).jouable){ // on vérifie que le personnage est jouable
                    this.jouerPerso((Personnage) e);
                }
            }
            else if(e instanceof Monstre){
                this.jouerMonstre((Monstre) e);
            }
            else if(e instanceof Object){
                this.jouerObjet((Objet)e);
            }
        }
        for(ElementDeJeu e : this.elementList){//on fait le tour des buffs et des débuffs
            if(e instanceof Personnage){
                for(Nourriture b: ((Personnage) e).buffs){
                    if(b.duree==b.DUREEMAX){
                        b.effet((Personnage)e);
                    }
                    b.duree-=1;
                    if(b.duree==-1){
                        b.finEffet((Personnage)e);
                    }
                }
            }
        }
        for(ElementDeJeu e : this.elementList){//on fait le tour des buffs et des débuffs pour supprimer ceux qui sont périmés
            if(e instanceof Personnage){
                Iterator<Nourriture> itr = ((Personnage)e).buffs.iterator();//comme on supprime au fur et à mesure il est plus sur de fonctionner avec des itérateurs
                while(itr.hasNext()){
                    Nourriture n = itr.next();
                    if(n.duree==-1){
                        itr.remove();
                    }
                }
            }
        }
    }
}   
