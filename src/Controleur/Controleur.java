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
import IHM.PionPanel;
import IHM.PlateauBis;
import Message.Message;
import Message.TypeMessages;
import Modèle.Action;
import Modèle.CaseAllerEnPrison;
import Modèle.CaseDépart;
import Modèle.CasePlateau;
import Modèle.CasePrison;
import Modèle.CasesCommunautaires_CartesChance;
import Modèle.Compagnie;
import Modèle.Couleur;
import Modèle.Gare;
import Modèle.ImpotsTaxe;
import Modèle.Joueur;
import Modèle.ParcGratuit;
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
    private HashMap<Joueur, PionPanel> pions;

    public Controleur() {
        ihm = new Accueil();
        ihm.addObserver(this);
        ihm.afficher();

        ihmnbJoueurs = new IHMNbJoueurs();
        ihmnbJoueurs.addObserver(this);

        pions = new HashMap<Joueur, PionPanel>();
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
                p.getJoueurs().get(i).setPosition(1);
            }
            assossiationDesPions();
            ihmplateau.getBtnFinTour().setEnabled(false);
            ihmplateau.getBtnConstruire().setEnabled(false);
            ihmplateau.getBtnAcheterTerrain().setEnabled(false);
            ihmplateau.setLabelPosition(p.getNomCase(joueurCourant.getPosition()));

            //ouvrir ihm de jeu
        } else if (m.getType() == TypeMessages.NBJOUEUR) {
            ihmInsc = new Inscription(m.getNbJoueurs());
            ihmInsc.addObserver(this);
            ihmInsc.afficher();
            ihmnbJoueurs.close();

        } else if (m.getType() == TypeMessages.FINDETOUR) {
            joueurSuivant();
            ihmplateau.setLabelPosition(p.getNomCase(joueurCourant.getPosition()));
            System.out.println(p.getNomCase(joueurCourant.getPosition()));
            ihmplateau.setLabelJoueurCourant(joueurCourant.getNom());
            ihmplateau.setLabelCagnotte(joueurCourant.getCagnotte());
            ihmplateau.getBtnLancerDès().setEnabled(true);
            ihmplateau.getBtnFinTour().setEnabled(false);

        } else if (m.getType() == TypeMessages.LANCERDES) {
            joueurCourant.lancerDes();
            ihmplateau.setLabelsDes(joueurCourant.getDe1(), joueurCourant.getDe2());
            joueurCourant.setPosition(joueurCourant.getPosition() + joueurCourant.getDe1() + joueurCourant.getDe2());
            if (joueurCourant.verifDouble()) {
                ihmplateau.getBtnLancerDès().setEnabled(true);
                ihmplateau.getBtnFinTour().setEnabled(false);
            } else {
                ihmplateau.getBtnLancerDès().setEnabled(false);
                ihmplateau.getBtnFinTour().setEnabled(true);
            }
            //ACHETER ou PAYER
            for (CasePlateau cp : p.getCasesPlat()) {
                if (cp.getNumCase() == joueurCourant.getPosition()) {
                    if (cp instanceof Propriete) {
                        if (((Propriete) cp).getProprietaire() != null) {
                            ihmplateau.getBtnAcheterTerrain().setEnabled(true);
                        } else {
                            joueurCourant.payerJoueur(((Propriete) cp).getLoyer(), ((Propriete) cp).getProprietaire());
                            ihmplateau.setLabelCagnotte(joueurCourant.getCagnotte());
                        }
                    }

                }

            }

            //bougerPion(joueurCourant);
            ihmplateau.setLabelPosition(p.getNomCase(joueurCourant.getPosition()));
            //System.out.println(ihmplateau.getCase(joueurCourant.getNumCaseCourante()));

        } else if (m.getType() == TypeMessages.ACHETER) {
            CasePlateau prop = p.getCasesPlat().get(joueurCourant.getPosition());
            joueurCourant.addProriete((Propriete) p.getCasesPlat().get(joueurCourant.getPosition()));
            joueurCourant.setCagnotte(joueurCourant.getCagnotte() - ((Propriete) prop).getPrixDAchat());

        } else if (m.getType() == TypeMessages.CONSTRUIRE) {
            CasePlateau prop = p.getCasesPlat().get(joueurCourant.getPosition());
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

    public void inscrireJoueur(Joueur j) {
        p.getJoueurs().add(j);
        j.setPlateau(p);
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

    public void assossiationDesPions() {
        for (Joueur j : ihmInsc.getJoueurs().keySet()) {
            Color c = ihmInsc.getJoueurs().get(j);
            PionPanel pion = new PionPanel(c);
            pions.put(j, pion);
        }
    }

    public PionPanel getPion(Joueur joueur) {
        return pions.get(joueur);
    }

//    public void bougerPion(Joueur j) {
//        
//        PionPanel lepion = getPion(joueurCourant);
//        int nc = joueurCourant.getNumCaseCourante();
//        System.out.println( joueurCourant.getNom() + "YEP : " + pions.get(joueurCourant));
//        System.out.println("Test case ihm : " + ihmplateau.getCase(nc).getName());
//        ihmplateau.getCase(nc).addPion(lepion);
//        //ihmplateau.verifCases();
//
//    }
}
