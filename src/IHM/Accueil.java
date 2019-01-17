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

/**
 *
 * @author elmiry
 */
public class Accueil extends Observable{
    
    private JFrame window;
    private JPanel mainPanel, panelBoutons, panelImage;
    private JButton btnJouer, btnRegles, btnQuitter;
    
    public Accueil() {
        window = new JFrame();
        window.setTitle("Accueil Jeu : Monopoly ");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(900, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 191, 128));
        mainPanel.setOpaque(true);
        window.add(mainPanel);
        
        //Image
        
        panelImage = new JPanel(new BorderLayout());
        panelImage.setBackground(new Color(255, 191, 128));
        JLabel image = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/image/logoAccueil.png"));
        panelImage.add(image);
        mainPanel.add(panelImage, BorderLayout.NORTH);
         
        panelBoutons = new JPanel(new GridLayout(7, 3));
        panelBoutons.setBackground(new Color(255, 191, 128));
        mainPanel.add(panelBoutons, BorderLayout.CENTER);
        
        ImageIcon imgJouer = new ImageIcon(System.getProperty("user.dir") + "/src/image/btnJouer.png");
        ImageIcon imgRegles = new ImageIcon(System.getProperty("user.dir") + "/src/image/btnRegles.png");
        ImageIcon imgQuitter = new ImageIcon(System.getProperty("user.dir") + "/src/image/btnQuitter.png");
        
        btnJouer = new JButton(imgJouer);
        btnJouer.setPreferredSize(new Dimension(imgJouer.getIconWidth(), imgJouer.getIconHeight()));
        
        btnRegles = new JButton(imgRegles);
        //btnRegles.setBorderPainted(false);
        
        
        btnQuitter = new JButton(imgQuitter);
        //btnQuitter.setBorderPainted(false);
        
        for (int i = 1; i <= 21; i++) {
            if (i == 5) {
                panelBoutons.add(btnJouer);
                btnJouer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.JOUER_PARTIE));
                        clearChanged();
                    }
                });
            } else if (i == 11) {
                panelBoutons.add(btnRegles);
                btnRegles.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                        Desktop.getDesktop().browse(new URI("https://www.regles-de-jeux.com/regle-du-monopoly/"));
                    }
                });
            } else if (i == 17) {
                panelBoutons.add(btnQuitter);
                btnQuitter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        window.dispose();
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
    
//    @Override
//    public synchronized void addObserver(Observer o) {
//        System.out.println("IHM.Accueil.addObserver():: ajout d'un observateur");
//        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
    
}
