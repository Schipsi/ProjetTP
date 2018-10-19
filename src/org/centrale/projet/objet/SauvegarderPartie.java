/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author grego
 */
public class SauvegarderPartie {
    /**
     * nom du fichier sauvegarde se finit par .txt
     */
    protected String filename;
    /**
     * buffer objet magique et merveilleux
     */
    protected BufferedWriter buffer;
    
    /**
     * méthode constructeur de SauvegarderPartie
     * @param filename nom du fichier sauvegarde
     */
    public SauvegarderPartie(String filename) {
        this.filename = filename;
    }
    /**
     * Fonction de sauvegarde d'une partie
     * @param monde monde a sauvegarder
     */
    public void sauvegarderPartie(World monde){
        try{
            this.buffer= new BufferedWriter(new FileWriter(this.filename));
            buffer.write("Taille "+monde.tailleMax);
            buffer.newLine();
            for(ElementDeJeu e:monde.elementList){
                if(e instanceof Potion){
                    buffer.write(e.getClass().getSimpleName()+" "
                                + ((Potion) e).ptRegen +" "
                                +((Potion) e).pos.getX()+" "
                                +((Potion) e).pos.getY()+" ");
                    buffer.newLine();
                }
                if(e instanceof Monstre){
                    buffer.write(e.getClass().getSimpleName()+" "
                                +((Monstre) e).getPtVie()+" "
                                +((Monstre) e).getPtPar()+" "
                                +((Monstre) e).getPourcentageAtt()+" "
                                +((Monstre) e).getPourcentagePar()+" "
                                +((Monstre) e).getDegAtt()+" "
                                +((Monstre) e).getPos().getX()+" "
                                +((Monstre) e).getPos().getY()+" ");
                    buffer.newLine();
                }
                if(e instanceof Nourriture){
                    buffer.write(e.getClass().getSimpleName()+" "
                                +((Nourriture) e).getDuree()+" "
                                +e.getPos().getX()+" "
                                +e.getPos().getY()+" ");
                    buffer.newLine();
                }
                if(e instanceof Personnage){
                    if(e instanceof Archer){
                        buffer.write(e.getClass().getSimpleName()+" "
                                    +((Archer) e).getNom()+" "
                                    +((Archer) e).getPtVie()+" "
                                    +((Archer) e).getPtPar()+" "
                                    +((Archer) e).getPtMana()+" "
                                    +((Archer) e).getPourcentageAtt()+" "
                                    +((Archer) e).getPourcentagePar()+" "
                                    +((Archer) e).getPourcentageMag()+" "
                                    +((Archer) e).getPourcentageResistMag()+" "
                                    +((Archer) e).getDegAtt()+" "
                                    +((Archer) e).getDegMag()+" "
                                    +((Archer) e).getDistAttMax()+" "
                                    +((Archer) e).getPos().getX()+" "
                                    +((Archer) e).getPos().getY()+" "
                                    +((Archer) e).isJouable()+" "
                                    +((Archer) e).getNbFleches()+" ");
                        if(!((Archer) e).buffs.isEmpty()){
                            buffer.write(",");
                            for(Nourriture buff:((Archer) e).buffs){
                                if(buff instanceof ViandeDeZombie){
                                    buffer.write("ViandeDeZombie "+buff.getDuree()+" ");
                                }
                                else if(buff instanceof PommeDoree){
                                    buffer.write("PommeDoree "+buff.getDuree()+" ");
                                }
                            }
                        }
                        buffer.newLine();
                    }
                    else{
                     buffer.write(e.getClass().getSimpleName()+" "
                                    +((Personnage) e).getNom()+" "
                                    +((Personnage) e).getPtVie()+" "
                                    +((Personnage) e).getPtPar()+" "
                                    +((Personnage) e).getPtMana()+" "
                                    +((Personnage) e).getPourcentageAtt()+" "
                                    +((Personnage) e).getPourcentagePar()+" "
                                    +((Personnage) e).getPourcentageMag()+" "
                                    +((Personnage) e).getPourcentageResistMag()+" "
                                    +((Personnage) e).getDegAtt()+" "
                                    +((Personnage) e).getDegMag()+" "
                                    +((Personnage) e).getDistAttMax()+" "
                                    +((Personnage) e).getPos().getX()+" "
                                    +((Personnage) e).getPos().getY()+" "
                                    +((Personnage) e).isJouable()+" ");
                        if(!((Personnage) e).buffs.isEmpty()){
                            buffer.write(",");
                            for(Nourriture buff:((Personnage) e).buffs){
                                if(buff instanceof ViandeDeZombie){
                                    buffer.write("ViandeDeZombie "+buff.getDuree()+" ");
                                }
                                else if(buff instanceof PommeDoree){
                                    buffer.write("PommeDoree "+buff.getDuree()+" ");
                                }
                            }
                        }
                        buffer.newLine();   
                    }
                }
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if (buffer != null) {
                    buffer.flush();
                    buffer.close();
                }
            }
             catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }  
}
