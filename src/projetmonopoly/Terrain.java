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
public class Terrain extends Propriete{
    private Couleur couleur;
    private int loyer;

    public Terrain(Couleur couleur, int loyer, String nom, int prixDAchat, int numCase) {
        super(nom, prixDAchat, numCase);
        this.couleur = couleur;
        this.loyer = loyer;
    }

    
    
    
}
