/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.ArrayList;

/**
 *
 * @author elmiry
 */
public abstract class CasePlateau {

    private int numCase;

    public CasePlateau(int numCase) {
        this.numCase = numCase;
    }

    public int getNumCase() {
        return numCase;
    }
    
    public String getNom(){
        return "Case" + numCase;
    }

    public void setNumCase(int numCase) {
        this.numCase = numCase;
    }

    public ArrayList<Action> getActionPossible(Joueur j) {
        ArrayList<Action> actionsPossibes = new ArrayList<>();
        actionsPossibes.add(Action.DEPLACER);
        return actionsPossibes;
    }

    public void lancerAction(Action action, Joueur j) {
        if (action == Action.DEPLACER) {
            j.lancerDes();
        }
    }

}
