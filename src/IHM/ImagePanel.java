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

    private static final long serialVersionUID = 1L;

    /**
     * @param args
     */
    private Image img;
    private JPanel panelPions, panelMaisons;
    private JLabel labelNbMaisonHotel;

    public ImagePanel(ImageIcon img, PositionCase_enum pos, boolean constructible) {
        this.img = img.getImage();
        this.setLayout(new GridBagLayout());
        panelPions = new JPanel();
        labelNbMaisonHotel = new JLabel("TEST");
        labelNbMaisonHotel.setPreferredSize(new Dimension(50, 25));

        GridBagConstraints gbc = new GridBagConstraints();

        if (constructible) {
            if (pos == PositionCase_enum.SOUTH) {

                gbc.gridx = gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                
                this.add(labelNbMaisonHotel);

                gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                panelPions.setLayout(new GridLayout(3, 2));
                this.add(panelPions);

            } else if (pos == PositionCase_enum.NORTH) {
                gbc.gridx = gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                panelPions.setLayout(new GridLayout(3, 2));
                this.add(panelPions);

                gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                this.add(labelNbMaisonHotel);

            } else if (pos == PositionCase_enum.WEST) {
                gbc.gridx = gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                panelPions.setLayout(new GridLayout(2, 3));
                this.add(panelPions);

                gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                this.add(labelNbMaisonHotel);

            }
            if (pos == PositionCase_enum.EAST) {
                gbc.gridx = gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                this.add(labelNbMaisonHotel);

                gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                panelPions.setLayout(new GridLayout(2, 3));
                this.add(panelPions);

            }
        } else {
            this.add(panelPions);
            if (pos == PositionCase_enum.NORTH || pos == PositionCase_enum.SOUTH) {
                panelPions.setLayout(new GridLayout(2, 3));

            } else if (pos == PositionCase_enum.WEST || pos == PositionCase_enum.EAST) {
                panelPions.setLayout(new GridLayout(3, 2));
            }
        }

    }
    
    public void addPion(JLabel pion){
        panelPions.add(pion);
    }
    
    public void setNbMaisonHotel(int nbMH, boolean hotel){
        if (hotel){
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
