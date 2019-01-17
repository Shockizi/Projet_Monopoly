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
public class Compagnie extends Propriete {

    public Compagnie(Compagnies_enum compagnie, int prixDAchat, int numCase) {
        super(compagnie, prixDAchat, numCase);
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
    public int getLoyer(Joueur j) {
        int loyer = 0;
        if (super.getProprietaire().getNbCompagnie() == 1) {
            loyer = 4 * (j.getDe1() + j.getDe2());
        } else if (super.getProprietaire().getNbCompagnie() == 2) {
            loyer = 10 * (j.getDe1() + j.getDe2());
        }
        return loyer;
    }

    @Override
    public int getLoyer() {
        return 0;
    }

}
