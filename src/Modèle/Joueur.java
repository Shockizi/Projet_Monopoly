/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author elmiry
 */
public class Joueur {

    private String nom;
    private int cagnotte = 1500;
    private CasePlateau position;
    private ArrayList<Propriete> proprietes = new ArrayList<>();
    private Plateau plateau = new Plateau();
    private int de1, de2;
    private int carteLiberéDePrison;

    public Joueur(String nom) {
        this.nom = nom;
        this.carteLiberéDePrison = 0;
        position = plateau.getCasePlateau(1);
    }

    public int getCarteLiberéDePrison() {
        return carteLiberéDePrison;
    }

    public void setCarteLiberéDePrison(int carteLiberéDePrison) {
        this.carteLiberéDePrison = carteLiberéDePrison;
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

    public CasePlateau getPosition() {
        return position;
    }

    public int getNumCaseCourante() {
        return this.position.getNumCase();
    }

    public void setPosition(int numCase) {
        this.position = plateau.getCasePlateau(numCase);
    }

    public void lancerDes() {
        Random r = new Random();
        int d1 = 1 + r.nextInt(6);
        int d2 = 1 + r.nextInt(6);
        this.de1 = d1;
        this.de2 = d2;
    }

    public boolean verifDouble() {
        return (this.de1 == this.de2);
    }

    public int getDe1() {
        return de1;
    }

    public int getDe2() {
        return de2;
    }

    public ArrayList<Propriete> getProprietes() {
        return proprietes;
    }

    public void setProprietes(ArrayList<Propriete> proprietes) {
        this.proprietes = proprietes;
    }

    public void addProriete(Propriete p) {
        proprietes.add(p);
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

    public void retirerProprietes() {
        for (int i = 0; i < proprietes.size(); i++) {
            proprietes.get(0).removeProprietaire(this);
            proprietes.remove(proprietes.get(0));
        }
//        for (Propriete p : proprietes) {
//            if (proprietes.size() > 0) {
//                proprietes.get(0).removeProprietaire(this);
//                this.proprietes.remove(proprietes.get(0));
//            }
//        }
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
    
    public void payerJoueur(int montant, Joueur j){
        this.cagnotte = cagnotte - montant;
        j.setCagnotte(j.getCagnotte() + montant);
    }

}
