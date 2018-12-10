/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmonopoly;

import java.util.ArrayList;

/**
 *
 * @author elmiry
 */
public class Joueur {
    private String nom;
    private int cagnotte;
    private Case position;
    private ArrayList<Propriete> proprietes;
    

    public Joueur(String nom, int cagnotte) {
        this.nom = nom;
        this.cagnotte = cagnotte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCagnotte() {
        return cagnotte;
    }

    public void setCagnotte(int cagnotte) {
        this.cagnotte = cagnotte;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public ArrayList<Propriete> getProprietes() {
        return proprietes;
    }

    public void setProprietes(ArrayList<Propriete> proprietes) {
        this.proprietes = proprietes;
    }
    
    public int getNbGare(){
        int nb = 0;
        for(Propriete p : proprietes){
            if (p instanceof Gare){
                nb = nb +1;
            }            
        }
        return nb;
    }
    
}
