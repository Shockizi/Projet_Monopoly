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
public class Joueur {

    private String nom;
    private int cagnotte = 1500;
    private Case position;
    private ArrayList<Propriete> proprietes;

    public Joueur(String nom, int cagnotte) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCagnotte() {
        return cagnotte;
    }

    public void setCagnotte(int cagnotte) {
        this.cagnotte = cagnotte;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(int d1, int d2) {
        this.getPosition().setNumCase(this.getPosition().getNumCase() + d2 + d1);
    }

    public ArrayList<Propriete> getProprietes() {
        return proprietes;
    }

    public void setProprietes(ArrayList<Propriete> proprietes) {
        this.proprietes = proprietes;
    }

    public int getNbGare() {
        int nb = 0;
        for (Propriete p : proprietes) {
            if (p instanceof Gare) {
                nb = nb + 1;
            }
        }
        return nb;
    }
    
    

    public void achat(int pA) {
        cagnotte = cagnotte - pA;
    }

    public void retirePropriete() {
        for (Propriete p : proprietes) {
            this.proprietes.remove(p);
        }
    }

    public int getNbCompagnie() {
        int nb = 0;
        for (Propriete p : proprietes) {
            if (p instanceof Compagnie) {
                nb = nb + 1;
            }
        }
        return nb;
    }

    public void acheter() {
        if (this.getPosition().getPrixDAchat() < this.getCagnotte()) {
            achat(this.getPosition().getPrixDAchat());
            proprietes.add();
        }
    }
}
