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

    @Override
    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void addProprietaire(Joueur p) {
        this.proprietaire = p;
        p.addProriete(this);
    }

    @Override
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        System.out.println("Dep");
        if (proprietaire != null && j != proprietaire) {
            actionsPossibes.add(Action.PAYER);
            System.out.println("pay");
        } else if (proprietaire == null && j.getCagnotte() > this.getPrixDAchat()) {
            actionsPossibes.add(Action.ACHETER);
            System.out.println("Ach");
        }
        return actionsPossibes;
    }

}
