/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author lorauxs
 */
public enum Terrains_enum {
    BoulevardDeBelleville(60,2,"Rose"),
    RueLecourbe(60,4,"Rose"),
    RueDeVaugirard(100,7,"BleuClair"),
    RueDeCourcelles(100,9,"BleuClair"),
    AvenueDeLaRépublique(120,10,"BleuClair"),
    BoulevardDeLaVillette(140,12,"Violet"),
    AvenueDeNeuilly(140,14,"Violet"),
    RueDeParadis(160,15,"Violet"),
    AvenueMozart(180,17,"Orange"),
    BoulevardSaintMichel(180,19,"Orange"),
    PlacePigalle(200,20,"Orange"),
    AvenueMatignon(220,22,"Rouge"),
    BoulevardMalesherbes(220,24,"Rouge"),
    AvenueHenriMartin(240,25,"Rouge"),
    FaubourgSaintHonoré(260,27,"Jaune"),
    PlaceDeLaBourse(260,29,"Jaune"),
    RueLaFayette(280,30,"Jaune"),
    AvenueDeBreteuil(300,32,"Vert"),
    AvenueFoch(300,33,"Vert"),
    BoulevardDesCapucines(320,35,"Vert"),
    AvenueChampsElysées(350,38,"BleuMarine"),
    RueDeLaPaix(400,40,"BleuMarine");
   
    private  int prix;
    private  int numCase;
    private String couleur;

    private Terrains_enum(int prix, int numCase, String couleur) {
        this.prix = prix;
        this.numCase = numCase;
        this.couleur = couleur;
    }
    
    
    
    
    
    
}
