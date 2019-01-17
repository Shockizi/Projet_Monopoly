/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import IHM.Accueil;
import IHM.IHMNbJoueurs;
import IHM.IHMRegles;
import IHM.Inscription;
import IHM.PlateauBis;
import Message.Message;
import Message.TypeMessages;
import Modèle.Action;
import Modèle.CasePlateau;
import Modèle.Compagnie;
import Modèle.Couleur;
import Modèle.Gare;
import Modèle.Joueur;
import Modèle.Plateau;
import Modèle.Propriete;
import Modèle.Terrain;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author elmiry
 */
public class Controleur implements Observer {

    private Plateau p = new Plateau();
    private Joueur joueurCourant;
    private Accueil ihm;
    private IHMNbJoueurs ihmnbJoueurs;
    private IHMRegles ihmregles;
    private Inscription ihmInsc;
    private PlateauBis ihmplateau;

    public Controleur() {
        ihm = new Accueil();
        ihm.addObserver(this);
        ihm.afficher();

        ihmnbJoueurs = new IHMNbJoueurs();
        ihmnbJoueurs.addObserver(this);
    }

    public void inscrireJoueur(Joueur j) {
        p.getJoueurs().add(j);
    }

    public Joueur getJoueurCourant() {
        return this.joueurCourant;
    }

    public void joueurSuivant() {
        int i = 0;
        boolean trouve = false;
        for (Joueur j : p.getJoueurs()) {
            i += 1;
            if (joueurCourant == j && p.getJoueurs().size() == (i) && trouve == false) {
                joueurCourant = p.getJoueurs().get(0);
                trouve = true;
            } else if (joueurCourant == j && trouve == false) {
                joueurCourant = p.getJoueurs().get(i);
                trouve = true;
            }
        }
    }

//    public void initPartie() {
//
//        plateau.add(new CaseNeutre(1));
//        plateau.add(new Terrain(Couleur.MAUVE, 2, "Boulevard de Belleville", 60, 2));
//        plateau.add(new CaseNeutre(3));
//        plateau.add(new Terrain(Couleur.MAUVE, 4, "Rue Lecourbe", 60, 4));
//        plateau.add(new CaseNeutre(5));
//        plateau.add(new Gare("Gare Montparnasse", 200, 6));
//        plateau.add(new Terrain(Couleur.BLEU_CIEL, 6, "Rue de Vaugirard", 100, 7));
//        plateau.add(new CaseNeutre(8));
//        plateau.add(new Terrain(Couleur.BLEU_CIEL, 6, "Rue de Courcelles", 100, 9));
//        plateau.add(new Terrain(Couleur.BLEU_CIEL, 8, "Avenue de la République", 120, 10));
//        plateau.add(new CaseNeutre(11));
//        plateau.add(new Terrain(Couleur.VIOLET, 10, "Boulevard de la Villette", 140, 12));
//        plateau.add(new Compagnie("Compagnie de distribution d'éléctricité", 150, 13));
//        plateau.add(new Terrain(Couleur.VIOLET, 10, "Avenue de Neuilly", 140, 14));
//        plateau.add(new Terrain(Couleur.VIOLET, 12, "Rue de Paradis", 160, 15));
//        plateau.add(new Gare("Gare de Lyon", 200, 16));
//        plateau.add(new Terrain(Couleur.ORANGE, 14, "Avenue Mozart", 180, 17));
//        plateau.add(new CaseNeutre(18));
//        plateau.add(new Terrain(Couleur.ORANGE, 14, "Boulevard Saint-Michel", 180, 19));
//        plateau.add(new Terrain(Couleur.ORANGE, 16, "Place Pigalle", 200, 20));
//        plateau.add(new CaseNeutre(21));
//        plateau.add(new Terrain(Couleur.ROUGE, 18, "Avenue Matignon", 220, 22));
//        plateau.add(new CaseNeutre(23));
//        plateau.add(new Terrain(Couleur.ROUGE, 18, "Boulevard Malesherbes", 220, 24));
//        plateau.add(new Terrain(Couleur.ROUGE, 20, "Avenue Henri-Martin", 240, 25));
//        plateau.add(new Gare("Gare du Nord", 200, 26));
//        plateau.add(new Terrain(Couleur.JAUNE, 22, "Faubourg Saint-Honoré", 260, 27));
//        plateau.add(new Terrain(Couleur.JAUNE, 22, "Place de la Bourse", 260, 28));
//        plateau.add(new Compagnie("Compagnie de distribution des eaux", 150, 29));
//        plateau.add(new Terrain(Couleur.JAUNE, 24, "Rue La Fayette", 280, 30));
//        plateau.add(new CaseNeutre(31));
//        plateau.add(new Terrain(Couleur.VERT, 26, "Avenue de Breteuil", 300, 32));
//        plateau.add(new Terrain(Couleur.VERT, 26, "Avenue Foch", 300, 33));
//        plateau.add(new CaseNeutre(34));
//        plateau.add(new Terrain(Couleur.VERT, 28, "Boulevard des Capucines", 320, 35));
//        plateau.add(new Gare("Gare Saint-Lazard", 200, 36));
//        plateau.add(new CaseNeutre(37));
//        plateau.add(new Terrain(Couleur.BLEU_FONCE, 35, "Avenue des Champs-Elysées", 350, 38));
//        plateau.add(new CaseNeutre(39));
//        plateau.add(new Terrain(Couleur.BLEU_FONCE, 50, "Rue de la Paix", 400, 40));
//
//        for (Joueur j : joueurs) {
//            j.setCagnotte(1500);
//            j.setPlateau(plateau);
//            j.setPosition(plateau.get(0));
//        }
//
//        this.joueurCourant = joueurs.get(0);
//    }
    public Joueur getGagnant() {
        if (p.getJoueurs().size() == 1) {
            //System.out.println("Félicitations " + joueurs.get(0).getNom() + ", vous êtes le grand vainqueur de cette partie !!!");
            return p.getJoueurs().get(0);
        } else {
            return null;
        }
    }

