/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.ArrayList;

/**
 *
 * @author yamin
 */
public class CaseNeutre extends CasePlateau {

    public CaseNeutre(int numCase) {
        super(numCase);
    }

    @Override
    public int getPrixDAchat() {
        return 0;
    }

    @Override
    public String getNom() {
        return "Case Neutre " + super.getNumCase();
    }

    @Override
    public ArrayList<Action> getActionPossible(Joueur j) {
        ArrayList<Action> actionsPossibes = new ArrayList<>();
        actionsPossibes.add(Action.DEPLACER);
        return actionsPossibes;
    }

    @Override
    public Joueur getProprietaire() {
        return null;
    }

    @Override
    public int getLoyer() {
        return 0;
    }

    @Override
    public int getLoyer(Joueur j) {
        return 0;
    }

}
