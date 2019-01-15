/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.SwingConstants;

/**
 *
 * @author elmiry
 */
public class Accueil extends Observable{
    
    private JFrame window;
    private JPanel mainPanel, panelBoutons, panelImage, panelbas;
    private JButton btnJouer, btnRegles, btnQuitter;
    private Font font;
    
    public Accueil() {
        window = new JFrame();
        window.setTitle("Accueil Jeu : Monopoly ");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(1000, 1050);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        window.setBackground(new Color(255, 191, 128));
        mainPanel = new JPanel(new GridLayout(4, 1));
        mainPanel.setBackground(new Color(255, 191, 128));
        mainPanel.setOpaque(true);
        window.add(mainPanel);
        
        //Image
        
        panelImage = new JPanel(new BorderLayout());
        panelImage.setBackground(new Color(255, 191, 128));
        JLabel image = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/image/imageAccueil.jpeg"));
        panelImage.add(image);
        mainPanel.add(panelImage, BorderLayout.CENTER);
        
        //Boutons
//        panelbas = new JPanel(new BorderLayout());
//        mainPanel.add(panelbas);
//        panelbas.setBackground(new Color(255, 191, 128));
         
        font = new Font("Arial",Font.BOLD,20);
        panelBoutons = new JPanel(new GridLayout(6, 3));
        mainPanel.add(panelBoutons, BorderLayout.SOUTH);
        
        btnJouer = new JButton("JOUER");
        btnJouer.setFont(font);
        btnJouer.setForeground(Color.WHITE);
        btnJouer.setBackground(new Color(147, 34, 25));
        btnJouer.setBorderPainted(false);
        
        btnRegles = new JButton("RÈGLES");
        btnRegles.setForeground(Color.WHITE);
        btnRegles.setBackground(new Color(147, 34, 25));
        btnRegles.setFont(font);
        btnRegles.setBorderPainted(false);
        
        btnQuitter = new JButton("QUITTER");
        btnQuitter.setFont(font);
        btnQuitter.setForeground(Color.WHITE);
        btnQuitter.setBackground(new Color(147, 34, 25));
        btnQuitter.setBorderPainted(false);
        
        for (int i = 1; i <= 18; i++) {
            if (i == 5) {
                panelBoutons.add(btnJouer);
                btnJouer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers();
                        clearChanged();
                    }
                });
            } else if (i == 11) {
                panelBoutons.add(btnRegles);
                btnRegles.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers();
                        clearChanged();
                    }
                });
            } else if (i == 17) {
                panelBoutons.add(btnQuitter);
                btnQuitter.addActionListener(new ActionListener() {
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
                panelBoutons.add(l);
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
