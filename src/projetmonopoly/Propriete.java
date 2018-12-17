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
public abstract class Propriete extends CasePlateau {

    private String nom;
    private int prixDAchat;
    private Joueur proprietaire;

    public Propriete(String nom, int prixDAchat, int numCase) {
        super(numCase);
        this.nom = nom;
        this.prixDAchat = prixDAchat;
    }

    public Propriete(String nom, int prixDAchat, Joueur proprietaire, int numCase) {
        super(numCase);
        this.nom = nom;
        this.prixDAchat = prixDAchat;
        this.proprietaire = proprietaire;
    }

    @Override
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public abstract int getLoyer();

    @Override
    public void lancerAction(Action action) {
        if (action == Action.DEPLACER) {
            super.getJoueur().lancerDes();
            super.getJoueur().avancer(super.getJoueur().getDe1(), super.getJoueur().getDe2());

        } else if (action == Action.PAYER && proprietaire != null && super.getJoueur() != proprietaire) {
            if (super.getJoueur().getCagnotte() < getLoyer()) {
                proprietaire.setCagnotte(proprietaire.getCagnotte() + super.getJoueur().getCagnotte());
            } else {
                proprietaire.setCagnotte(proprietaire.getCagnotte() + getLoyer());
            }
            super.getJoueur().setCagnotte(super.getJoueur().getCagnotte() - getLoyer());

        } else if (action == Action.ACHETER && proprietaire == null && super.getJoueur().getCagnotte() > this.getPrixDAchat()) {
            super.getJoueur().setCagnotte(super.getJoueur().getCagnotte() - this.getPrixDAchat());
            this.addProprietaire(super.getJoueur());
        }
    }

    @Override
    public ArrayList<Action> getActionPossible() {
        ArrayList<Action> actionsPossibes = new ArrayList<>();
        actionsPossibes.add(Action.DEPLACER);
        if (proprietaire != null && super.getJoueur() != proprietaire) {
            actionsPossibes.add(Action.PAYER);
        } else if (proprietaire == null && super.getJoueur().getCagnotte() > this.getPrixDAchat()) {
            actionsPossibes.add(Action.ACHETER);
        }
        return actionsPossibes;
    }

}
