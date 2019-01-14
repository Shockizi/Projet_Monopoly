/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Controleur.Controleur;
import Modèle.Joueur;
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

        Controleur c = new Controleur();
        c.inscrireJoueur(new Joueur("Henni"));
        c.inscrireJoueur(new Joueur("Jamy"));
        c.partieDemo();

    }

}
