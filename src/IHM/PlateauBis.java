/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Message.Message;
import Message.TypeMessages;
import static Message.TypeMessages.FINDETOUR;
import Modèle.CaseAllerEnPrison;
import Modèle.CaseDépart;
import Modèle.CasePlateau;
import Modèle.CasePrison;
import Modèle.CasesCommunautaires_CartesChance;
import Modèle.Compagnie;
import Modèle.Gare;
import Modèle.ImpotsTaxe;
import Modèle.Joueur;
import Modèle.ParcGratuit;
import Modèle.Plateau;
import Modèle.Propriete;
import Modèle.Terrain;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author yamin
 */
public class PlateauBis extends Observable {

    private Plateau plateau;
    private JFrame window;
    private JPanel mainPanel, panelGrille, panelCommande, panelPions, panelMaisons, panelDroite, panelNord;
    private JLabel labelJoueurCourant = new JLabel(""), labelCagnotte = new JLabel(""), labelPosition, labelDe1, labelDe2;
    private JButton btnLancerDès = new JButton("Lancer les dés"), btnAcheterTerrain = new JButton("Acheter"), btnConstruire = new JButton("Construire"), btnFinTour = new JButton("Fin de tour"), btnAbandonner = new JButton("Abandonner");
    private HashMap<Integer, ImagePanel> casesPlateau = new HashMap<Integer, ImagePanel>();
    private Joueur joueurCourant;

    public PlateauBis(Joueur joueur) {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(1100, 700);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 191, 128));
        mainPanel.setOpaque(true);

