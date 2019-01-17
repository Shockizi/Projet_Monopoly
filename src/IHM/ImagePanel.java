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
import java.awt.Graphics;
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
     
    public ImagePanel(ImageIcon img){
        this.img = img.getImage();
    }
     
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
