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
public class Gare extends Propriete {

    public Gare(String nom, int prixDAchat, int numCase) {
        super(nom, prixDAchat, numCase);
    }

    public Gare(String nom, int prixDAchat, Joueur proprietaire, int numCase) {
        super(nom, prixDAchat, proprietaire, numCase);
    }

    @Override
    public int getLoyer() {
        return super.getProprietaire().getNbGare() * 25;
    }

}
