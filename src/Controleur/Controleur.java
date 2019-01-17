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
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.tools.jstat.Alignment;

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
    private boolean relancer;
    private HashMap<Joueur, JLabel> pions = new HashMap<Joueur, JLabel>();

    public Controleur() {
        ihm = new Accueil();
        ihm.addObserver(this);
        ihm.afficher();

        ihmnbJoueurs = new IHMNbJoueurs();
        ihmnbJoueurs.addObserver(this);
    }

//    public boolean achatPossible() {
//        boolean achatPossible = false;
//        for (Action a : joueurCourant.getPosition().getActionPossible(joueurCourant)) {
//            if (a == Action.PAYER) {
//                joueurCourant.getPosition().lancerAction(Action.PAYER, joueurCourant);
//                verifCagnotte();
//            } else if (a == Action.ACHETER) {
//                achatPossible = true;
//            }
//        }
//        return achatPossible;
//    }
//
//    public void demarrerPartie() {
//        while (getGagnant() == null) {
//            joueurCourant.getPosition().lancerAction(Action.DEPLACER, joueurCourant);
//            achatPossible();
//            while (joueurCourant.verifDouble()) {
//
//            }
//        }
//    }
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
            ihmregles.addObserver(this);
            ihmregles.afficher();
        } else if (m.getType() == TypeMessages.RETOUR) {
            ihmInsc.close();
            ihmnbJoueurs.afficher();

        } else if (m.getType() == TypeMessages.COMMENCER) {
            ihmInsc.close();
            p = new Plateau();
            for (Joueur j : ihmInsc.getJoueurs1()) {
                inscrireJoueur(j);
            }
            joueurCourant = p.getJoueurs().get(0);
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
            ihmplateau.setLabelJoueurCourant(joueurCourant.getNom());
            ihmplateau.setLabelCagnotte(joueurCourant.getCagnotte());
            verifAction();
            ihmplateau.getBtnLancerDès().setEnabled(true);

        } else if (m.getType() == TypeMessages.LANCERDES) {
            joueurCourant.lancerDes();
            joueurCourant.setNumCaseCourante(joueurCourant.getNumCaseCourante() + joueurCourant.getDe1() + joueurCourant.getDe2());
            System.out.println(joueurCourant.getDe1());
            System.out.println(joueurCourant.getDe2());

            if (joueurCourant.verifDouble()) {
                ihmplateau.getBtnLancerDès().setEnabled(true);
            } else {
                ihmplateau.getBtnLancerDès().setEnabled(false);
            }
            JLabel lepion = getPion(joueurCourant);
            int nc = joueurCourant.getNumCaseCourante();
            ihmplateau.getCase(nc).addPion(lepion);
            System.out.println(ihmplateau.getCase(joueurCourant.getNumCaseCourante()));

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
        } else if (m.getType() == TypeMessages.FERMER_REGLES) {
            ihmregles.close();
            ihm.afficher();
        } else if (m.getType() == TypeMessages.RETOUR) {
            ihmInsc.close();
            ihmnbJoueurs.afficher();

        }
    }

    public void verifAction() {
        CasePlateau prop = p.getCasesPlat().get(joueurCourant.getNumCaseCourante());
        if (prop instanceof Propriete) {
            if (joueurCourant.getCagnotte() < ((Propriete) prop).getPrixDAchat()) {
                ihmplateau.getBtnAcheterTerrain().setEnabled(false);
            }
        }
        if (prop instanceof Terrain) {
            if (joueurCourant.getCagnotte() < ((Terrain) prop).getConstruMaisonHotel() && ((Terrain) prop).getNbHotel() == 1) {
                ihmplateau.getBtnConstruire().setEnabled(false);
            }
        }
        // joueurCourant.getPosition().

//        while (getGagnant() == null) {
//            int de1 = joueurCourant.getDe1();
//            int de2 = joueurCourant.getDe2();
//            int x = de1 + de2;
//            System.out.println("1er Dé : " + de1 + "  |  2e Dé : " + de2);
//            System.out.println("1er dé : " + de1 + " ;  2e dé : " + de2);
//            System.out.println("Vous vous êtes déplacé de " + x + " cases");
//            System.out.print("Vous êtes maintenant sur " + joueurCourant.getPosition().getNom());
//            boolean relancer = false;
//            if (joueurCourant.verifDouble()) {
//                System.out.print("\nVous avez effectué un double, il faudra relancer les dés");
//                relancer = true;
//            }
//
//            boolean achatPossible = false;
//            System.out.println(joueurCourant.getCagnotte());
//            for (Action a : joueurCourant.getPosition().getActionPossible(joueurCourant)) {
//                if (a == Action.PAYER) {
//                    joueurCourant.getPosition().lancerAction(Action.PAYER, joueurCourant);
//                    //System.out.print(", propriété de " + joueurCourant.getPosition().getProprietaire().getNom() + " !");
//                    //System.out.println(joueurCourant.getPosition().getLoyer(joueurCourant) + "€ ont été retirés de votre cagnotte !  Il vous reste " + joueurCourant.getCagnotte() + "€");
//                    verifCagnotte();
//                } else if (a == Action.ACHETER) {
//                    System.out.println("Achat possible");
//                    achatPossible = true;
//                }
//            }
//
//            System.out.println("\nSaisissez le numéro d'action que vous souhaitez effectuer : ");
//            if (relancer) {
//                System.out.println("    1. RELANCER");
//            } else {
//                System.out.println("    1. FIN DU TOUR");
//            }
//            System.out.println("    2. CONSULTER PROPRIETES");
//            System.out.println("    3. CONSULTER CAGNOTTE");
//            if (achatPossible) {
//                System.out.println("    4. ACHETER");
//            }
//            int numAct = 0;
//            while (numAct != 1) {
//                Scanner sc = new Scanner(System.in);
//                numAct = sc.nextInt();
//                if (numAct == 1 && !relancer) {
//                    joueurSuivant();
//                } else if (numAct == 1 && relancer) {
//
//                } else if (numAct == 2) {
//                    System.out.println("--------------------------------------------------------");
//                    System.out.println("Voici les propriétés en votre possession : ");
//                    for (Propriete p : joueurCourant.getProprietes()) {
//                        System.out.println("    - " + p.getNom());
//                    }
//                    System.out.println("--------------------------------------------------------");
//                    if (relancer) {
//                        System.out.println("    1. RELANCER");
//                    } else {
//                        System.out.println("    1. FIN DU TOUR");
//                    }
//                    System.out.println("    2. CONSULTER PROPRIETES");
//                    System.out.println("    3. CONSULTER CAGNOTTE");
//                    if (achatPossible) {
//                        System.out.println("    4. ACHETER");
//                    }
//                } else if (numAct == 3) {
//                    System.out.println("--------------------------------------------------------");
//                    System.out.println("Il reste " + joueurCourant.getCagnotte() + "€ sur votre cagnotte");
//                    System.out.println("--------------------------------------------------------");
//                    if (relancer) {
//                        System.out.println("    1. RELANCER");
//                    } else {
//                        System.out.println("    1. FIN DU TOUR");
//                    }
//                    System.out.println("    2. CONSULTER PROPRIETES");
//                    System.out.println("    3. CONSULTER CAGNOTTE");
//                    if (achatPossible) {
//                        System.out.println("    4. ACHETER");
//                    }
//                } else if (numAct == 4 && achatPossible) {
//                    joueurCourant.getPosition().lancerAction(Action.ACHETER, joueurCourant);
//                    System.out.println(joueurCourant.getNom() + ", vous possédez désormais " + joueurCourant.getPosition().getNom());
//                    System.out.println("Il reste " + joueurCourant.getCagnotte() + "€ sur votre cagnotte");
//                    System.out.println("Saisissez le numéro d'action que vous souhaitez effectuer : ");
//                    if (relancer) {
//                        System.out.println("    1. RELANCER");
//                    } else {
//                        System.out.println("    1. FIN DU TOUR");
//                    }
//                    System.out.println("    2. CONSULTER PROPRIETES");
//                    System.out.println("    3. CONSULTER CAGNOTTE");
//                    achatPossible = false;
//                } else {
//                    System.out.println("Veuillez re-saisir le numéro d'action souhaité : ");
//                }
//            }
//            System.out.println("\n=============================================================");
//            System.out.println("=============================================================\n");
//        }
//        getGagnant();
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

    public void couleur() {
        for (Joueur j : ihmInsc.getJoueurs().keySet()) {
            Color c = ihmInsc.getJoueurs().get(j);
            JLabel l = new JLabel(" r ");
            l.setSize(10, 10);
            l.setBackground(c);
            l.setOpaque(true);
            pions.put(j, l);
        }
    }

    public JLabel getPion(Joueur joueur) {
        JLabel l = new JLabel();
        for (Joueur j : pions.keySet()) {
            if (joueur == j) {
                l = pions.get(j);
            }

        }
        return l;
    }

}
