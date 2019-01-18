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

    private int prixDAchat;
    private Joueur proprietaire;
    private String nom;

    public Propriete(int numCase) {
        super(numCase);
    }

    public Propriete(String nom, int prixDAchat, int numCase) {
        super(numCase);
        this.nom = nom;
        this.prixDAchat = prixDAchat;
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

    @Override
    public String getNom() {
        return nom;
    }

    public abstract int getLoyer();

    public abstract int getLoyer(Joueur j);

    @Override
    public void lancerAction(Action action, Joueur j) {
        if (action == Action.DEPLACER) {
            j.lancerDes();

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
