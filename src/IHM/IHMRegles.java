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
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author beguind
 */
public class IHMRegles extends Observable{
    
    private JFrame window;
    private JButton btnFermer;
    private JPanel mainPanel = new JPanel();
    private JPanel panelBas = new JPanel();
    private JPanel panelImage;
    
    public IHMRegles(){
        
        window = new JFrame();
        window.setTitle("Les règles du jeu");
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(900, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        window.setBackground(new Color(255, 191, 128));
        
        ImageIcon imgFermer = new ImageIcon(System.getProperty("user.dir") + "/src/image/btnFermer.png");
        btnFermer = new JButton(imgFermer);
        btnFermer.setPreferredSize(new Dimension(imgFermer.getIconWidth(), imgFermer.getIconHeight()));
        
        btnFermer.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(new Message(TypeMessages.FERMER_REGLES));
                        clearChanged();
                    }
                });
        
        
        
        
        //IMAGE HAUT
        panelImage = new JPanel(new GridLayout(1,1));
        panelImage.setBackground(new Color(255, 191, 128));
        JLabel image = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/image/reglesmonop.png"));
        panelImage.add(image);
        
        
        //PANEL BOUTON FERMER BAS
        panelBas.setLayout(new GridLayout(3,7));
        panelBas.setBackground(new Color(255, 191, 128));
        panelBas.add(new JLabel(" ")); panelBas.add(new JLabel(" "));panelBas.add(new JLabel(" "));panelBas.add(new JLabel(" ")); panelBas.add(new JLabel(" "));panelBas.add(new JLabel(" "));panelBas.add(new JLabel(" "));
        panelBas.add(new JLabel(" "));panelBas.add(new JLabel(" "));panelBas.add(new JLabel(" ")); panelBas.add(btnFermer);panelBas.add(new JLabel(" ")); panelBas.add(new JLabel(" "));panelBas.add(new JLabel(" "));
        panelBas.add(new JLabel(" "));panelBas.add(new JLabel(" "));panelBas.add(new JLabel(" ")); panelBas.add(new JLabel(" ")); panelBas.add(new JLabel(" "));panelBas.add(new JLabel(" "));panelBas.add(new JLabel(" "));
        
        //PANEL PRINCIPAL
        mainPanel.setLayout(new GridLayout(6,1));
        mainPanel.add(panelImage);
        mainPanel.add(new JLabel(""));
        mainPanel.add(new JLabel(""));
        mainPanel.add(new JLabel(""));
        mainPanel.add(new JLabel(""));
        mainPanel.add(panelBas);
        mainPanel.setBackground(new Color(255, 191, 128));
        window.add(mainPanel);
       
    }
    
//    public void mouseClicked(MouseEvent e) {
//		if (e.getSource()==jtSiteWeb){
//			if(Desktop.isDesktopSupported()){
//				if(Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
//					URI uri;
//					try {
//						uri = new URI("http://"+sql.gp.version.SITEWEB);
//						Desktop.getDesktop().browse(uri);
//					} catch (URISyntaxException arg0) {
//						arg0.printStackTrace();
//					} catch (IOException arg0) {
//						arg0.printStackTrace();
//					}
//				}
//			}
//                            }
//                 }
//    
//    
    
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
    
}
