/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author elmiry
 */
public class Inscription extends Observable {

    private JFrame window;
    private JPanel mainPanel, panelNord, PanelCentre, PanelWest, PanelEast, PanelSouth;
    private JLabel labelTitre, labelImage;
    private JButton commencer, retour;
    private String nomj1, nomj2, nomj3, nomj4, nomj5, nomj6;

    public Inscription() {
        window = new JFrame();
        window.setTitle("Inscription Monopoly");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(1100, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        //window.setResizable(false);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 191, 128));
        mainPanel.setOpaque(true);
        window.add(mainPanel);

        //partie nord
        panelNord = new JPanel(new BorderLayout());
        labelTitre = new JLabel("PARAMÉTRAGE DES JOUEURS", SwingConstants.CENTER);
        labelTitre.setForeground(Color.WHITE);
        labelTitre.setBackground(new Color(255, 191, 128));
        labelTitre.setOpaque(true);
        panelNord.add(labelTitre);
        mainPanel.add(panelNord);

        //partie centre
        PanelCentre = new JPanel(new BorderLayout());
        PanelEast = new JPanel(new GridLayout(6, 2));
        PanelWest = new JPanel();
        mainPanel.add(PanelCentre);
        PanelCentre.add(PanelEast);
        PanelCentre.add(PanelWest);

        //image Ouest
        ImageIcon imgJouer = new ImageIcon(System.getProperty("user.dir") + "/src/image/MrMonopoly.png");
        labelImage = new JLabel(imgJouer);
        PanelWest.add(labelImage);

        //image Est
        JLabel nj1 = new JLabel("Nom joueur 1 : ");
        JLabel nj2 = new JLabel("Nom joueur 2 : ");
        JLabel nj3 = new JLabel("Nom joueur 3 : ");
        JLabel nj4 = new JLabel("Nom joueur 4 : ");
        JLabel nj5 = new JLabel("Nom joueur 5 : ");
        JLabel nj6 = new JLabel("Nom joueur 6 : ");
        JTextField jtf1 = new JTextField("Joueur1");
        JTextField jtf2 = new JTextField("Joueur2");
        JTextField jtf3 = new JTextField("Joueur3");
        JTextField jtf4 = new JTextField("Joueur4");
        JTextField jtf5 = new JTextField("Joueur5");
        JTextField jtf6 = new JTextField("Joueur6");

        if (listeDeroulante.getSelectedItem() == "2") {
            nj1.setVisible(true);
            jtf1.setVisible(true);
            nj2.setVisible(true);
            jtf2.setVisible(true);
            nj3.setVisible(false);
            jtf3.setVisible(false);
            nj4.setVisible(false);
            jtf4.setVisible(false);
            nombreJoueurs = 2;

        }

        if (listeDeroulante.getSelectedItem() == "3") {
            nj1.setVisible(true);
            jtf1.setVisible(true);
            nj2.setVisible(true);
            jtf2.setVisible(true);
            nj3.setVisible(true);
            jtf3.setVisible(true);
            nj4.setVisible(false);
            jtf4.setVisible(false);
            nombreJoueurs = 3;

        }

        if (listeDeroulante.getSelectedItem() == "4") {
            nj1.setVisible(true);
            jtf1.setVisible(true);
            nj2.setVisible(true);
            jtf2.setVisible(true);
            nj3.setVisible(true);
            jtf3.setVisible(true);
            nj4.setVisible(true);
            jtf4.setVisible(true);
            nombreJoueurs = 4;

        }
        //partie sud
        PanelSouth = new JPanel(new GridLayout(1, 6));
        mainPanel.add(PanelSouth, BorderLayout.SOUTH);
        retour = new JButton("Retour");
        commencer = new JButton("Commencer");
        for (int i = 1; i <= 6; i++) {
            if (i == 1) {
                PanelSouth.add(retour);
                retour.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers();
                        clearChanged();
                    }
                });
            } else if (i == 6) {
                PanelSouth.add(commencer);
                commencer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers();
                        clearChanged();
                    }
                });
            } else {
                JLabel l = new JLabel("");
                l.setBackground(new Color(255, 191, 128));
                l.setOpaque(true);
                PanelSouth.add(l);
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
