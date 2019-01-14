/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author lorauxs
 */
public class CasePrison extends CasePlateau{

    @Override
    public Joueur getProprietaire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CasePrison(int numCase) {
        super(numCase = 11);
    }
    
    
    
}
