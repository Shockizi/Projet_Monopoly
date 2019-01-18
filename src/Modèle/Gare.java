/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author elmiry
 */
public class Gare extends Propriete {

    public Gare(String nom, int prixDAchat, int numCase) {
        super(nom, prixDAchat, numCase);
    }

    @Override
    public int getLoyer() {
        return super.getProprietaire().getNbGare() * 25;
    }

    @Override
    public int getLoyer(Joueur j) {
        return getLoyer();
    }

}
