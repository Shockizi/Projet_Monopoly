/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.ArrayList;

/**
 *
 * @author lorauxs
 */
public class ImpotsTaxe extends CasePlateau {

    private int montant;

    public ImpotsTaxe(int numCase) {
        super(numCase);
        this.setMontant(montant);

    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        if (this.getNumCase() == 5) {
            this.montant = 200;
        } else if (this.getNumCase() == 39) {
            this.montant = 100;
        }
    }

    @Override
    public ArrayList<Action> getActionPossible(Joueur j) {
        ArrayList<Action> actionsPossibes = new ArrayList<>();
        actionsPossibes.add(Action.DEPLACER);
        actionsPossibes.add(Action.PAYER);

        return actionsPossibes;
    }

    @Override
    public String getNom() {
        String s = null;

        if (getNumCase() == 5) {
            s = "Impôt sur le revenu";
        } else if (getNumCase() == 39) {
            s = "Taxe de luxe";
        }

        return s;
    }

}
