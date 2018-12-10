/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmonopoly;

/**
 *
 * @author elmiry
 */
public abstract class Case {
    private int numCase;
    private Joueur joueur;
    private Case type;
    public Case(int numCase) {
        this.numCase = numCase;
    }

    public int getNumCase() {
        return numCase;
    }

    public void setNumCase(int numCase) {
        this.numCase = numCase;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    
    public abstract int getPrixDAchat();
    
    
    
}
