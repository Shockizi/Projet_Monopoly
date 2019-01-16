/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Message.Message;
import Message.TypeMessages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author elmiry
 */
public class IHMNbJoueurs extends Observable {

    private JFrame window;
    private JPanel mainPanel, panelTitre, panelBas, panelNombre;
    private JButton btn2J, btn3J, btn4J, btn5J, btn6J;
    private JLabel labTitre, labVide1, labVide2;

    public IHMNbJoueurs() {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(600, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        window.setResizable(false);

        mainPanel = new JPanel(new GridLayout(2, 1));
        //mainPanel.setBackground(new Color(147, 34, 25));
        //mainPanel.setOpaque(true);
        window.add(mainPanel);

        panelTitre = new JPanel(new BorderLayout());
        labTitre = new JLabel("COMBIEN DE JOUEURS ?", SwingConstants.CENTER);
        labTitre.setForeground(Color.WHITE);
        labTitre.setBackground(new Color(147, 34, 25));
        labTitre.setOpaque(true);

        panelTitre.add(labTitre, BorderLayout.CENTER);
        panelTitre.setBackground(new Color(147, 34, 25));
        panelTitre.setOpaque(true);
        mainPanel.add(panelTitre);

        panelBas = new JPanel(new BorderLayout());
        mainPanel.add(panelBas);

        panelNombre = new JPanel(new GridLayout(1, 11));
        panelNombre.setBackground(new Color(212, 47, 34));
        panelNombre.setOpaque(true);

        btn2J = new JButton("2");
        btn2J.setForeground(Color.WHITE);
        btn2J.setBackground(new Color(147, 34, 25));
        btn3J = new JButton("3");
        btn3J.setForeground(Color.WHITE);
        btn3J.setBackground(new Color(147, 34, 25));
        btn4J = new JButton("4");
        btn4J.setForeground(Color.WHITE);
        btn4J.setBackground(new Color(147, 34, 25));
        btn5J = new JButton("5");
        btn5J.setForeground(Color.WHITE);
        btn5J.setBackground(new Color(147, 34, 25));
        btn6J = new JButton("6");
        btn6J.setForeground(Color.WHITE);
        btn6J.setBackground(new Color(147, 34, 25));

        for (int i = 0; i < 11; i++) {
            if (i == 1) {
                panelNombre.add(btn2J);
                btn2J.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.DEUX, 2));
                        
                        clearChanged();
                    }
                });
            } else if (i == 3) {
                panelNombre.add(btn3J);
                btn3J.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.TROIS, 3));
                        clearChanged();
                    }
                });
            } else if (i == 5) {
                panelNombre.add(btn4J);
                btn4J.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.QUATRE, 4));
                        clearChanged();
                    }
                });
            } else if (i == 7) {
                panelNombre.add(btn5J);
                btn5J.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.CINQ, 5));
                        clearChanged();
                    }
                });
            } else if (i == 9) {
                panelNombre.add(btn6J);
                btn6J.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.SIX, 6));
                        clearChanged();
                    }
                });
            } else {
                JLabel l = new JLabel("");
                l.setBackground(new Color(212, 47, 34));
                l.setOpaque(true);
                panelNombre.add(l);
            }
        }

        labVide1 = new JLabel(" ");
        labVide1.setBackground(new Color(212, 47, 34));
        labVide1.setOpaque(true);
        labVide2 = new JLabel(" ");
        labVide2.setBackground(new Color(212, 47, 34));
        labVide2.setOpaque(true);
        panelBas.add(labVide1, BorderLayout.NORTH);
        panelBas.add(panelNombre, BorderLayout.CENTER);
        panelBas.add(labVide2, BorderLayout.SOUTH);

    }

    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }

}
