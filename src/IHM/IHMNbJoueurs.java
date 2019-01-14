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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author elmiry
 */
public class IHMNbJoueurs {

    private JFrame window;
    private JPanel mainPanel, panelTitre, panelNombre;
    private JButton btn2J, btn3J, btn4J, btn5J, btn6J;

    public IHMNbJoueurs() {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(500, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        window.setResizable(false);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 191, 128));
        mainPanel.setOpaque(true);
        window.add(mainPanel);

        panelTitre = new JPanel();
        panelTitre.add(new JLabel("Combien de joueurs ?", SwingConstants.CENTER));
        mainPanel.add(panelTitre, BorderLayout.NORTH);

        panelNombre = new JPanel(new GridLayout(1, 11));
        btn2J = new JButton("2");
        btn3J = new JButton("3");
        btn4J = new JButton("4");
        btn5J = new JButton("5");
        btn6J = new JButton("6");

        for (int i = 0; i < 11; i++) {
            if (i == 1) {
                panelNombre.add(btn2J);
            } else if (i == 3) {
                panelNombre.add(btn3J);
            } else if (i == 5) {
                panelNombre.add(btn4J);
            } else if (i == 7) {
                panelNombre.add(btn5J);
            } else if (i == 9) {
                panelNombre.add(btn6J);
            } else {
                panelNombre.add(new JLabel(""));
            }
        }

        mainPanel.add(panelNombre);

    }

    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }

}
