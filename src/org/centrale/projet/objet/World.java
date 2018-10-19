/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;


import java.lang.reflect.Method;
import java.util.Iterator;
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

    public int tailleMax = 50;
    public List<ElementDeJeu> elementList = new ArrayList<>();
           
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
        int nbLoup = seed.nextInt(2) +10;
        int nbPotionSoin = 10;
        int nbPotionMana = 10;
        int nbPommeDoree= 0;
        int nbViandeDeZombie= 300;
        
        
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
            elementList.add(new Soin(5, new Point2D()));
        }
        for (int i = 0; i < nbPotionMana; i++) {
            elementList.add(new Mana(5, new Point2D()));
        }
        for (int i = 0; i < nbPommeDoree; i++) {
            elementList.add(new PommeDoree());
        }
        for (int i = 0; i < nbViandeDeZombie; i++) {
            elementList.add(new ViandeDeZombie());
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
    
    public World(int taille) {
        this.setTailleMax(taille);
    }
    
    /**
     * Méthode creeMondeAlea créant un positionnant des personnages se trouvant dans une liste de créature au préalable,
     * de manière à qu'ils ne se trouvent pas sur la même case et que chaque personnage soit à une distance de 5 d'au moins un autre personnage
     * @param elements liste de tout les éléments qui vont constituer le monde 
     */
    public void creeMondeAlea(List<ElementDeJeu> elements){
        List<Point2D> list2Points = new ArrayList<>();
        Random generateurAleatoire = new Random();
        boolean verify = false;
        for(ElementDeJeu e : elements){
            verify = false;
            while(!verify){
                e.setPos(new Point2D(generateurAleatoire.nextInt(tailleMax), generateurAleatoire.nextInt(tailleMax)));
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
    /**
     * méthode affichant le monde avec p pour personnage , m pour monstre, o pour objet mais aussi avec q si il y a un objet et un personnage ou n si il y a un monstre et un objet
     */
    public void afficheWorld() {
        for(int i = tailleMax-1; i >-1; i--) {
            for(int j = 0; j < tailleMax; j++) {
                Point2D pos = new Point2D(j, i);
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
    /**
     * méthode renvoyant la créature se trouvant sur une positiion
     * @param pos position sur laquelle on cherche
     * @return une créature (la créature peut être nulle)
     */
    public Creature getCrea(Point2D pos){
        for(ElementDeJeu e: this.elementList){
            if(pos.distance(e.getPos()) == 0 && e instanceof Creature){
                return ((Creature) e);
            }
        }
        return null;
    }
    
    /**
     * méthode retournant la liste des objets se trouvant sur une position 
     * @param pos position sur laquelle on cherche
     * @return une liste d'objets
     */
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
     * Méthode cerner dont le but est de savoir si une creature est cernée par d'autres créatures, dans ce cas ci la créature ne peut pas bouger. 
     * pb de la méthode : elle consomme beaucoup de temps de calcul
     * @param c creature 
     * @param elements list composée de tout les éléments de jeu
     * @return true si cernée
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
     * @param c creature caractérisée par sa position
     * @return  true si il y a collision, false sinon
     */
    public boolean collision(Creature c){
        for(ElementDeJeu e:this.elementList){
            if(c.getPos().distance(e.getPos())==0 && e instanceof Creature){
                return true;
            }
        }
        return false;
    }
    /**
     * Méthode proposant de combattre une créature ou de se déplacer sur une case où ne se trouve pas d'autres créatures, ne s'occupe pas de récupérer les potions
     * @param e Personnage jouable
     */
    public void jouerPerso(Personnage e){
        Scanner sc = new Scanner(System.in);
        Personnage copie;
        boolean chosen = false;
        boolean chosen2 = false;
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
                copie = new Paysan();
                    while(collision){
                        copie.getPos().setX(e.getPos().getX());
                        copie.getPos().setY(e.getPos().getY());
                        copie.deplacer();
                        collision = this.collision(copie);
                    }
                    e.setPos(copie.getPos());
                }
                chosen=true;
                
            }
            else{
                System.out.println("Veuillez choisir le chiffre 1(combattre) ou 2(se deplacer) ");
            }
        }  
    }
    
    /**
     * méthode faisant jouer les monstres en les faisant se déplacer au hasard ou combattre si ils peuvent
     * @param m monstre joué
     * @return remove : enlève le monstre si sa vie est négative ou nulle
     */
    public boolean jouerMonstre(Monstre m){
        if (m.getPtVie()<=0){
            return true;
        }
        if(m instanceof Loup){
            for(ElementDeJeu e : this.elementList){
                if(m.getPos().distance(e.getPos())==1 && e instanceof Creature){
                    ((Loup) m).combattre((Creature) e);
                }
            }
        }
        boolean collision =true;
        if(!this.cerner(m, this.elementList)){
            Creature copie = new Loup();
            while(collision){
                copie.getPos().setX(m.getPos().getX());
                copie.getPos().setY(m.getPos().getY());
                copie.deplacer();
                collision = this.collision(copie);
            }
            m.setPos(copie.getPos());
        }
        return false;
    }
    
    /**
     * Méthode pour faire "jouer" les objets , i.e. les faire se consommer si quelqu'un se trouve dessus et faire bouger le nuage, revoie true si l'objet doit être supprimé
     * @param o objet qui peut être une potion, de la nourriture ou un nuage toxique
     */
    public boolean jouerObjet(Objet o){
        Iterator<ElementDeJeu> itrO = this.elementList.iterator();
        ElementDeJeu e;
        boolean remove =false;
        while(itrO.hasNext()){
            e= itrO.next();
            if(o.getPos().distance(e.getPos())==0 && e instanceof Personnage){
                if(o instanceof Mana){//l potion est bue
                    ((Mana)o).boire((Personnage)e);
                    remove=true;
                    System.out.println("la potion disparait ");
                }
                if(o instanceof Soin){//l potion est bue
                    ((Soin)o).boire((Personnage)e);
                    remove=true;
                    System.out.println("la potion disparait ");
                }
                else if(o instanceof Nourriture){//on mange la nourriture
                    ((Personnage)e).manger((Nourriture)o);
                    System.out.println("Nourriture mangée");
                    System.out.println("c'était de la "+o.getClass().getSimpleName());
                    remove=true;
                }
                else if(o instanceof NuageToxique){
                    ((NuageToxique)o).combattre((Creature)e);
                }
            }
        }
        if(o instanceof NuageToxique){
            ((NuageToxique)o).deplacer();
        }
        return remove;
    }
    
    /**
     * Méthode faisant jouer tout les personnages jouables, les monstres et activant les objets, puis elle regarde les buffs, les actives ou les désactive si nécessaire et supprime ceux qui sont périmés
     */
    public void tourDeJeu(){
        for(ElementDeJeu e : this.elementList){//on fait jouer tout les personnages, monstres, objets
            if(e instanceof Personnage){// on regarde si notre élément de jeu est un personnage
                if(((Personnage) e).jouable){ // on vérifie que le personnage est jouable
                    ((Personnage) e).affiche();
                    this.jouerPerso((Personnage) e);
                }
            }
        }
        Iterator<ElementDeJeu> itrE = this.elementList.iterator();
        while(itrE.hasNext()){
            ElementDeJeu e=itrE.next();
            if(e instanceof Monstre){
                if(this.jouerMonstre((Monstre) e)){//on fait jouer le monstre et on regarde si il meurt
                    System.out.println("Le "+ e.getClass().getSimpleName()+" qui est en ["+e.getPos().getX()+", "+e.getPos().getY()+"] succombe à la suite de ses blessures. \n");
                    itrE.remove();
                }
            }
            else if(e instanceof Objet){
                if(this.jouerObjet((Objet)e)){
                    itrE.remove();
                }
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
        for(ElementDeJeu e : this.elementList){//on fait le tour des buffs et des débuffs pour supprimer ceux qui sont périmés (ce n'est pas absolument nécessaire dans notre cas)
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

    /**
     * Méthode pour faire des tours de jeu jusqu'à que l'utilisateur décide d'arreter de jouer.
     */
    public void jouer(){
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        boolean error =true;
        while(cont){
            this.tourDeJeu();
            while(error){
                System.out.println("Voulez vous continuer ? [y/n]");
                String choix = sc.nextLine();
                if(choix.equals("n")){
                    this.afficheWorld();
                    System.out.println("Merci d'avoir joué");
                    error = false;
                    cont = false;
                }
                else if(choix.equals("y")){
                    System.out.println("Un ptit tour de plus !");
                    error=false;
                }
                else{
                    System.out.println("Merci d'écrire 'y' ou 'n'");
                }
            }
            error=true;
        }
    }

    public int getTailleMax() {
        return tailleMax;
    }

    public void setTailleMax(int tailleMax) {
        this.tailleMax = tailleMax;
    }

    public List<ElementDeJeu> getElementList() {
        return elementList;
    }

    public void setElementList(List<ElementDeJeu> elementList) {
        this.elementList = elementList;
    }
}   
