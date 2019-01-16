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
public class CaseTerrain extends CasePlateau{

    @Override
    public ArrayList<Action> getActionPossible(Joueur j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CaseTerrain(int numCase) {
        super(numCase);
    }
    
}
