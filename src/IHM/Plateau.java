/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import com.sun.org.apache.bcel.internal.classfile.Code;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Plateau {

    private JFrame window;
    private JPanel panelGrille;

    public Plateau() {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(1100, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        //window.setResizable(false);

        panelGrille = new JPanel(new GridLayout(11, 11));
        panelGrille.setBackground(new Color(255, 191, 128));
        panelGrille.setOpaque(true);
        window.add(panelGrille);
        
        //Couleurs
        Color cMarron = new Color(146, 83, 69);
        Color cBleuClaire = new Color(144, 213, 227);
        Color cViollet = new Color(186, 109, 231);
        Color cOrange = new Color(232, 125, 64);
        Color cRouge = new Color(223, 68, 58);
        Color cJaune = new Color(239, 202, 65);
        Color cVert = new Color(39, 161, 44);
        Color cBleuFonce = new Color(46, 74, 163);
        Color cGris = new Color(172, 173, 179);

        for (int i = 0; i < 121; i++) {

            // CASE DEPART
            if (i == 120) {
                JLabel l = new JLabel("DEPART");
                l.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                
                panelGrille.add(l);

                //Propriétés MARRONS
            } else if (i == 119) {
                JLabel l = new JLabel("Boulevard de \n Belleville \n \n 220");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.BLACK)); //haut, gauche, bas, droite
                panelGrille.add(l);
                l.setBackground(cMarron);
                l.setOpaque(true);
            } else if (i == 117) {
                JLabel l = new JLabel("Rue Lecourbe \n \n 220");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cMarron);
                l.setOpaque(true);
                panelGrille.add(l);

                //Propriétés BLEUES CLAIRES
            } else if (i == 114) {
                JLabel l = new JLabel("Rue de \n Vaugirard \n \n 220");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cBleuClaire);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 112) {
                JLabel l = new JLabel("Rue de \n Courcelles \n \n 220");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cBleuClaire);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 111) {
                JLabel l = new JLabel("Avenue de  \n le République \n \n 220");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cBleuClaire);
                l.setOpaque(true);
                panelGrille.add(l);

                //SIMPLE VISITE
            } else if (i == 110) {
                JLabel l = new JLabel("SIMPLE \n VISITE \n \n 220");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                panelGrille.add(l);

                //Propriétés VIOLETTES
            } else if (i == 99) {
                JLabel l = new JLabel("Boulevard de \n Lavillette \n \n 220");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cViollet);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 77) {
                JLabel l = new JLabel("Avenue de \n Neuilly \n \n 220");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cViollet);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 66) {
                JLabel l = new JLabel("Rue de \n Paradis \n \n 220");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cViollet);
                l.setOpaque(true);
                panelGrille.add(l);

                //Propriétés ORANGES
            } else if (i == 44) {
                JLabel l = new JLabel("Avenue \n Mozart \n \n 180");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cOrange);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 22) {
                JLabel l = new JLabel("Boulevard \n Saint-Michel \n \n 180");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cOrange);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 11) {
                JLabel l = new JLabel("Place \n Pigale \n \n 200");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cOrange);
                l.setOpaque(true);
                panelGrille.add(l);

                //PARC GRATUIT
            } else if (i == 0) {
                JLabel l = new JLabel("Parc Gratuit");
                l.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite                
                panelGrille.add(l);

                //Propriétés ROUGES
            } else if (i == 1) {
                JLabel l = new JLabel("Avenue \n Matigon \n \n 220");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cRouge);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 3) {
                JLabel l = new JLabel("Boulevard \n Malherbes \n \n 220");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cRouge);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 4) {
                JLabel l = new JLabel("Avenue \n Henry-Martin \n \n 240");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cRouge);
                l.setOpaque(true);
                panelGrille.add(l);

                //Propriétés JAUNES
            } else if (i == 6) {
                JLabel l = new JLabel("Faubourg \n Saint-Honoré \n \n 260");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cJaune);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 7) {
                JLabel l = new JLabel("Palce De \n La Bourse \n \n 260");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cJaune);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 9) {
                JLabel l = new JLabel("Rue \n Lafayette \n \n 280");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cJaune);
                l.setOpaque(true);
                panelGrille.add(l);

                //ALLER EN PRISON
            } else if (i == 10) {
                JLabel l = new JLabel("Allez en \n prison");
                l.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                panelGrille.add(l);

                //Propriétés VERTES
            } else if (i == 21) {
                JLabel l = new JLabel("Avenue de \n Breteuil \n \n 280");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cVert);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 32) {
                JLabel l = new JLabel("Avenue Foch \n \n 280");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cVert);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 54) {
                JLabel l = new JLabel("Boulevard \n des Capucines \n \n 280");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cVert);
                l.setOpaque(true);
                panelGrille.add(l);

                //Propriétés BLEUES FONCES
            } else if (i == 87) {
                JLabel l = new JLabel("Avenue des \n Champs-Elysées \n \n 280");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cBleuFonce);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 109) {
                JLabel l = new JLabel("Rue de \n la Paix \n \n 280");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cBleuFonce);
                l.setOpaque(true);
                panelGrille.add(l);

                //Propriétés GARES
            } else if (i == 115) {
                JLabel l = new JLabel("Gare \n Montparnasse \n \n 200");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cGris);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 55) {
                JLabel l = new JLabel("Gare \n de Lyon \n \n 200");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cGris);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 5) {
                JLabel l = new JLabel("Gare \n du Nord \n \n 200");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cGris);
                l.setOpaque(true);
                panelGrille.add(l);
            } else if (i == 65) {
                JLabel l = new JLabel("Gare \n Saint-Lazare \n \n 200");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.BLACK)); //haut, gauche, bas, droite
                l.setBackground(cGris);
                l.setOpaque(true);
                panelGrille.add(l);

                //Propriétés COMPAGNIES
            } else if (i == 88) {
                JLabel l = new JLabel("Compagnie de \n distribution \n d'éléctricité \n 150");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                panelGrille.add(l);
            } else if (i == 8) {
                JLabel l = new JLabel("Compagnie de \n distribution \n des eaux \n 150");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                panelGrille.add(l);

                //IMPÔTS/TAXES
            } else if (i == 116) {
                JLabel l = new JLabel("IMPÔTS SUR \n LE REVENU");
                l.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                panelGrille.add(l);
            } else if (i == 98) {
                JLabel l = new JLabel("TAXE DE \n LUXE");
                l.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                panelGrille.add(l);

                //CHANCE
            } else if (i == 113 || i == 2 || i == 76) {
                JLabel l = new JLabel("CHANCE", SwingConstants.CENTER);
                l.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                panelGrille.add(l);

                //CAISSE DE COMMUNAUTE
            } else if (i == 118 || i == 33 || i == 43) {
                JLabel l = new JLabel("CAISSE DE COMMUNAUTE");
                l.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK)); //haut, gauche, bas, droite
                panelGrille.add(l);
            } else {
                panelGrille.add(new JLabel(""));
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
