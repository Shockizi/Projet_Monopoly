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
public class Compagnie extends Propriete {

    public Compagnie(String nom, int prixDAchat, int numCase) {
        super(nom, prixDAchat, numCase);
    }

    public int getLoyer(int nbc, int d1, int d2) {
        int loyer = 0;
        if (nbc == 1) {
            loyer = 4 * (d1 + d2);
        } else if (nbc == 2) {
            loyer = 10 * (d1 + d2);
        }
        return loyer;
    }

    @Override
    public int getLoyer() {
        int loyer = 0;
        if (super.getJoueur().getNbCompagnie() == 1) {
            loyer = 4 * (super.getJoueur().getDe1() + super.getJoueur().getDe2());
        } else if (super.getJoueur().getNbCompagnie() == 2) {
            loyer = 10 * (super.getJoueur().getDe1() + super.getJoueur().getDe2());
        }
        return loyer;
    }

}
