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
public abstract class Propriete extends CasePlateau {

    private Terrains_enum terrain;
    private Gares_enum gare;
    private Compagnies_enum compagnie;
    private int prixDAchat;
    private Joueur proprietaire;
    
    public Propriete(int numCase){
        super(numCase);
    }

    public Propriete(Terrains_enum terrain, int prixDAchat, int numCase) {
        super(numCase);
        this.terrain = terrain;
        this.prixDAchat = prixDAchat;
    }

    public Propriete(Gares_enum gare, int prixDAchat, int numCase) {
        super(numCase);
        this.gare = gare;
        this.prixDAchat = prixDAchat;
    }

    public Propriete(Terrains_enum terrain, int prixDAchat, Joueur proprietaire, int numCase) {
        super(numCase);
        this.terrain = terrain;
        this.prixDAchat = prixDAchat;
        this.proprietaire = proprietaire;

    }

    public Propriete(Gares_enum gare, int prixDAchat, Joueur proprietaire, int numCase) {
        super(numCase);
        this.gare = gare;
        this.prixDAchat = prixDAchat;
        this.proprietaire = proprietaire;

    }

    public Propriete(Compagnies_enum compagnie, int prixDAchat, int numCase) {
        super(numCase);
        this.compagnie = compagnie;
        this.prixDAchat = prixDAchat;
    }

    public Propriete(Compagnies_enum compagnie, int prixDAchat, Joueur proprietaire, int numCase) {
        super(numCase);
        this.compagnie = compagnie;
        this.prixDAchat = prixDAchat;
        this.proprietaire = proprietaire;
    }

    public int getPrixDAchat() {
        return prixDAchat;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void addProprietaire(Joueur p) {
        this.proprietaire = p;
        p.addProriete(this);
    }

    public void removeProprietaire(Joueur p) {
        this.proprietaire = null;
    }

    public Terrains_enum getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrains_enum terrain) {
        this.terrain = terrain;
    }

    public Gares_enum getGare() {
        return gare;
    }

    public void setGare(Gares_enum gare) {
        this.gare = gare;
    }

    public abstract int getLoyer();

    public abstract int getLoyer(Joueur j);

    @Override
    public void lancerAction(Action action, Joueur j) {
        if (action == Action.DEPLACER) {
            j.lancerDes();
            j.avancer();

        } else if (action == Action.PAYER && proprietaire != null && j != proprietaire) {
            if (j.getCagnotte() < getLoyer()) {
                proprietaire.setCagnotte(proprietaire.getCagnotte() + j.getCagnotte());
            } else {
                proprietaire.setCagnotte(proprietaire.getCagnotte() + getLoyer());
            }
            j.setCagnotte(j.getCagnotte() - getLoyer());

        } else if (action == Action.ACHETER && proprietaire == null && j.getCagnotte() > this.getPrixDAchat()) {
            j.setCagnotte(j.getCagnotte() - this.getPrixDAchat());
            this.addProprietaire(j);
        }
    }

    @Override
    public ArrayList<Action> getActionPossible(Joueur j) {
        ArrayList<Action> actionsPossibes = new ArrayList<>();
        actionsPossibes.add(Action.DEPLACER);
        if (proprietaire != null && j != proprietaire) {
            actionsPossibes.add(Action.PAYER);
        } else if (proprietaire == null && j.getCagnotte() > this.getPrixDAchat()) {
            actionsPossibes.add(Action.ACHETER);
        }
        return actionsPossibes;

    }

}
