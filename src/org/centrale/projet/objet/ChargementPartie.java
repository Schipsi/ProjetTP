/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Thibs
 */
public class ChargementPartie {
    protected String source;
    protected BufferedReader buffer;
    
    public ChargementPartie(String source) {
        this.source = source;
    }
    
    public World chargerPartie() {
        int taille = 0;
        List<ElementDeJeu> elementList = new ArrayList<>();        
        try {
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader(source));
            ligne = fichier.readLine();
            while (ligne != null) {
                StringTokenizer status = new StringTokenizer(ligne, ",");
                List<Nourriture> buffs = new ArrayList<>();
                String temp = status.nextToken();
                System.out.println(temp);
                if (status.hasMoreTokens()) {
                   String temp2 = status.nextToken();
                   StringTokenizer listBuffs = new StringTokenizer(temp2, " ");
                   while (listBuffs.hasMoreTokens()) {
                       String typeBuff = listBuffs.nextToken();
                       if (typeBuff.equals("PommeDoree")) {
                           Nourriture nourriture = new PommeDoree(Integer.parseInt(listBuffs.nextToken()), new Point2D());
                           nourriture.pos = null;
                           buffs.add(nourriture);
                       } else if (typeBuff.equals("ViandeDeZombie")) {
                           Nourriture nourriture = new ViandeDeZombie(Integer.parseInt(listBuffs.nextToken()), new Point2D());
                           nourriture.pos = null;
                           buffs.add(nourriture);
                       }
                   }
                }
                StringTokenizer tokenizer = new StringTokenizer(temp, " ");
                if (tokenizer.hasMoreTokens()) {
                    String mot  = tokenizer.nextToken();
                    if (mot.equals("Taille")) {
                        taille = Integer.parseInt(tokenizer.nextToken());
                    } else if (mot.equals("Mage")) {
                        elementList.add(new Mage(
                                tokenizer.nextToken(),
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()),
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())),
                                Boolean.parseBoolean(tokenizer.nextToken()),
                                buffs
                        ));
                    } else if (mot.equals("Guerrier")) {
                        elementList.add(new Guerrier(
                                tokenizer.nextToken(),
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()),
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())),
                                Boolean.parseBoolean(tokenizer.nextToken()),
                                buffs
                        ));
                    } else if (mot.equals("Archer")) {
                        elementList.add(new Archer(
                                tokenizer.nextToken(),
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()),
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())),
                                Boolean.parseBoolean(tokenizer.nextToken()),
                                buffs,
                                Integer.parseInt(tokenizer.nextToken())
                        ));
                    } else if (mot.equals("Paysan")) {
                        elementList.add(new Paysan(
                                tokenizer.nextToken(),
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()),
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())),
                                Boolean.parseBoolean(tokenizer.nextToken()),
                                buffs
                        ));
                    } else if (mot.equals("Loup")) {
                        elementList.add(new Loup(
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()))
                        ));
                    } else if (mot.equals("Lapin")) {
                        elementList.add(new Lapin(
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                Integer.parseInt(tokenizer.nextToken()), 
                                new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()))
                        ));
                    } else if (mot.equals("Mana")) {
                        elementList.add(new Mana(
                                Integer.parseInt(tokenizer.nextToken()), 
                                new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()))
                        ));
                    } else if (mot.equals("Soin")) {
                        elementList.add(new Soin(
                                Integer.parseInt(tokenizer.nextToken()), 
                                new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()))
                        ));
                    } else if (mot.equals("ViandeDeZombie")) {
                        elementList.add(new ViandeDeZombie(
                                Integer.parseInt(tokenizer.nextToken()), 
                                new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()))
                        ));
                    } else if (mot.equals("NuageToxique")) {
                        elementList.add(new NuageToxique( 
                                new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()))
                        ));
                    } else if (mot.equals("PommeDoree")) {
                        elementList.add(new PommeDoree( 
                                Integer.parseInt(tokenizer.nextToken()),
                                new Point2D(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()))
                        ));
                    } 
                }
                ligne = fichier.readLine();
            }
            
            fichier.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        World monde = new World(taille);
        monde.setElementList(elementList);
        return monde;
    }
}
