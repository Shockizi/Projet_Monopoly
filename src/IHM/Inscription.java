/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Message.Message;
import Message.TypeMessages;
import Modèle.Joueur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    private JPanel mainPanel, panelNord, PanelCentre, PanelWest, PanelEast, PanelSouth, panelJ1, panelJ2, panelJ3, panelJ4, panelJ5, panelJ6, panelCombo1, panelCombo2, panelCombo3, panelCombo4, panelCombo5, panelCombo6;
    private JLabel labelTitre, labelImage;
    private JButton commencer, retour;
    private int nbJoueurs;
    private Message m;
    private JComboBox symbole, symbole2, symbole3, symbole4, symbole5, symbole6;
    private String[] pions = {"Voiture", "Bâteau", "Dé à Coudre", "Chapeau", "Fer à repasser", "Brouette"};
    
    private HashMap<Joueur,Color > joueurs = new HashMap<Joueur, Color>();
    
    public Inscription(int nbJoueurs) {
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
        labelTitre.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitre.setForeground(Color.BLACK);
        labelTitre.setBackground(new Color(255, 191, 128));
        labelTitre.setOpaque(true);
        panelNord.add(labelTitre);
        mainPanel.add(panelNord, BorderLayout.NORTH);

        //partie centre
        PanelCentre = new JPanel(new BorderLayout());
        PanelCentre.setBackground(new Color(255, 191, 128));
        PanelEast = new JPanel(new GridLayout(6, 3));
        PanelEast.setBackground(new Color(255, 191, 128));
        PanelWest = new JPanel();
        PanelWest.setBackground(new Color(255, 191, 128));
        mainPanel.add(PanelCentre);
        PanelCentre.add(PanelEast, BorderLayout.EAST);
        PanelCentre.add(PanelWest, BorderLayout.WEST);

        //partie Ouest
        ImageIcon imgJouer = new ImageIcon(System.getProperty("user.dir") + "/src/image/MrMonopoly.png");
        labelImage = new JLabel(imgJouer);
        PanelWest.add(labelImage);

        //partie Est
        JLabel nj1 = new JLabel("Nom joueur 1 : ", SwingConstants.RIGHT);
        JLabel nj2 = new JLabel("Nom joueur 2 : ", SwingConstants.RIGHT);
        JLabel nj3 = new JLabel("Nom joueur 3 : ", SwingConstants.RIGHT);
        JLabel nj4 = new JLabel("Nom joueur 4 : ", SwingConstants.RIGHT);
        JLabel nj5 = new JLabel("Nom joueur 5 : ", SwingConstants.RIGHT);
        JLabel nj6 = new JLabel("Nom joueur 6 : ", SwingConstants.RIGHT);

        JTextField jtf1 = new JTextField("Joueur1");
        jtf1.setBorder(null);
        JTextField jtf2 = new JTextField("Joueur2");
        jtf2.setBorder(null);
        JTextField jtf3 = new JTextField("Joueur3");
        jtf3.setBorder(null);
        JTextField jtf4 = new JTextField("Joueur4");
        jtf4.setBorder(null);
        JTextField jtf5 = new JTextField("Joueur5");
        jtf5.setBorder(null);
        JTextField jtf6 = new JTextField("Joueur6");
        jtf6.setBorder(null);

        symbole = new JComboBox(pions);
        symbole.setSelectedItem("Voiture");
        symbole2 = new JComboBox(pions);
        symbole2.setSelectedItem("Bâteau");
        symbole3 = new JComboBox(pions);
        symbole3.setSelectedItem("Dé à Coudre");
        symbole4 = new JComboBox(pions);
        symbole4.setSelectedItem("Chapeau");
        symbole5 = new JComboBox(pions);
        symbole5.setSelectedItem("Fer à repasser");
        symbole6 = new JComboBox(pions);
        symbole6.setSelectedItem("Brouette");

        //panel joueurs
        panelJ1 = new JPanel();
        panelJ1.setBackground(new Color(255, 191, 128));
        panelJ1.setLayout(new GridLayout(3, 1));
        panelJ1.add(new JLabel(" "));
        panelJ1.add(jtf1);
        panelJ1.add(new JLabel(" "));

        panelJ2 = new JPanel();
        panelJ2.setBackground(new Color(255, 191, 128));
        panelJ2.setLayout(new GridLayout(3, 1));
        panelJ2.add(new JLabel(" "));
        panelJ2.add(jtf2);
        panelJ2.add(new JLabel(" "));

        panelJ3 = new JPanel();
        panelJ3.setBackground(new Color(255, 191, 128));
        panelJ3.setLayout(new GridLayout(3, 1));
        panelJ3.add(new JLabel(" "));
        panelJ3.add(jtf3);
        panelJ3.add(new JLabel(" "));

        panelJ4 = new JPanel();
        panelJ4.setBackground(new Color(255, 191, 128));
        panelJ4.setLayout(new GridLayout(3, 1));
        panelJ4.add(new JLabel(" "));
        panelJ4.add(jtf4);
        panelJ4.add(new JLabel(" "));

        panelJ5 = new JPanel();
        panelJ5.setBackground(new Color(255, 191, 128));
        panelJ5.setLayout(new GridLayout(3, 1));
        panelJ5.add(new JLabel(" "));
        panelJ5.add(jtf5);
        panelJ5.add(new JLabel(" "));

        panelJ6 = new JPanel();
        panelJ6.setBackground(new Color(255, 191, 128));
        panelJ6.setLayout(new GridLayout(3, 1));
        panelJ6.add(new JLabel(" "));
        panelJ6.add(jtf6);
        panelJ6.add(new JLabel(" "));

        // panel combobox
        panelCombo1 = new JPanel();
        panelCombo1.setLayout(new GridLayout(3, 1));
        panelCombo1.setBackground(new Color(255, 191, 128));
        panelCombo1.add(new JLabel(" "));
        panelCombo1.add(symbole);
        panelCombo1.add(new JLabel(" "));

        panelCombo2 = new JPanel();
        panelCombo2.setLayout(new GridLayout(3, 1));
        panelCombo2.setBackground(new Color(255, 191, 128));
        panelCombo2.add(new JLabel(" "));
        panelCombo2.add(symbole2);
        panelCombo2.add(new JLabel(" "));

        panelCombo3 = new JPanel();
        panelCombo3.setLayout(new GridLayout(3, 1));
        panelCombo3.setBackground(new Color(255, 191, 128));
        panelCombo3.add(new JLabel(" "));
        panelCombo3.add(symbole3);
        panelCombo3.add(new JLabel(" "));

        panelCombo4 = new JPanel();
        panelCombo4.setLayout(new GridLayout(3, 1));
        panelCombo4.setBackground(new Color(255, 191, 128));
        panelCombo4.add(new JLabel(" "));
        panelCombo4.add(symbole4);
        panelCombo4.add(new JLabel(" "));

        panelCombo5 = new JPanel();
        panelCombo5.setLayout(new GridLayout(3, 1));
        panelCombo5.setBackground(new Color(255, 191, 128));
        panelCombo5.add(new JLabel(" "));
        panelCombo5.add(symbole5);
        panelCombo5.add(new JLabel(" "));

        panelCombo6 = new JPanel();
        panelCombo6.setLayout(new GridLayout(3, 1));
        panelCombo6.setBackground(new Color(255, 191, 128));
        panelCombo6.add(new JLabel(" "));
        panelCombo6.add(symbole6);
        panelCombo6.add(new JLabel(" "));
        
//        System.out.println(getNbJoueurs());
        if (nbJoueurs == 2) {
            PanelEast.add(nj1);
            PanelEast.add(panelJ1);
            PanelEast.add(panelCombo1);
            PanelEast.add(nj2);
            PanelEast.add(panelJ2);
            PanelEast.add(panelCombo2);
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
        }

        if (nbJoueurs == 3) {
            PanelEast.add(nj1);
            PanelEast.add(panelJ1);
            PanelEast.add(panelCombo1);
            PanelEast.add(nj2);
            PanelEast.add(panelJ2);
            PanelEast.add(panelCombo2);
            PanelEast.add(nj3);
            PanelEast.add(panelJ3);
            PanelEast.add(panelCombo3);
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));

        }

        if (nbJoueurs == 4) {
            PanelEast.add(nj1);
            PanelEast.add(panelJ1);
            PanelEast.add(panelCombo1);
            PanelEast.add(nj2);
            PanelEast.add(panelJ2);
            PanelEast.add(panelCombo2);
            PanelEast.add(nj3);
            PanelEast.add(panelJ3);
            PanelEast.add(panelCombo3);
            PanelEast.add(nj4);
            PanelEast.add(panelJ4);
            PanelEast.add(panelCombo4);
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));

        }

        if (nbJoueurs == 5) {
            PanelEast.add(nj1);
            PanelEast.add(panelJ1);
            PanelEast.add(panelCombo1);
            PanelEast.add(nj2);
            PanelEast.add(panelJ2);
            PanelEast.add(panelCombo2);
            PanelEast.add(nj3);
            PanelEast.add(panelJ3);
            PanelEast.add(panelCombo3);
            PanelEast.add(nj4);
            PanelEast.add(panelJ4);
            PanelEast.add(panelCombo4);
            PanelEast.add(nj5);
            PanelEast.add(panelJ5);
            PanelEast.add(panelCombo5);
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));
            PanelEast.add(new JLabel(""));

        }

        if (nbJoueurs == 6) {
            PanelEast.add(nj1);
            PanelEast.add(panelJ1);
            PanelEast.add(panelCombo1);
            PanelEast.add(nj2);
            PanelEast.add(panelJ2);
            PanelEast.add(panelCombo2);
            PanelEast.add(nj3);
            PanelEast.add(panelJ3);
            PanelEast.add(panelCombo3);
            PanelEast.add(nj4);
            PanelEast.add(panelJ4);
            PanelEast.add(panelCombo4);
            PanelEast.add(nj5);
            PanelEast.add(panelJ5);
            PanelEast.add(panelCombo5);
            PanelEast.add(nj6);
            PanelEast.add(panelJ6);
            PanelEast.add(panelCombo6);

        }
        //partie sud
        PanelSouth = new JPanel(new GridLayout(1, 6));
        mainPanel.add(PanelSouth, BorderLayout.SOUTH);
        retour = new JButton("Retour");
        retour.setBackground(new Color(212, 47, 34));
        commencer = new JButton("Commencer");
        commencer.setBackground(new Color(212, 47, 34));
        for (int i = 1; i <= 6; i++) {
            if (i == 1) {
                PanelSouth.add(retour);
                retour.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.RETOUR));
                        clearChanged();
                    }
                });
            } else if (i == 6) {
                PanelSouth.add(commencer);
                commencer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        Joueur j1 = new Joueur(jtf1.getText());
                        Joueur j2 = new Joueur(jtf2.getText());
                        Joueur j3 = new Joueur(jtf3.getText());
                        Joueur j4 = new Joueur(jtf4.getText());
                        Joueur j5 = new Joueur(jtf5.getText());
                        Joueur j6 = new Joueur(jtf6.getText());
                        
                        joueurs.put(j1, Color.blue);
                        joueurs.put(j2, Color.red);
                        joueurs.put(j3, Color.yellow);
                        joueurs.put(j4, Color.green);
                        joueurs.put(j5, Color.PINK);
                        joueurs.put(j6, Color.ORANGE);
                        
                        setChanged();
                        notifyObservers(new Message(TypeMessages.COMMENCER));
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
    
    
//        @Override
//    public synchronized void addObserver(Observer o) {
//        System.out.println("IHM.Accueil.addObserver():: ajout d'un observateur");
//        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
//    }

    public HashMap<Joueur, Color> getJoueurs() {
        return joueurs;
    }
}
