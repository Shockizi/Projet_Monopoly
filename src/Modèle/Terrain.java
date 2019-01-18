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
    private int loyer1m;
    private int loyer2m;
    private int loyer3m;
    private int loyer4m;
    private int loyerHotel;
    private int construMaisonHotel;
    private int nbMaison;
    private int nbHotel;
    
    public Terrain(Couleur couleur, int loyerDeBase, int loyer1m, int loyer2m, int loyer3m, int loyer4m, int loyerHotel, int construMaisonHotel, int nbMaison, int nbHotel, String nom, int prixDAchat, int numCase) {
        super(nom, prixDAchat, numCase);
        this.couleur = couleur;
        this.loyerDeBase = loyerDeBase;
        this.loyer1m = loyer1m;
        this.loyer2m = loyer2m;
        this.loyer3m = loyer3m;
        this.loyer4m = loyer4m;
        this.loyerHotel = loyerHotel;
        this.construMaisonHotel = construMaisonHotel;
        this.nbMaison = 0;
        this.nbHotel = 0;
    }

    
    
    
    Terrain(int numCase){
        super(numCase);
    }
    
    public int getLoyerDeBase() {
        return loyerDeBase;
    }

    public int getLoyer1m() {
        return loyer1m;
    }

    public int getLoyer2m() {
        return loyer2m;
    }

    public int getLoyer3m() {
        return loyer3m;
    }

    public int getLoyer4m() {
        return loyer4m;
    }

    public int getLoyerHotel() {
        return loyerHotel;
    }

    public int getConstruMaisonHotel() {
        return construMaisonHotel;
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
        } else if (this.getCouleur() == Couleur.MARRON && nbCouleur == 2) {
            loyer = this.loyerDeBase * 2;
        } else if (this.getCouleur() == Couleur.ROSE && nbCouleur == 3) {
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