//        panelNord = new JPanel(new BorderLayout());
//        JLabel labelTitre = new JLabel("MONOPOLY", SwingConstants.CENTER);
//        labelTitre.setFont(new Font("Arial", Font.BOLD, 50));
//        labelTitre.setForeground(Color.BLACK);
//        labelTitre.setBackground(new Color(255, 191, 128));
//        labelTitre.setOpaque(true);
//        panelNord.add(labelTitre);
//        mainPanel.add(panelNord, BorderLayout.NORTH);
        panelGrille = new JPanel(new GridBagLayout());
        panelGrille.setBackground(new Color(255, 191, 128));
        panelGrille.setOpaque(true);

        panelCommande = new JPanel(new GridLayout(16, 3));
        panelCommande.setBackground(new Color(255, 191, 128));
        panelCommande.setOpaque(true);

        mainPanel.add(panelGrille, BorderLayout.CENTER);
        mainPanel.add(panelCommande, BorderLayout.EAST);
        window.add(mainPanel);

        this.joueurCourant = joueur;

        // Boutons à droite //
        for (int i = 1; i < 48; i++) {
            if (i == 5) {
                this.setLabelJoueurCourant(joueurCourant.getNom());
                labelJoueurCourant.setFont(new Font("Arial", Font.BOLD, 20));
                panelCommande.add(labelJoueurCourant);

            } else if (i == 8) {
                this.setLabelCagnotte(joueurCourant.getCagnotte());
                labelCagnotte.setFont(new Font("Arial", Font.BOLD, 20));
                panelCommande.add(labelCagnotte);
            } else if (i == 14) {
                panelCommande.add(btnLancerDès);
                btnLancerDès.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.LANCERDES));
                        clearChanged();
                    }
                });
            } else if (i == 20) {
                panelCommande.add(btnAcheterTerrain);
                btnAcheterTerrain.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.ACHETER));
                        clearChanged();
                    }
                });
            } else if (i == 26) {
                panelCommande.add(btnConstruire);
                btnConstruire.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.CONSTRUIRE));
                        clearChanged();

                    }
                });
            } else if (i == 32) {
                panelCommande.add(btnFinTour);
                btnFinTour.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.FINDETOUR));
                        clearChanged();
                        btnLancerDès.setEnabled(true);

                    }
                });
            } else if (i == 38) {
                panelCommande.add(btnAbandonner);
                btnAbandonner.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }
                });
            } else {
                panelCommande.add(new JLabel(""));
            }

        }

        // ======= Les Cases du plateau ========
        //Partie Haut :
        ImageIcon iParcGratuit = new ImageIcon(System.getProperty("user.dir") + "/src/image/ParcGratuit.png");
        ImageIcon iAvenueMatignon = new ImageIcon(System.getProperty("user.dir") + "/src/image/AvenueMatignon.png");
        ImageIcon iChance2 = new ImageIcon(System.getProperty("user.dir") + "/src/image/Chance2.png");
        ImageIcon iBoulevardMalherbes = new ImageIcon(System.getProperty("user.dir") + "/src/image/BoulevardMalherbes.png");
        ImageIcon iAvenueHenriMartin = new ImageIcon(System.getProperty("user.dir") + "/src/image/AvenueHenri-Martin.png");
        ImageIcon iGareDuNord = new ImageIcon(System.getProperty("user.dir") + "/src/image/GareDuNord.png");
        ImageIcon iFaubourgSaintHonore = new ImageIcon(System.getProperty("user.dir") + "/src/image/FaubourgSaint-Honore.png");
        ImageIcon iPlaceDeLaBourse = new ImageIcon(System.getProperty("user.dir") + "/src/image/PlaceDeLaBourse.png");
        ImageIcon iCompagnieEaux = new ImageIcon(System.getProperty("user.dir") + "/src/image/CompagnieEaux.png");
        ImageIcon iRueLaFayette = new ImageIcon(System.getProperty("user.dir") + "/src/image/RueLaFayette.png");
        ImageIcon iAllezEnPrison = new ImageIcon(System.getProperty("user.dir") + "/src/image/AllezEnPrison.png");
        //Partie Gauche :
        ImageIcon iPlacePigalle = new ImageIcon(System.getProperty("user.dir") + "/src/image/PlacePigalle.png");
        ImageIcon iBoulevardStMichel = new ImageIcon(System.getProperty("user.dir") + "/src/image/BoulevardSaint-Michel.png");
        ImageIcon iCaisseCommu2 = new ImageIcon(System.getProperty("user.dir") + "/src/image/CaisseCommu2.png");
        ImageIcon iAvenueMozart = new ImageIcon(System.getProperty("user.dir") + "/src/image/AvenueMozart.png");
        ImageIcon iGareDeLyon = new ImageIcon(System.getProperty("user.dir") + "/src/image/GareDeLyon.png");
        ImageIcon iRueDeParadis = new ImageIcon(System.getProperty("user.dir") + "/src/image/RueDeParadis.png");
        ImageIcon iAvenueDeNeuilly = new ImageIcon(System.getProperty("user.dir") + "/src/image/AvenueDeNeuilly.png");
        ImageIcon iCompagnieElec = new ImageIcon(System.getProperty("user.dir") + "/src/image/CompagnieElec.png");
        ImageIcon iBoulevardDeLaVillette = new ImageIcon(System.getProperty("user.dir") + "/src/image/BoulevardDeLaVillette.png");
        ImageIcon iVisitePrison = new ImageIcon(System.getProperty("user.dir") + "/src/image/Visite-Prison.png");
        //Partie Bas :
        ImageIcon iAvenueDeLaRepublique = new ImageIcon(System.getProperty("user.dir") + "/src/image/AvenueDeLaRepublique.png");
        ImageIcon iRueDeCourcelles = new ImageIcon(System.getProperty("user.dir") + "/src/image/RueDeCourcelles.png");
        ImageIcon iChance1 = new ImageIcon(System.getProperty("user.dir") + "/src/image/Chance1.png");
        ImageIcon iRueDeVaugirard = new ImageIcon(System.getProperty("user.dir") + "/src/image/RueDeVaugirard.png");
        ImageIcon iGareMontparnasse = new ImageIcon(System.getProperty("user.dir") + "/src/image/GareMontparnasse.png");
        ImageIcon iImpotSurLeRevenu = new ImageIcon(System.getProperty("user.dir") + "/src/image/ImpotSurLeRevenu.png");
        ImageIcon iRueLecourbe = new ImageIcon(System.getProperty("user.dir") + "/src/image/RueLecourbe.png");
        ImageIcon iCaisseCommu1 = new ImageIcon(System.getProperty("user.dir") + "/src/image/CaisseCommu1.png");
        ImageIcon iBoulevardDeBelleville = new ImageIcon(System.getProperty("user.dir") + "/src/image/BoulevardDeBelleville.png");
        ImageIcon iCaseDepart = new ImageIcon(System.getProperty("user.dir") + "/src/image/CaseDepart.png");
        //Partie Gauche :
        ImageIcon iRueDeLaPaix = new ImageIcon(System.getProperty("user.dir") + "/src/image/RueDeLaPaix.png");
        ImageIcon iTaxeDeLuxe = new ImageIcon(System.getProperty("user.dir") + "/src/image/TaxeDeLuxe.png");
        ImageIcon iAvenueDesChampsElysees = new ImageIcon(System.getProperty("user.dir") + "/src/image/AvenueDesChampsElysees.png");
        ImageIcon iChance3 = new ImageIcon(System.getProperty("user.dir") + "/src/image/Chance3.png");
        ImageIcon iGareStLazare = new ImageIcon(System.getProperty("user.dir") + "/src/image/GareSaint-Lazare.png");
        ImageIcon iBoulevardDesCapucines = new ImageIcon(System.getProperty("user.dir") + "/src/image/BoulevardDesCapucines.png");
        ImageIcon iCaisseCommu3 = new ImageIcon(System.getProperty("user.dir") + "/src/image/CaisseCommu3.png");
        ImageIcon iAvenueFoch = new ImageIcon(System.getProperty("user.dir") + "/src/image/AvenueFoch.png");
        ImageIcon iAvenueDeBreteuil = new ImageIcon(System.getProperty("user.dir") + "/src/image/AvenueDeBreteuil.png");

        GridBagConstraints gbc = new GridBagConstraints();

        //PARC GRATUIT
        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipParcGratuit = new ImagePanel(iParcGratuit, PositionCase_enum.NORTH, false);
        ipParcGratuit.setPreferredSize(new Dimension(iParcGratuit.getIconWidth(), iParcGratuit.getIconHeight()));
        casesPlateau.put(21, ipParcGratuit);
        panelGrille.add(ipParcGratuit, gbc);

        //Avenue Matignon
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipAvenueMatigon = new ImagePanel(iAvenueMatignon, PositionCase_enum.NORTH, true);
        casesPlateau.put(22, ipAvenueMatigon);
        ipAvenueMatigon.setPreferredSize(new Dimension(iAvenueMatignon.getIconWidth(), iAvenueMatignon.getIconHeight()));
        panelGrille.add(ipAvenueMatigon, gbc);

        //Chance 2
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipChance2 = new ImagePanel(iChance2, PositionCase_enum.NORTH, false);
        casesPlateau.put(23, ipChance2);
        ipChance2.setPreferredSize(new Dimension(iChance2.getIconWidth(), iChance2.getIconHeight()));
        panelGrille.add(ipChance2, gbc);

        //Boulevard Malherbes
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipBoulevardMalherbes = new ImagePanel(iBoulevardMalherbes, PositionCase_enum.NORTH, true);
        casesPlateau.put(24, ipBoulevardMalherbes);
        ipBoulevardMalherbes.setPreferredSize(new Dimension(iBoulevardMalherbes.getIconWidth(), iBoulevardMalherbes.getIconHeight()));
        panelGrille.add(ipBoulevardMalherbes, gbc);

        //Avenue Henri-Martin
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipAvenueHenriMartin = new ImagePanel(iAvenueHenriMartin, PositionCase_enum.NORTH, true);
        casesPlateau.put(25, ipAvenueHenriMartin);
        ipAvenueHenriMartin.setPreferredSize(new Dimension(iAvenueHenriMartin.getIconWidth(), iAvenueHenriMartin.getIconHeight()));
        panelGrille.add(ipAvenueHenriMartin, gbc);

        //Gare du Nord
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipGareDuNord = new ImagePanel(iGareDuNord, PositionCase_enum.NORTH, false);
        casesPlateau.put(26, ipGareDuNord);
        ipGareDuNord.setPreferredSize(new Dimension(iGareDuNord.getIconWidth(), iGareDuNord.getIconHeight()));
        panelGrille.add(ipGareDuNord, gbc);

        //Faubourg Saint-Honoré
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipFaubourgSaintHonore = new ImagePanel(iFaubourgSaintHonore, PositionCase_enum.NORTH, true);
        casesPlateau.put(27, ipFaubourgSaintHonore);
        ipFaubourgSaintHonore.setPreferredSize(new Dimension(iFaubourgSaintHonore.getIconWidth(), iFaubourgSaintHonore.getIconHeight()));
        panelGrille.add(ipFaubourgSaintHonore, gbc);

        //Place De La Bourse
        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipPlaceDeLaBourse = new ImagePanel(iPlaceDeLaBourse, PositionCase_enum.NORTH, true);
        casesPlateau.put(28, ipPlaceDeLaBourse);
        ipPlaceDeLaBourse.setPreferredSize(new Dimension(iPlaceDeLaBourse.getIconWidth(), iPlaceDeLaBourse.getIconHeight()));
        panelGrille.add(ipPlaceDeLaBourse, gbc);

        //Compagnie des Eaux
        gbc.gridx = 8;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipCompagnieEaux = new ImagePanel(iCompagnieEaux, PositionCase_enum.NORTH, false);
        casesPlateau.put(29, ipCompagnieEaux);
        ipCompagnieEaux.setPreferredSize(new Dimension(iCompagnieEaux.getIconWidth(), iCompagnieEaux.getIconHeight()));
        panelGrille.add(ipCompagnieEaux, gbc);

        //Rue La Fayette
        gbc.gridx = 9;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipRueLaFayette = new ImagePanel(iRueLaFayette, PositionCase_enum.NORTH, true);
        casesPlateau.put(30, ipRueLaFayette);
        ipRueLaFayette.setPreferredSize(new Dimension(iRueLaFayette.getIconWidth(), iRueLaFayette.getIconHeight()));
        panelGrille.add(ipRueLaFayette, gbc);

        //ALLEZ EN PRISON
        gbc.gridx = 10;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipAllezEnPrison = new ImagePanel(iAllezEnPrison, PositionCase_enum.NORTH, false);
        casesPlateau.put(31, ipAllezEnPrison);
        ipAllezEnPrison.setPreferredSize(new Dimension(iAllezEnPrison.getIconWidth(), iAllezEnPrison.getIconHeight()));
        panelGrille.add(ipAllezEnPrison, gbc);

        //Place Pigalle
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipPlacePigalle = new ImagePanel(iPlacePigalle, PositionCase_enum.WEST, true);
        casesPlateau.put(20, ipPlacePigalle);
        ipPlacePigalle.setPreferredSize(new Dimension(iPlacePigalle.getIconWidth(), iPlacePigalle.getIconHeight()));
        panelGrille.add(ipPlacePigalle, gbc);

        //Boulevard Saint-Michel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipBoulevardStMichel = new ImagePanel(iBoulevardStMichel, PositionCase_enum.WEST, true);
        casesPlateau.put(19, ipBoulevardStMichel);
        ipBoulevardStMichel.setPreferredSize(new Dimension(iBoulevardStMichel.getIconWidth(), iBoulevardStMichel.getIconHeight()));
        panelGrille.add(ipBoulevardStMichel, gbc);

        //Caisse de Communauté 2
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipCaisseCommu2 = new ImagePanel(iCaisseCommu2, PositionCase_enum.WEST, false);
        casesPlateau.put(18, ipCaisseCommu2);
        ipCaisseCommu2.setPreferredSize(new Dimension(iCaisseCommu2.getIconWidth(), iCaisseCommu2.getIconHeight()));
        panelGrille.add(ipCaisseCommu2, gbc);

        //Avenue Mozart
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipAvenueMozart = new ImagePanel(iAvenueMozart, PositionCase_enum.WEST, true);
        casesPlateau.put(17, ipAvenueMozart);
        ipAvenueMozart.setPreferredSize(new Dimension(iAvenueMozart.getIconWidth(), iAvenueMozart.getIconHeight()));
        panelGrille.add(ipAvenueMozart, gbc);

        //Gare De Lyon
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipGareDeLyon = new ImagePanel(iGareDeLyon, PositionCase_enum.WEST, false);
        casesPlateau.put(16, ipGareDeLyon);
        ipGareDeLyon.setPreferredSize(new Dimension(iGareDeLyon.getIconWidth(), iGareDeLyon.getIconHeight()));
        panelGrille.add(ipGareDeLyon, gbc);

        //Rue De Paradis
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipRueDeParadis = new ImagePanel(iRueDeParadis, PositionCase_enum.WEST, true);
        casesPlateau.put(15, ipRueDeParadis);
        ipRueDeParadis.setPreferredSize(new Dimension(iRueDeParadis.getIconWidth(), iRueDeParadis.getIconHeight()));
        panelGrille.add(ipRueDeParadis, gbc);

        //Avenue De Neuilly
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipAvenueDeNeuilly = new ImagePanel(iAvenueDeNeuilly, PositionCase_enum.WEST, true);
        casesPlateau.put(14, ipAvenueDeNeuilly);
        ipAvenueDeNeuilly.setPreferredSize(new Dimension(iAvenueDeNeuilly.getIconWidth(), iAvenueDeNeuilly.getIconHeight()));
        panelGrille.add(ipAvenueDeNeuilly, gbc);

        //Compagnie d'Electricité
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipCompagnieElec = new ImagePanel(iCompagnieElec, PositionCase_enum.WEST, false);
        casesPlateau.put(13, ipCompagnieElec);
        ipCompagnieElec.setPreferredSize(new Dimension(iCompagnieElec.getIconWidth(), iCompagnieElec.getIconHeight()));
        panelGrille.add(ipCompagnieElec, gbc);

        //Boulevard De La Villette
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipBoulevardDeLaVillette = new ImagePanel(iBoulevardDeLaVillette, PositionCase_enum.WEST, true);
        casesPlateau.put(12, ipBoulevardDeLaVillette);
        ipBoulevardDeLaVillette.setPreferredSize(new Dimension(iBoulevardDeLaVillette.getIconWidth(), iBoulevardDeLaVillette.getIconHeight()));
        panelGrille.add(ipBoulevardDeLaVillette, gbc);

        //VISITE SIMPLE / PRISON
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipVisitePrison = new ImagePanel(iVisitePrison, PositionCase_enum.WEST, false);
        casesPlateau.put(11, ipVisitePrison);
        ipVisitePrison.setPreferredSize(new Dimension(iVisitePrison.getIconWidth(), iVisitePrison.getIconHeight()));
        panelGrille.add(ipVisitePrison, gbc);

        //Avenue De La Republique
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipAvenueDeLaRepublique = new ImagePanel(iAvenueDeLaRepublique, PositionCase_enum.SOUTH, true);
        casesPlateau.put(10, ipAvenueDeLaRepublique);
        ipAvenueDeLaRepublique.setPreferredSize(new Dimension(iAvenueDeLaRepublique.getIconWidth(), iAvenueDeLaRepublique.getIconHeight()));
        panelGrille.add(ipAvenueDeLaRepublique, gbc);

        //Rue De Courcelles
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipRueDeCourcelles = new ImagePanel(iRueDeCourcelles, PositionCase_enum.SOUTH, true);
        casesPlateau.put(91, ipRueDeCourcelles);
        ipRueDeCourcelles.setPreferredSize(new Dimension(iRueDeCourcelles.getIconWidth(), iRueDeCourcelles.getIconHeight()));
        panelGrille.add(ipRueDeCourcelles, gbc);

        //Chance 1
        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipChance1 = new ImagePanel(iChance1, PositionCase_enum.SOUTH, false);
        casesPlateau.put(8, ipChance1);
        ipChance1.setPreferredSize(new Dimension(iChance1.getIconWidth(), iChance1.getIconHeight()));
        panelGrille.add(ipChance1, gbc);

        //Rue De Vaugirard
        gbc.gridx = 4;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipRueDeVaugirard = new ImagePanel(iRueDeVaugirard, PositionCase_enum.SOUTH, true);
        casesPlateau.put(7, ipRueDeVaugirard);
        ipRueDeVaugirard.setPreferredSize(new Dimension(iRueDeVaugirard.getIconWidth(), iRueDeVaugirard.getIconHeight()));
        panelGrille.add(ipRueDeVaugirard, gbc);

        //Gare Montparnasse
        gbc.gridx = 5;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipGareMontparnasse = new ImagePanel(iGareMontparnasse, PositionCase_enum.SOUTH, false);
        casesPlateau.put(6, ipGareMontparnasse);
        ipGareMontparnasse.setPreferredSize(new Dimension(iGareMontparnasse.getIconWidth(), iGareMontparnasse.getIconHeight()));
        panelGrille.add(ipGareMontparnasse, gbc);

        //Impot Sur Le Revenu
        gbc.gridx = 6;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipImpotSurLeRevenu = new ImagePanel(iImpotSurLeRevenu, PositionCase_enum.SOUTH, false);
        casesPlateau.put(5, ipImpotSurLeRevenu);
        ipImpotSurLeRevenu.setPreferredSize(new Dimension(iImpotSurLeRevenu.getIconWidth(), iImpotSurLeRevenu.getIconHeight()));
        panelGrille.add(ipImpotSurLeRevenu, gbc);

        //Rue Lecourbe
        gbc.gridx = 7;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipRueLecourbe = new ImagePanel(iRueLecourbe, PositionCase_enum.SOUTH, true);
        casesPlateau.put(4, ipRueLecourbe);
        ipRueLecourbe.setPreferredSize(new Dimension(iRueLecourbe.getIconWidth(), iRueLecourbe.getIconHeight()));
        panelGrille.add(ipRueLecourbe, gbc);

        //Caisse de Communauté 1
        gbc.gridx = 8;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipCaisseCommu1 = new ImagePanel(iCaisseCommu1, PositionCase_enum.SOUTH, false);
        casesPlateau.put(3, ipCaisseCommu1);
        ipCaisseCommu1.setPreferredSize(new Dimension(iCaisseCommu1.getIconWidth(), iCaisseCommu1.getIconHeight()));
        panelGrille.add(ipCaisseCommu1, gbc);

        //Boulevard De Belleville
        gbc.gridx = 9;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipBoulevardDeBelleville = new ImagePanel(iBoulevardDeBelleville, PositionCase_enum.SOUTH, true);
        casesPlateau.put(2, ipBoulevardDeBelleville);
        ipBoulevardDeBelleville.setPreferredSize(new Dimension(iBoulevardDeBelleville.getIconWidth(), iBoulevardDeBelleville.getIconHeight()));
        panelGrille.add(ipBoulevardDeBelleville, gbc);

        //Case Depart
        gbc.gridx = 10;
        gbc.gridy = 10;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipCaseDepart = new ImagePanel(iCaseDepart, PositionCase_enum.SOUTH, false);
        casesPlateau.put(1, ipCaseDepart);
        ipCaseDepart.setPreferredSize(new Dimension(iCaseDepart.getIconWidth(), iCaseDepart.getIconHeight()));
        panelGrille.add(ipCaseDepart, gbc);

        //Rue De La Paix
        gbc.gridx = 10;
        gbc.gridy = 9;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipRueDeLaPaix = new ImagePanel(iRueDeLaPaix, PositionCase_enum.EAST, true);
        casesPlateau.put(40, ipRueDeLaPaix);
        ipRueDeLaPaix.setPreferredSize(new Dimension(iRueDeLaPaix.getIconWidth(), iRueDeLaPaix.getIconHeight()));
        panelGrille.add(ipRueDeLaPaix, gbc);

        //Taxe De Luxe
        gbc.gridx = 10;
        gbc.gridy = 8;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipTaxeDeLuxe = new ImagePanel(iTaxeDeLuxe, PositionCase_enum.EAST, false);
        casesPlateau.put(39, ipTaxeDeLuxe);
        ipTaxeDeLuxe.setPreferredSize(new Dimension(iTaxeDeLuxe.getIconWidth(), iTaxeDeLuxe.getIconHeight()));
        panelGrille.add(ipTaxeDeLuxe, gbc);

        //Avenue Des Champs Elysees
        gbc.gridx = 10;
        gbc.gridy = 7;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipAvenueDesChampsElysees = new ImagePanel(iAvenueDesChampsElysees, PositionCase_enum.EAST, true);
        casesPlateau.put(38, ipAvenueDesChampsElysees);
        ipAvenueDesChampsElysees.setPreferredSize(new Dimension(iAvenueDesChampsElysees.getIconWidth(), iAvenueDesChampsElysees.getIconHeight()));
        panelGrille.add(ipAvenueDesChampsElysees, gbc);

        //Chance 3
        gbc.gridx = 10;
        gbc.gridy = 6;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipChance3 = new ImagePanel(iChance3, PositionCase_enum.EAST, false);
        casesPlateau.put(37, ipChance3);
        ipChance3.setPreferredSize(new Dimension(iChance3.getIconWidth(), iChance3.getIconHeight()));
        panelGrille.add(ipChance3, gbc);

        //Gare Saint-Lazare
        gbc.gridx = 10;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipGareStLazare = new ImagePanel(iGareStLazare, PositionCase_enum.EAST, false);
        casesPlateau.put(36, ipGareStLazare);
        ipGareStLazare.setPreferredSize(new Dimension(iGareStLazare.getIconWidth(), iGareStLazare.getIconHeight()));
        panelGrille.add(ipGareStLazare, gbc);

        //Boulevard Des Capucines
        gbc.gridx = 10;
        gbc.gridy = 4;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipBoulevardDesCapucines = new ImagePanel(iBoulevardDesCapucines, PositionCase_enum.EAST, true);
        casesPlateau.put(35, ipBoulevardDesCapucines);
        ipBoulevardDesCapucines.setPreferredSize(new Dimension(iBoulevardDesCapucines.getIconWidth(), iBoulevardDesCapucines.getIconHeight()));
        panelGrille.add(ipBoulevardDesCapucines, gbc);

        // Caisse de Communauté 3
        gbc.gridx = 10;
        gbc.gridy = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipCaisseCommu3 = new ImagePanel(iCaisseCommu3, PositionCase_enum.EAST, false);
        casesPlateau.put(34, ipCaisseCommu3);
        ipCaisseCommu3.setPreferredSize(new Dimension(iCaisseCommu3.getIconWidth(), iCaisseCommu3.getIconHeight()));
        panelGrille.add(ipCaisseCommu3, gbc);

        //Avenue Foch
        gbc.gridx = 10;
        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipAvenueFoch = new ImagePanel(iAvenueFoch, PositionCase_enum.EAST, true);
        casesPlateau.put(33, ipAvenueFoch);
        ipAvenueFoch.setPreferredSize(new Dimension(iAvenueFoch.getIconWidth(), iAvenueFoch.getIconHeight()));
        panelGrille.add(ipAvenueFoch, gbc);

        //Avenue De Breteuil
        gbc.gridx = 10;
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipAvenueDeBreteuil = new ImagePanel(iAvenueDeBreteuil, PositionCase_enum.EAST, true);
        ipAvenueDeBreteuil.setLayout(new GridBagLayout());
        casesPlateau.put(32, ipAvenueDeBreteuil);
        ipAvenueDeBreteuil.setPreferredSize(new Dimension(iAvenueDeBreteuil.getIconWidth(), iAvenueDeBreteuil.getIconHeight()));
        panelGrille.add(ipAvenueDeBreteuil, gbc);
        
        
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        labelDe1 = new JLabel("De1");
        panelGrille.add(labelDe1, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        labelDe2 = new JLabel("De2");
        panelGrille.add(labelDe2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 5;
        labelPosition = new JLabel(" TEST");
        panelGrille.add(labelPosition, gbc);

    }

    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }

    public ImagePanel getCase(int num) {
        return casesPlateau.get(num);
    }

    //verification de toutes les cases du plateau
    public void verifCases() {
        for (int i : casesPlateau.keySet()) {
            System.out.println(i + "e case : " + casesPlateau.get(i));
        }
    }

