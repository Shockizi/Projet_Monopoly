/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author yamin
 */
public class PlateauBis {

    private JFrame window;
    private JPanel mainPanel, panelGrille, panelCommande, panelPions, panelMaisons, panelDroite;
    private JLabel labelJoueurCourant = new JLabel("JOUEUR COURANT"), labelCagnotte = new JLabel("CAGNOTTE");
    private JButton btnLancerDès = new JButton("Lancer dès"), btnAcheterTerrain = new JButton("Acheter terrain"), btnConstruire = new JButton("Construire"), btnAbandonner = new JButton("Abandonner");
    private HashMap<Integer, ImagePanel> casesPlateau = new HashMap<Integer, ImagePanel>();

    public PlateauBis() {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(1100, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        //window.setResizable(false);
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 191, 128));
        mainPanel.setOpaque(true);

        panelGrille = new JPanel(new GridBagLayout());
        panelGrille.setBackground(new Color(255, 191, 128));
        panelGrille.setOpaque(true);

        panelCommande = new JPanel(new GridLayout(16, 3));
        panelCommande.setBackground(new Color(255, 191, 128));
        panelCommande.setOpaque(true);

        mainPanel.add(panelGrille, BorderLayout.CENTER);
        mainPanel.add(panelCommande, BorderLayout.EAST);
        window.add(mainPanel);

