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
public class Plateau {
    private ArrayList<Joueur> joueurs ;
    private ArrayList<CasePlateau> casesPlat;

    public Plateau() {
        joueurs = new ArrayList<>();
        casesPlat = new ArrayList<>();
    }
    
    public void addJoueur(Joueur j){
        joueurs.add(j);
    }
}