    public void verifCagnotte() {
        if (joueurCourant.getCagnotte() < 1) {
            //System.out.println(joueurCourant.getNom() + ", vous avez fait faillite ! Vous êtes éliminé ! ");
            joueurCourant.retirerProprietes();
            p.getJoueurs().remove(joueurCourant);
            joueurSuivant();
        }
    }

    public boolean achatPossible() {
        boolean achatPossible = false;
        for (Action a : joueurCourant.getPosition().getActionPossible(joueurCourant)) {
            if (a == Action.PAYER) {
                joueurCourant.getPosition().lancerAction(Action.PAYER, joueurCourant);
                verifCagnotte();
            } else if (a == Action.ACHETER) {
                achatPossible = true;
            }
        }
        return achatPossible;
    }

    public void demarrerPartie() {
        while (getGagnant() == null) {
            joueurCourant.getPosition().lancerAction(Action.DEPLACER, joueurCourant);
            achatPossible();
            while (joueurCourant.verifDouble()) {

            }
        }
    }

    public void partieDemo() {

        while (getGagnant() == null) {
            System.out.println(joueurCourant.getNom() + " à vous de jouer ... ");
            joueurCourant.getPosition().lancerAction(Action.DEPLACER, joueurCourant);
            int de1 = joueurCourant.getDe1();
            int de2 = joueurCourant.getDe2();
            int x = de1 + de2;
            System.out.println("1er Dé : " + de1 + "  |  2e Dé : " + de2);
            System.out.println("1er dé : " + de1 + " ;  2e dé : " + de2);
            System.out.println("Vous vous êtes déplacé de " + x + " cases");
            System.out.print("Vous êtes maintenant sur " + joueurCourant.getPosition().getNom());
            boolean relancer = false;
            if (joueurCourant.verifDouble()) {
                System.out.print("\nVous avez effectué un double, il faudra relancer les dés");
                relancer = true;
            }

            boolean achatPossible = false;
            System.out.println(joueurCourant.getCagnotte());
            for (Action a : joueurCourant.getPosition().getActionPossible(joueurCourant)) {
                if (a == Action.PAYER) {
                    joueurCourant.getPosition().lancerAction(Action.PAYER, joueurCourant);
                    //System.out.print(", propriété de " + joueurCourant.getPosition().getProprietaire().getNom() + " !");
                    //System.out.println(joueurCourant.getPosition().getLoyer(joueurCourant) + "€ ont été retirés de votre cagnotte !  Il vous reste " + joueurCourant.getCagnotte() + "€");
                    verifCagnotte();
                } else if (a == Action.ACHETER) {
                    System.out.println("Achat possible");
                    achatPossible = true;
                }
            }

            System.out.println("\nSaisissez le numéro d'action que vous souhaitez effectuer : ");
            if (relancer) {
                System.out.println("    1. RELANCER");
            } else {
                System.out.println("    1. FIN DU TOUR");
            }
            System.out.println("    2. CONSULTER PROPRIETES");
            System.out.println("    3. CONSULTER CAGNOTTE");
            if (achatPossible) {
                System.out.println("    4. ACHETER");
            }
            int numAct = 0;
            while (numAct != 1) {
                Scanner sc = new Scanner(System.in);
                numAct = sc.nextInt();
                if (numAct == 1 && !relancer) {
                    joueurSuivant();
                } else if (numAct == 1 && relancer) {

                } else if (numAct == 2) {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Voici les propriétés en votre possession : ");
                    for (Propriete p : joueurCourant.getProprietes()) {
                        System.out.println("    - " + p.getNom());
                    }
                    System.out.println("--------------------------------------------------------");
                    if (relancer) {
                        System.out.println("    1. RELANCER");
                    } else {
                        System.out.println("    1. FIN DU TOUR");
                    }
                    System.out.println("    2. CONSULTER PROPRIETES");
                    System.out.println("    3. CONSULTER CAGNOTTE");
                    if (achatPossible) {
                        System.out.println("    4. ACHETER");
                    }
                } else if (numAct == 3) {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Il reste " + joueurCourant.getCagnotte() + "€ sur votre cagnotte");
                    System.out.println("--------------------------------------------------------");
                    if (relancer) {
                        System.out.println("    1. RELANCER");
                    } else {
                        System.out.println("    1. FIN DU TOUR");
                    }
                    System.out.println("    2. CONSULTER PROPRIETES");
                    System.out.println("    3. CONSULTER CAGNOTTE");
                    if (achatPossible) {
                        System.out.println("    4. ACHETER");
                    }
                } else if (numAct == 4 && achatPossible) {
                    joueurCourant.getPosition().lancerAction(Action.ACHETER, joueurCourant);
                    System.out.println(joueurCourant.getNom() + ", vous possédez désormais " + joueurCourant.getPosition().getNom());
                    System.out.println("Il reste " + joueurCourant.getCagnotte() + "€ sur votre cagnotte");
                    System.out.println("Saisissez le numéro d'action que vous souhaitez effectuer : ");
                    if (relancer) {
                        System.out.println("    1. RELANCER");
                    } else {
                        System.out.println("    1. FIN DU TOUR");
                    }
                    System.out.println("    2. CONSULTER PROPRIETES");
                    System.out.println("    3. CONSULTER CAGNOTTE");
                    achatPossible = false;
                } else {
                    System.out.println("Veuillez re-saisir le numéro d'action souhaité : ");
                }
            }
            System.out.println("\n=============================================================");
            System.out.println("=============================================================\n");
        }
        getGagnant();
    }