//    public void setLabelPosition(Joueur joueur) {
//        if (joueur.getPosition() instanceof Terrain) {
//            this.labelPosition.setText(joueur.getNom() + " est sur : " + ((Terrain) joueur.getPosition()).getNom());
//        } else if (joueur.getPosition() instanceof Gare) {
//            this.labelPosition.setText(joueur.getNom() + " est sur : " + ((Gare) joueur.getPosition()).getNom());
//        } else if (joueur.getPosition() instanceof Compagnie) {
//            this.labelPosition.setText(joueur.getNom() + " est sur : " + ((Compagnie) joueur.getPosition()).getNom());
//        } else if (joueur.getPosition() instanceof CaseDépart) {
//            this.labelPosition.setText(joueur.getNom() + " est sur : " + ((CaseDépart) joueur.getPosition()).getNom());
//        } else if (joueur.getPosition() instanceof CasePrison) {
//            this.labelPosition.setText(joueur.getNom() + " est sur : " + ((CasePrison) joueur.getPosition()).getNom());
//        } else if (joueur.getPosition() instanceof CaseAllerEnPrison) {
//            this.labelPosition.setText(joueur.getNom() + " est sur : " + ((CaseAllerEnPrison) joueur.getPosition()).getNom());
//        } else if (joueur.getPosition() instanceof CasesCommunautaires_CartesChance) {
//            this.labelPosition.setText(joueur.getNom() + " est sur : " + ((CasesCommunautaires_CartesChance) joueur.getPosition()).getNom());
//        } else if (joueur.getPosition() instanceof ParcGratuit) {
//            this.labelPosition.setText(joueur.getNom() + " est sur : " + ((ParcGratuit) joueur.getPosition()).getNom());
//        } else if (joueur.getPosition() instanceof ImpotsTaxe) {
//            this.labelPosition.setText(joueur.getNom() + " est sur : " + ((ImpotsTaxe) joueur.getPosition()).getNom());
//        } else {
//            this.labelPosition.setText(joueur.getNom() + " est sur : " + joueur.getPosition().getNom());
//        }
//    }
    
    public void setLabelPosition(String s) {
        this.labelPosition.setText(s);
    }
    
    public void setLabelsDes(int de1, int de2) {
        this.labelDe1.setText("Dé 1 : " + de1);
        this.labelDe2.setText("Dé 2 : " + de2);
    }


    public void setJoueurCourant(Joueur joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    public JLabel getLabelJoueurCourant() {
        return labelJoueurCourant;
    }

    public void setLabelJoueurCourant(String text) {
        this.labelJoueurCourant.setText("Tour de : " + text);
    }

    public JLabel getLabelCagnotte() {
        return labelCagnotte;
    }

    public void setLabelCagnotte(int cagnotte) {
        //String sCagnotte = cagnotte.
        this.labelCagnotte.setText("Vous avez : " + cagnotte + "€");
    }

    public JButton getBtnLancerDès() {
        return btnLancerDès;
    }

    public JButton getBtnAcheterTerrain() {
        return btnAcheterTerrain;
    }

    public JButton getBtnConstruire() {
        return btnConstruire;
    }

    public JButton getBtnFinTour() {
        return btnFinTour;
    }

    public void refreshAction() {
        btnLancerDès.setEnabled(true);
        btnAcheterTerrain.setEnabled(true);
        btnConstruire.setEnabled(true);
        btnFinTour.setEnabled(true);
        btnAbandonner.setEnabled(true);
    }
}
