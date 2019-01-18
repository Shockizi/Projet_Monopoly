/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author yamin
 */
public class PionPanel extends JPanel {

    private Color color;

    public PionPanel(Color color) {
        this.color = color;
        setBackground(Color.white);
        setDoubleBuffered(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(0, 0, 10, 10);
        g.setColor(color);
        g.fillOval(0, 0, 10, 10);

    }

}
