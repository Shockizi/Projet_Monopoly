/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmonopoly;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author elmiry
 */
public class Controleur {

    private ArrayList<CasePlateau> plateau;
    private ArrayList<Joueur> joueurs;
    private Joueur joueurCourant;

    public Controleur(ArrayList<CasePlateau> cases, ArrayList<Joueur> joueurs) {
        this.plateau = cases;
        this.joueurs = joueurs;
        this.joueurCourant = joueurs.get(0);
    }

    public Joueur getJoueurCourant() {
        return this.joueurCourant;
    }

    public void joueurSuivant() {
        int i = 0;
        for (Joueur j : joueurs) {
            i += 1;
            if (joueurCourant == j && joueurs.size() == (i + 1)) {
                joueurCourant = joueurs.get(0);
            } else if (joueurCourant == j) {
                joueurCourant = joueurs.get(i);
            }
        }
    }
}
