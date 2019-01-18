/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

/**
 *
 * @author yamin
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    /**
     * @param args
     */
    private Image img;
    private JPanel panelPions, panelMaisons;
    private JLabel labelNbMaisonHotel;
    private PositionCase_enum pos;

    public ImagePanel(ImageIcon img, PositionCase_enum pos, boolean constructible) {
        this.img = img.getImage();
        this.pos = pos;
        panelPions = new JPanel(new GridLayout(2, 3));

        this.add(panelPions);
        if (pos == PositionCase_enum.NORTH || pos == PositionCase_enum.SOUTH) {
            panelPions.setLayout(new GridLayout(2, 3));
            for (int i = 0; i < 6; i++) {
                //panelPions.add(new PionPanel(Color.yellow));
            }
        } else if (pos == PositionCase_enum.WEST || pos == PositionCase_enum.EAST) {
            panelPions.setLayout(new GridLayout(3, 2));
        }

        if (constructible) {

        } else {

        }

    }

    public void addPion(PionPanel pion) {
        PionPanel p = new PionPanel(Color.yellow);
        p = pion;
        panelPions.add(p);
    }

    public void setNbMaisonHotel(int nbMH, boolean hotel) {
        if (hotel) {
            labelNbMaisonHotel.setText("H");
        } else {
            labelNbMaisonHotel.setText(nbMH + "M");
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
