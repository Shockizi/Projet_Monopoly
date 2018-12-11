/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetmonopoly;

/**
 *
 * @author elmiry
 */
public class ProjetMonopoly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Joueur mathieuLopez = new Joueur("MLopez");
        System.out.println(mathieuLopez.getCagnotte());
        mathieuLopez.setCagnotte(400);
        System.out.println(mathieuLopez.getCagnotte());
        System.out.println(mathieuLopez.getNbGare());
        Gare wc = new Gare("WC", 100, 0);
        System.out.println(mathieuLopez.getPosition());

        
    }

}
