/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmonopoly;

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
    
    public int getPrixDAchat() {
        return prixDAchat;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void addProprietaire(Joueur p){
        this.proprietaire = p;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void lancerAction(){
        
    }
    
    
    
}