        // Boutons à droite //
        for (int i = 1; i < 48; i++) {
            if (i == 5) {
                panelCommande.add(labelJoueurCourant);
            } else if (i == 8) {
                panelCommande.add(labelCagnotte);
            } else if (i == 14) {
                panelCommande.add(btnLancerDès);
                btnLancerDès.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }
                });
            } else if (i == 20) {
                panelCommande.add(btnAcheterTerrain);
                btnAcheterTerrain.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }
                });
            } else if (i == 26) {
                panelCommande.add(btnConstruire);
                btnConstruire.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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

        // ======= Creation du Plateau =======
        GridBagConstraints gbc = new GridBagConstraints();

        //PARC GRATUIT
        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipParcGratuit = new ImagePanel(iParcGratuit);
        ipParcGratuit.setPreferredSize(new Dimension(iParcGratuit.getIconWidth(), iParcGratuit.getIconHeight()));
        casesPlateau.put(21, ipParcGratuit);
        panelGrille.add(ipParcGratuit, gbc);

        //Avenue Matignon
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipAvenueMatigon = new ImagePanel(iAvenueMatignon);
        casesPlateau.put(22, ipAvenueMatigon);
        ipAvenueMatigon.setPreferredSize(new Dimension(iAvenueMatignon.getIconWidth(), iAvenueMatignon.getIconHeight()));
        panelGrille.add(ipAvenueMatigon, gbc);

        //Chance 2
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipChance2 = new ImagePanel(iChance2);
        casesPlateau.put(23, ipChance2);
        ipChance2.setPreferredSize(new Dimension(iChance2.getIconWidth(), iChance2.getIconHeight()));
        panelGrille.add(ipChance2, gbc);

        //Boulevard Malherbes
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipBoulevardMalherbes = new ImagePanel(iBoulevardMalherbes);
        casesPlateau.put(24, ipBoulevardMalherbes);
        ipBoulevardMalherbes.setPreferredSize(new Dimension(iBoulevardMalherbes.getIconWidth(), iBoulevardMalherbes.getIconHeight()));
        panelGrille.add(ipBoulevardMalherbes, gbc);

        //Avenue Henri-Martin
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipAvenueHenriMartin = new ImagePanel(iAvenueHenriMartin);
        casesPlateau.put(25, ipAvenueHenriMartin);
        ipAvenueHenriMartin.setPreferredSize(new Dimension(iAvenueHenriMartin.getIconWidth(), iAvenueHenriMartin.getIconHeight()));
        panelGrille.add(ipAvenueHenriMartin, gbc);

        //Gare du Nord
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipGareDuNord = new ImagePanel(iGareDuNord);
        casesPlateau.put(26, ipGareDuNord);
        ipGareDuNord.setPreferredSize(new Dimension(iGareDuNord.getIconWidth(), iGareDuNord.getIconHeight()));
        panelGrille.add(ipGareDuNord, gbc);

        //Faubourg Saint-Honoré
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipFaubourgSaintHonore = new ImagePanel(iFaubourgSaintHonore);
        casesPlateau.put(27, ipFaubourgSaintHonore);
        ipFaubourgSaintHonore.setPreferredSize(new Dimension(iFaubourgSaintHonore.getIconWidth(), iFaubourgSaintHonore.getIconHeight()));
        panelGrille.add(ipFaubourgSaintHonore, gbc);

        //Place De La Bourse
        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipPlaceDeLaBourse = new ImagePanel(iPlaceDeLaBourse);
        casesPlateau.put(28, ipPlaceDeLaBourse);
        ipPlaceDeLaBourse.setPreferredSize(new Dimension(iPlaceDeLaBourse.getIconWidth(), iPlaceDeLaBourse.getIconHeight()));
        panelGrille.add(ipPlaceDeLaBourse, gbc);

        //Compagnie des Eaux
        gbc.gridx = 8;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipCompagnieEaux = new ImagePanel(iCompagnieEaux);
        casesPlateau.put(29, ipCompagnieEaux);
        ipCompagnieEaux.setPreferredSize(new Dimension(iCompagnieEaux.getIconWidth(), iCompagnieEaux.getIconHeight()));
        panelGrille.add(ipCompagnieEaux, gbc);

        //Rue La Fayette
        gbc.gridx = 9;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipRueLaFayette = new ImagePanel(iRueLaFayette);
        casesPlateau.put(30, ipRueLaFayette);
        ipRueLaFayette.setPreferredSize(new Dimension(iRueLaFayette.getIconWidth(), iRueLaFayette.getIconHeight()));
        panelGrille.add(ipRueLaFayette, gbc);

        //ALLEZ EN PRISON
        gbc.gridx = 10;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipAllezEnPrison = new ImagePanel(iAllezEnPrison);
        casesPlateau.put(31, ipAllezEnPrison);
        ipAllezEnPrison.setPreferredSize(new Dimension(iAllezEnPrison.getIconWidth(), iAllezEnPrison.getIconHeight()));
        panelGrille.add(ipAllezEnPrison, gbc);

        //Place Pigalle
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipPlacePigalle = new ImagePanel(iPlacePigalle);
        casesPlateau.put(20, ipPlacePigalle);
        ipPlacePigalle.setPreferredSize(new Dimension(iPlacePigalle.getIconWidth(), iPlacePigalle.getIconHeight()));
        panelGrille.add(ipPlacePigalle, gbc);

        //Boulevard Saint-Michel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipBoulevardStMichel = new ImagePanel(iBoulevardStMichel);
        casesPlateau.put(19, ipBoulevardStMichel);
        ipBoulevardStMichel.setPreferredSize(new Dimension(iBoulevardStMichel.getIconWidth(), iBoulevardStMichel.getIconHeight()));
        panelGrille.add(ipBoulevardStMichel, gbc);

        //Caisse de Communauté 2
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipCaisseCommu2 = new ImagePanel(iCaisseCommu2);
        casesPlateau.put(18, ipCaisseCommu2);
        ipCaisseCommu2.setPreferredSize(new Dimension(iCaisseCommu2.getIconWidth(), iCaisseCommu2.getIconHeight()));
        panelGrille.add(ipCaisseCommu2, gbc);

        //Avenue Mozart
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipAvenueMozart = new ImagePanel(iAvenueMozart);
        casesPlateau.put(17, ipAvenueMozart);
        ipAvenueMozart.setPreferredSize(new Dimension(iAvenueMozart.getIconWidth(), iAvenueMozart.getIconHeight()));
        panelGrille.add(ipAvenueMozart, gbc);

        //Gare De Lyon
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipGareDeLyon = new ImagePanel(iGareDeLyon);
        casesPlateau.put(16, ipGareDeLyon);
        ipGareDeLyon.setPreferredSize(new Dimension(iGareDeLyon.getIconWidth(), iGareDeLyon.getIconHeight()));
        panelGrille.add(ipGareDeLyon, gbc);

        //Rue De Paradis
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipRueDeParadis = new ImagePanel(iRueDeParadis);
        casesPlateau.put(15, ipRueDeParadis);
        ipRueDeParadis.setPreferredSize(new Dimension(iRueDeParadis.getIconWidth(), iRueDeParadis.getIconHeight()));
        panelGrille.add(ipRueDeParadis, gbc);

        //Avenue De Neuilly
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipAvenueDeNeuilly = new ImagePanel(iAvenueDeNeuilly);
        casesPlateau.put(14, ipAvenueDeNeuilly);
        ipAvenueDeNeuilly.setPreferredSize(new Dimension(iAvenueDeNeuilly.getIconWidth(), iAvenueDeNeuilly.getIconHeight()));
        panelGrille.add(ipAvenueDeNeuilly, gbc);

        //Compagnie d'Electricité
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipCompagnieElec = new ImagePanel(iCompagnieElec);
        casesPlateau.put(13, ipCompagnieElec);
        ipCompagnieElec.setPreferredSize(new Dimension(iCompagnieElec.getIconWidth(), iCompagnieElec.getIconHeight()));
        panelGrille.add(ipCompagnieElec, gbc);

        //Boulevard De La Villette
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        ImagePanel ipBoulevardDeLaVillette = new ImagePanel(iBoulevardDeLaVillette);
        casesPlateau.put(12, ipBoulevardDeLaVillette);
        ipBoulevardDeLaVillette.setPreferredSize(new Dimension(iBoulevardDeLaVillette.getIconWidth(), iBoulevardDeLaVillette.getIconHeight()));
        panelGrille.add(ipBoulevardDeLaVillette, gbc);

        //VISITE SIMPLE / PRISON
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipVisitePrison = new ImagePanel(iVisitePrison);
        casesPlateau.put(11, ipVisitePrison);
        ipVisitePrison.setPreferredSize(new Dimension(iVisitePrison.getIconWidth(), iVisitePrison.getIconHeight()));
        panelGrille.add(ipVisitePrison, gbc);

        //Avenue De La Republique
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipAvenueDeLaRepublique = new ImagePanel(iAvenueDeLaRepublique);
        casesPlateau.put(10, ipAvenueDeLaRepublique);
        ipAvenueDeLaRepublique.setPreferredSize(new Dimension(iAvenueDeLaRepublique.getIconWidth(), iAvenueDeLaRepublique.getIconHeight()));
        panelGrille.add(ipAvenueDeLaRepublique, gbc);

        //Rue De Courcelles
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipRueDeCourcelles = new ImagePanel(iRueDeCourcelles);
        casesPlateau.put(91, ipRueDeCourcelles);
        ipRueDeCourcelles.setPreferredSize(new Dimension(iRueDeCourcelles.getIconWidth(), iRueDeCourcelles.getIconHeight()));
        panelGrille.add(ipRueDeCourcelles, gbc);

        //Chance 1
        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipChance1 = new ImagePanel(iChance1);
        casesPlateau.put(8, ipChance1);
        ipChance1.setPreferredSize(new Dimension(iChance1.getIconWidth(), iChance1.getIconHeight()));
        panelGrille.add(ipChance1, gbc);

        //Rue De Vaugirard
        gbc.gridx = 4;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipRueDeVaugirard = new ImagePanel(iRueDeVaugirard);
        casesPlateau.put(7, ipRueDeVaugirard);
        ipRueDeVaugirard.setPreferredSize(new Dimension(iRueDeVaugirard.getIconWidth(), iRueDeVaugirard.getIconHeight()));
        panelGrille.add(ipRueDeVaugirard, gbc);

        //Gare Montparnasse
        gbc.gridx = 5;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipGareMontparnasse = new ImagePanel(iGareMontparnasse);
        casesPlateau.put(6, ipGareMontparnasse);
        ipGareMontparnasse.setPreferredSize(new Dimension(iGareMontparnasse.getIconWidth(), iGareMontparnasse.getIconHeight()));
        panelGrille.add(ipGareMontparnasse, gbc);

        //Impot Sur Le Revenu
        gbc.gridx = 6;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipImpotSurLeRevenu = new ImagePanel(iImpotSurLeRevenu);
        casesPlateau.put(5, ipImpotSurLeRevenu);
        ipImpotSurLeRevenu.setPreferredSize(new Dimension(iImpotSurLeRevenu.getIconWidth(), iImpotSurLeRevenu.getIconHeight()));
        panelGrille.add(ipImpotSurLeRevenu, gbc);

        //Rue Lecourbe
        gbc.gridx = 7;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipRueLecourbe = new ImagePanel(iRueLecourbe);
        casesPlateau.put(4, ipRueLecourbe);
        ipRueLecourbe.setPreferredSize(new Dimension(iRueLecourbe.getIconWidth(), iRueLecourbe.getIconHeight()));
        panelGrille.add(ipRueLecourbe, gbc);

        //Caisse de Communauté 1
        gbc.gridx = 8;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipCaisseCommu1 = new ImagePanel(iCaisseCommu1);
        casesPlateau.put(3, ipCaisseCommu1);
        ipCaisseCommu1.setPreferredSize(new Dimension(iCaisseCommu1.getIconWidth(), iCaisseCommu1.getIconHeight()));
        panelGrille.add(ipCaisseCommu1, gbc);

        //Boulevard De Belleville
        gbc.gridx = 9;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipBoulevardDeBelleville = new ImagePanel(iBoulevardDeBelleville);
        casesPlateau.put(2, ipBoulevardDeBelleville);
        ipBoulevardDeBelleville.setPreferredSize(new Dimension(iBoulevardDeBelleville.getIconWidth(), iBoulevardDeBelleville.getIconHeight()));
        panelGrille.add(ipBoulevardDeBelleville, gbc);

        //Case Depart
        gbc.gridx = 10;
        gbc.gridy = 10;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        ImagePanel ipCaseDepart = new ImagePanel(iCaseDepart);
        casesPlateau.put(1, ipCaseDepart);
        ipCaseDepart.setPreferredSize(new Dimension(iCaseDepart.getIconWidth(), iCaseDepart.getIconHeight()));
        panelGrille.add(ipCaseDepart, gbc);

        //Rue De La Paix
        gbc.gridx = 10;
        gbc.gridy = 9;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipRueDeLaPaix = new ImagePanel(iRueDeLaPaix);
        casesPlateau.put(40, ipRueDeLaPaix);
        ipRueDeLaPaix.setPreferredSize(new Dimension(iRueDeLaPaix.getIconWidth(), iRueDeLaPaix.getIconHeight()));
        panelGrille.add(ipRueDeLaPaix, gbc);

        //Taxe De Luxe
        gbc.gridx = 10;
        gbc.gridy = 8;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipTaxeDeLuxe = new ImagePanel(iTaxeDeLuxe);
        casesPlateau.put(39, ipTaxeDeLuxe);
        ipTaxeDeLuxe.setPreferredSize(new Dimension(iTaxeDeLuxe.getIconWidth(), iTaxeDeLuxe.getIconHeight()));
        panelGrille.add(ipTaxeDeLuxe, gbc);

        //Avenue Des Champs Elysees
        gbc.gridx = 10;
        gbc.gridy = 7;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipAvenueDesChampsElysees = new ImagePanel(iAvenueDesChampsElysees);
        casesPlateau.put(38, ipAvenueDesChampsElysees);
        ipAvenueDesChampsElysees.setPreferredSize(new Dimension(iAvenueDesChampsElysees.getIconWidth(), iAvenueDesChampsElysees.getIconHeight()));
        panelGrille.add(ipAvenueDesChampsElysees, gbc);

        //Chance 3
        gbc.gridx = 10;
        gbc.gridy = 6;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipChance3 = new ImagePanel(iChance3);
        casesPlateau.put(37, ipChance3);
        ipChance3.setPreferredSize(new Dimension(iChance3.getIconWidth(), iChance3.getIconHeight()));
        panelGrille.add(ipChance3, gbc);

        //Gare Saint-Lazare
        gbc.gridx = 10;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipGareStLazare = new ImagePanel(iGareStLazare);
        casesPlateau.put(36, ipGareStLazare);
        ipGareStLazare.setPreferredSize(new Dimension(iGareStLazare.getIconWidth(), iGareStLazare.getIconHeight()));
        panelGrille.add(ipGareStLazare, gbc);

        //Boulevard Des Capucines
        gbc.gridx = 10;
        gbc.gridy = 4;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipBoulevardDesCapucines = new ImagePanel(iBoulevardDesCapucines);
        casesPlateau.put(35, ipBoulevardDesCapucines);
        ipBoulevardDesCapucines.setPreferredSize(new Dimension(iBoulevardDesCapucines.getIconWidth(), iBoulevardDesCapucines.getIconHeight()));
        panelGrille.add(ipBoulevardDesCapucines, gbc);

        // Caisse de Communauté 3
        gbc.gridx = 10;
        gbc.gridy = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipCaisseCommu3 = new ImagePanel(iCaisseCommu3);
        casesPlateau.put(34, ipCaisseCommu3);
        ipCaisseCommu3.setPreferredSize(new Dimension(iCaisseCommu3.getIconWidth(), iCaisseCommu3.getIconHeight()));
        panelGrille.add(ipCaisseCommu3, gbc);

        //Avenue Foch
        gbc.gridx = 10;
        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipAvenueFoch = new ImagePanel(iAvenueFoch);
        casesPlateau.put(33, ipAvenueFoch);
        ipAvenueFoch.setPreferredSize(new Dimension(iAvenueFoch.getIconWidth(), iAvenueFoch.getIconHeight()));
        panelGrille.add(ipAvenueFoch, gbc);

        //Avenue De Breteuil
        gbc.gridx = 10;
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        ImagePanel ipAvenueDeBreteuil = new ImagePanel(iAvenueDeBreteuil);
        ipAvenueDeBreteuil.setLayout(new GridBagLayout());
        casesPlateau.put(32, ipAvenueDeBreteuil);
        ipAvenueDeBreteuil.setPreferredSize(new Dimension(iAvenueDeBreteuil.getIconWidth(), iAvenueDeBreteuil.getIconHeight()));
        panelGrille.add(ipAvenueDeBreteuil, gbc);

        panelMaisons = new JPanel();
        for (int i : casesPlateau.keySet()) {
            ImagePanel ip = casesPlateau.get(i);
            ip.setLayout(new GridBagLayout());
            //Case BAS
            if (i == 2 || i == 4 || i == 7 || i == 9 || i == 10) {
                panelPions = new JPanel(new GridLayout(2, 3));

            } else if (i == 3 || i == 5 || i == 6 || i == 8) {
                panelPions = new JPanel(new GridLayout(2, 3));

                //Case GAUCHE
            } else if (i == 12 || i == 14 || i == 15 || i == 17 || i == 19 || i == 20) {
                panelPions = new JPanel(new GridLayout(3, 2));

            } else if (i == 13 || i == 16 || i == 18) {
                panelPions = new JPanel(new GridLayout(3, 2));

                //Cases HAUT
            } else if (i == 22 || i == 24 || i == 25 || i == 27 || i == 28 || i == 30) {
                panelPions = new JPanel(new GridLayout(2, 3));

            } else if (i == 23 || i == 26 || i == 29) {
                panelPions = new JPanel(new GridLayout(2, 3));

                //Cases DROITE
            } else if (i == 32 || i == 33 || i == 35 || i == 38 || i == 40) {
                panelPions = new JPanel(new GridLayout(3, 2));

            } else if (i == 34 || i == 36 || i == 37 || i == 39) {

                //Cases COIN
            } else if (i == 1 || i == 21 || i == 31) {

                //Visite-Prison
            } else if (i == 11) {

            }
        }

    }

    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }

}
