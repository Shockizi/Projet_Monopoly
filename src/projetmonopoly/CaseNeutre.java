/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmonopoly;

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

}
