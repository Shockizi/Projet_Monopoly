/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmonopoly;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author elmiry
 */
public class Controleur {
    private ArrayList<Case> cases;
    private ArrayList<Joueur> joueurs;
    private Joueur joueurCourant;

    public Controleur(ArrayList<Case> cases, ArrayList<Joueur> joueurs) {
        this.cases = cases;
        this.joueurs = joueurs;
    }
    
    public int lancerDe(){
        Random r = new Random();
        int de = 1 + r.nextInt(6 - 1);
        return de;
    }
    
    public Joueur getJoueurCourant(){
        return this.joueurCourant;
    }
    
    public void joueurSuivant(){
        boolean jctrouve = false;
        Joueur jSuivant = null;
        for(Joueur jc : joueurs){
            if(jctrouve){
                jSuivant = jc;
            }
            if(jc == this.joueurCourant){
                jctrouve = true;
            }
        }
        this.joueurCourant = jSuivant;
    }
    
}
