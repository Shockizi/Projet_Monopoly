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
public class CaseDépart extends CasePlateau{

    public CaseDépart(int numCase) {
        super(numCase);
    }

    @Override
    public ArrayList<Action> getActionPossible(Joueur j) {
        ArrayList<Action> actionsPossibes = new ArrayList<>();
        actionsPossibes.add(Action.DEPLACER);
        return actionsPossibes;
    }
    
    @Override
    public String getNom(){
        return "Case Départ"; 
    }
    
}