    public ArrayList<Joueur> getJoueurs() {
        return p.getJoueurs();
    }

//    public void setJoueurs(ArrayList<Joueur> joueurs) {
//        this.joueurs = joueurs;
//    }
    @Override
    public void update(Observable arg0, Object arg1) {
        Message m = (Message) arg1;

        if (m.getType() == TypeMessages.JOUER_PARTIE) {
            ihm.close();
            ihmnbJoueurs.afficher();

        } else if (m.getType() == TypeMessages.REGLES) {
            ihm.close();
            ihmregles = new IHMRegles();
            // ouvrir ihm des règles
        } else if (m.getType() == TypeMessages.RETOUR) {
            ihmInsc.close();
            ihmnbJoueurs.afficher();

        } else if (m.getType() == TypeMessages.COMMENCER) {
            ihmInsc.close();
            ihmplateau = new PlateauBis(ihmInsc.getJoueurs1().get(0));
            ihmplateau.addObserver(this);
            ihmplateau.afficher();
            for (int i = 0; i < p.getJoueurs().size(); i++) {
                p.getJoueurs().get(i).setNumCaseCourante(1);
            }

            //ouvrir ihm de jeu
        } else if (m.getType() == TypeMessages.NBJOUEUR) {
            ihmInsc = new Inscription(m.getNbJoueurs());
            ihmInsc.addObserver(this);
            ihmInsc.afficher();
            ihmnbJoueurs.close();

        } else if (m.getType() == TypeMessages.FINDETOUR) {
            joueurSuivant();
            System.out.println(joueurCourant.getNom());
            
        } else if (m.getType() == TypeMessages.LANCERDES) {
            joueurCourant.lancerDes();
            joueurCourant.setNumCaseCourante(joueurCourant.getNumCaseCourante() + joueurCourant.getDe1() + joueurCourant.getDe2());

        } else if (m.getType() == TypeMessages.ACHETER) {
            CasePlateau prop = p.getCasesPlat().get(joueurCourant.getNumCaseCourante());
            joueurCourant.addProriete((Propriete) p.getCasesPlat().get(joueurCourant.getNumCaseCourante()));
            joueurCourant.setCagnotte(joueurCourant.getCagnotte() - ((Propriete) prop).getPrixDAchat());
            
        } else if (m.getType() == TypeMessages.CONSTRUIRE) {
            CasePlateau prop = p.getCasesPlat().get(joueurCourant.getNumCaseCourante());
            if (((Terrain) prop).getNbMaison() < 4) {
                ((Terrain) prop).setNbMaison(((Terrain) prop).getNbMaison() + 1);
                joueurCourant.setCagnotte(joueurCourant.getCagnotte() - ((Terrain) prop).getConstruMaisonHotel());
            } else if (((Terrain) prop).getNbMaison() == 4 && ((Terrain) prop).getNbHotel() == 0) {
                ((Terrain) prop).setNbHotel(1);
                joueurCourant.setCagnotte(joueurCourant.getCagnotte() - ((Terrain) prop).getConstruMaisonHotel());
            }
        }

    }

    public void ajout() {
        for (Joueur j : ihmInsc.getJoueurs1()) {
            p.getJoueurs().add(j);
        }

    }

//    public static void main(String[] args) {
//        ihmplateau.afficher();
//    }
}
