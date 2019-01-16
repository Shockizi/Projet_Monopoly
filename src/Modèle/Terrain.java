/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author elmiry
 */
public class Terrain extends Propriete {

    private Couleur couleur;
    private int loyerDeBase;   
    private int nbMaison;
    private int nbHotel;
    
    public Terrain(Couleur couleur, int loyer, String nom, int prixDAchat, int numCase) {
        super(nom, prixDAchat, numCase);
        this.couleur = couleur;
        this.loyerDeBase = loyer;
        this.nbMaison = 0;
        this.nbHotel = 0;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public int getLoyer() {
        int loyer = 0;
        int nbCouleur = 0;
        for (Propriete p : super.getProprietaire().getProprietes()) {
            if (p instanceof Terrain) {
                if (((Terrain) p).getCouleur() == this.getCouleur()) {
                    nbCouleur += 1;
                }
            }
        }
        if (this.getCouleur() == Couleur.BLEU_FONCE && nbCouleur == 2) {
            loyer = this.loyerDeBase * 2;
        } else if (this.getCouleur() == Couleur.ORANGE && nbCouleur == 3) {
            loyer = this.loyerDeBase * 2;
        } else if (this.getCouleur() == Couleur.MAUVE && nbCouleur == 2) {
            loyer = this.loyerDeBase * 2;
        } else if (this.getCouleur() == Couleur.VIOLET && nbCouleur == 3) {
            loyer = this.loyerDeBase * 2;
        } else if (this.getCouleur() == Couleur.BLEU_CIEL && nbCouleur == 3) {
            loyer = this.loyerDeBase * 2;
        } else if (this.getCouleur() == Couleur.JAUNE && nbCouleur == 3) {
            loyer = this.loyerDeBase * 2;
        } else if (this.getCouleur() == Couleur.VERT && nbCouleur == 3) {
            loyer = this.loyerDeBase * 2;
        } else if (this.getCouleur() == Couleur.ROUGE && nbCouleur == 3) {
            loyer = this.loyerDeBase * 2;
        } else {
            loyer = loyerDeBase;
        }
        return loyer;
    }

    @Override
    public int getLoyer(Joueur j) {
        return getLoyer();
    }

    public int getNbMaison() {
        return nbMaison;
    }

    public void setNbMaison(int nbMaison) {
        this.nbMaison = nbMaison;
    }

    public int getNbHotel() {
        return nbHotel;
    }

    public void setNbHotel(int nbHotel) {
        this.nbHotel = nbHotel;
    }
    
}
