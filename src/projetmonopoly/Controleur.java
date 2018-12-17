/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmonopoly;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author elmiry
 */
public class Controleur {

    private ArrayList<CasePlateau> plateau;
    private ArrayList<Joueur> joueurs;
    private Joueur joueurCourant;

    public Controleur(ArrayList<CasePlateau> cases, ArrayList<Joueur> joueurs) {
        this.plateau = cases;
        this.joueurs = joueurs;
        this.joueurCourant = joueurs.get(0);
    }

    public Joueur getJoueurCourant() {
        return this.joueurCourant;
    }

    public void joueurSuivant() {
        int i = 0;
        for (Joueur j : joueurs) {
            i += 1;
            if (joueurCourant == j && joueurs.size() == (i + 1)) {
                joueurCourant = joueurs.get(0);
            } else if (joueurCourant == j) {
                joueurCourant = joueurs.get(i);
            }
        }
    }
    
    public void initPlateau(){
        plateau.add(new CaseNeutre(1));
        plateau.add(new Terrain(Couleur.MAUVE, 2, "Boulevard de Belleville", 60, 2));
        plateau.add(new CaseNeutre(3));
        plateau.add(new Terrain(Couleur.MAUVE, 4, "Rue Lecourbe", 60, 4));
        plateau.add(new CaseNeutre(5));
        plateau.add(new Gare("Gare Montparnasse", 200, 6));
        plateau.add(new Terrain(Couleur.BLEU_CIEL, 6, "Rue de Vaugirard", 100, 7));
        plateau.add(new CaseNeutre(8));
        plateau.add(new Terrain(Couleur.BLEU_CIEL, 6, "Rue de Courcelles", 100, 9));
        plateau.add(new Terrain(Couleur.BLEU_CIEL, 8, "Avenue de la République", 120, 10));
        plateau.add(new CaseNeutre(11));
        plateau.add(new Terrain(Couleur.VIOLET, 10, "Boulevard de la Villette", 140, 12));
        plateau.add(new Compagnie("Compagnie de distribution d'éléctricité", 150, 13));
        plateau.add(new Terrain(Couleur.VIOLET, 10, "Avenue de Neuilly", 140, 14));
        plateau.add(new Terrain(Couleur.VIOLET, 12, "Rue de Paradis", 160, 15));
        plateau.add(new Gare("Gare de Lyon", 200, 16));
        plateau.add(new Terrain(Couleur.ORANGE, 14, "Avenue Mozart", 180, 17));
        plateau.add(new CaseNeutre(18));
        plateau.add(new Terrain(Couleur.ORANGE, 14, "Boulevard Saint-Michel", 180, 19));
        plateau.add(new Terrain(Couleur.ORANGE, 16, "Place Pigalle", 200, 20));
        plateau.add(new CaseNeutre(21));
        plateau.add(new Terrain(Couleur.ROUGE, 18, "Avenue Matignon", 220, 22));
        plateau.add(new CaseNeutre(23));
        plateau.add(new Terrain(Couleur.ROUGE, 18, "Boulevard Malesherbes", 220, 24));
        plateau.add(new Terrain(Couleur.ROUGE, 20, "Avenue Henri-Martin", 240, 25));
        plateau.add(new Gare("Gare du Nord", 200, 26));
        plateau.add(new Terrain(Couleur.JAUNE, 22, "Faubourg Saint-Honoré", 260, 27));
        plateau.add(new Terrain(Couleur.JAUNE, 22, "Place de la Bourse", 260, 28));
        plateau.add(new Compagnie("Compagnie de distribution des eaux", 150, 29));
        plateau.add(new Terrain(Couleur.JAUNE, 24, "Rue La Fayette", 280, 30));
        plateau.add(new CaseNeutre(31));
        plateau.add(new Terrain(Couleur.VERT, 26, "Avenue de Breteuil", 300, 32));
        plateau.add(new Terrain(Couleur.VERT, 26, "Avenue Foch", 300, 33));
        plateau.add(new CaseNeutre(34));
        plateau.add(new Terrain(Couleur.VERT, 28, "Boulevard des Capucines", 320, 35));
        plateau.add(new Gare("Gare Saint-Lazard", 200, 36));
        plateau.add(new CaseNeutre(37));
        plateau.add(new Terrain(Couleur.BLEU_FONCE, 35, "Avenue des Champs-Elysées", 350, 38));
        plateau.add(new CaseNeutre(39));
        plateau.add(new Terrain(Couleur.BLEU_FONCE, 50, "Avenue des Champs-Elysées", 400, 40));
    }
}
