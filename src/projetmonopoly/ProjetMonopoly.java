/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmonopoly;

import java.util.ArrayList;

/**
 *
 * @author elmiry
 */
public class ProjetMonopoly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Joueur> joueurs = new ArrayList<>(); 
        joueurs.add(new Joueur("Henni"));
        joueurs.add(new Joueur("Jamy"));
        joueurs.add(new Joueur("Fred"));
        
        Controleur c = new Controleur(joueurs);
        c.partieDemo();
        
    }

}
