/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmonopoly;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author elmiry
 */
public class Controleur {

    private ArrayList<CasePlateau> plateau;
    private ArrayList<Joueur> joueurs;
    private Joueur joueurCourant;

    public Controleur(ArrayList<Joueur> joueurs) {
        initPlateau();
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

    public void initPlateau() {
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
        plateau.add(new Terrain(Couleur.BLEU_FONCE, 50, "Rue de la Paix", 400, 40));
    }

    public void tourDeJeu() {
        for (Joueur j : joueurs) {
            j.setCagnotte(1500);
            j.setPosition(plateau.get(0));
        }

        boolean gagnant = false;
        while (gagnant = false) {
            System.out.println(joueurCourant.getNom() + " à vous de jouer");
            System.out.println("Saisissez le numéro d'action que vous souhaitez effectuer : ");
            boolean achatPossible = false;
            for (Action a : joueurCourant.getPosition().getActionPossible()) {
                if (a == Action.DEPLACER) {
                    joueurCourant.getPosition().lancerAction(Action.DEPLACER);
                    System.out.println("    1. FIN DU TOUR");
                    System.out.println("    2. CONSULTER PROPRIETES");
                    System.out.println("    3. CONSULTER CAGNOTTE");
                } else if (a == Action.ACHETER) {
                    System.out.println("    4. ACHETER");
                    achatPossible = true;
                } else if (a == Action.PAYER) {
                    joueurCourant.getPosition().lancerAction(Action.PAYER);
                }
            }
            int numAct = 0;
            while (numAct != 1) {
                Scanner sc = new Scanner(System.in);
                numAct = sc.nextInt();
                if (numAct == 1) {
                    joueurSuivant();
                } else if (numAct == 2) {
                    System.out.println("Voici les propriétés en votre possession : ");
                    for (Propriete p : joueurCourant.getProprietes()) {
                        System.out.println("    - " + p.getNom());
                    }
                    System.out.println("    1. FIN DU TOUR");
                    System.out.println("    2. CONSULTER PROPRIETES");
                    System.out.println("    3. CONSULTER CAGNOTTE");
                } else if (numAct == 3) {
                    System.out.println("Il reste " + joueurCourant.getCagnotte() + "€ sur votre cagnotte");
                    for (Propriete p : joueurCourant.getProprietes()) {
                        System.out.println("    - " + p.getNom());
                    }
                    System.out.println("    1. FIN DU TOUR");
                    System.out.println("    2. CONSULTER PROPRIETES");
                    System.out.println("    3. CONSULTER CAGNOTTE");
                } else if (numAct == 4 && achatPossible) {
                    joueurCourant.getPosition().lancerAction(Action.ACHETER);
                    System.out.println(joueurCourant.getNom() + ", vous possédez désormais " + joueurCourant.getPosition());
                    System.out.println("Il reste " + joueurCourant.getCagnotte() + "€ sur votre cagnotte");
                    System.out.println("Saisissez le numéro d'action que vous souhaitez effectuer : ");
                    System.out.println("    1. FIN DU TOUR");
                    System.out.println("    2. CONSULTER PROPRIETES");
                    System.out.println("    3. CONSULTER CAGNOTTE");
                } else {
                    System.out.println("Veuillez re-saisir le numéro d'action souhaité : ");
                }
            }
        }

    }
}
