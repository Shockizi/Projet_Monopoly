/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.ArrayList;

/**
 *
 * @author elmiry
 */
public class Plateau {

    private ArrayList<Joueur> joueurs;
    private ArrayList<CasePlateau> casesPlat;

    public Plateau() {
        joueurs = new ArrayList<>();
        casesPlat = new ArrayList<>();
    }

    public void resetPlateau() {
        CaseDépart caseDépart = new CaseDépart(1);
        Terrain boulevardDeBellevile = new Terrain(Couleur.MARRON, 2, 10, 30, 90, 160, 250, 50, 0, 0, Terrains_enum.BoulevardDeBelleville, 60, 2);
        CasesCommunautaires_CartesChance caisseComm1 = new CasesCommunautaires_CartesChance(3);
        Terrain rueLecourbe = new Terrain(Couleur.MARRON, 4, 20, 60, 180, 320, 450, 50, 0, 0, Terrains_enum.RueLecourbe, 60, 4);
        ImpotsTaxe impôtsRevenue = new ImpotsTaxe(5);
        Gare gareMontparnasse = new Gare(Gares_enum.GareMontparnasse, 200, 6);
        Terrain rueDeVaugirard = new Terrain(Couleur.BLEU_CIEL, 6, 30, 90, 270, 400, 550, 50, 0, 0, Terrains_enum.RueDeVaugirard, 100, 7);
        CasesCommunautaires_CartesChance chance1 = new CasesCommunautaires_CartesChance(8);
        Terrain rueDeCourcelles = new Terrain(Couleur.BLEU_CIEL, 6, 30, 90, 270, 400, 550, 50, 0, 0, Terrains_enum.RueDeCourcelles, 100, 9);
        Terrain avenueDeLaRepublique = new Terrain(Couleur.BLEU_CIEL, 8, 40, 100, 300, 450, 600, 50, 0, 0, Terrains_enum.AvenueDeLaRépublique, 120, 10);
        CasePrison prison = new CasePrison(11);
        Terrain boulevardVillette = new Terrain(Couleur.ROSE, 10, 50, 150, 450, 625, 750, 100, 0, 0, Terrains_enum.BoulevardDeLaVillette, 140, 12);
        Compagnie electricité = new Compagnie(Compagnie_enum.CompagnieDeDistributionElectricité, 150, 13);
        Terrain avenueNeuilly = new Terrain(Couleur.ROSE, 10, 50, 150, 450, 625, 750, 100, 0, 0, Terrains_enum.AvenueDeNeuilly, 140, 14);
        Terrain rueParadis = new Terrain(Couleur.ROSE, 12, 60, 180, 500, 700, 900, 100, 0, 0, Terrains_enum.RueDeParadis, 160, 15);
        Gare gareLyon = new Gare(Gares_enum.GareDeLyon, 200, 16);
        Terrain avenueMozart = new Terrain(Couleur.ORANGE, 14, 70, 200, 550, 750, 950, 100, 0, 0, Terrains_enum.AvenueMozart, 180, 17);
        CasesCommunautaires_CartesChance caisseComm2 = new CasesCommunautaires_CartesChance(18);
        Terrain boulevardStMichel = new Terrain(Couleur.ORANGE, 14, 70, 200, 550, 750, 950, 100, 0, 0, Terrains_enum.BoulevardSaintMichel, 180, 19);
        Terrain placePigalle = new Terrain(Couleur.ORANGE, 16, 80, 220, 600, 800, 1000, 100, 0, 0, Terrains_enum.PlacePigalle, 200, 20);
        ParcGratuit parcGratuit = new ParcGratuit(21);
        Terrain avenueMatignon = new Terrain(Couleur.ROUGE, 18, 90, 250, 700, 875, 1050, 150, 0, 0, Terrains_enum.AvenueMatignon, 220, 22);
        CasesCommunautaires_CartesChance chance2 = new CasesCommunautaires_CartesChance(23);
        Terrain boulevardMalesherbes = new Terrain(Couleur.ROUGE, 18, 90, 250, 700, 875, 1050, 150, 0, 0, Terrains_enum.BoulevardMalesherbes, 220, 24);
        Terrain avenueHenriMartin = new Terrain(Couleur.ROUGE, 20, 100, 300, 750, 925, 1100, 150, 0, 0, Terrains_enum.AvenueMatignon, 240, 25);
        Gare gareDuNord = new Gare(Gares_enum.GareDeLyon, 200, 26);
        Terrain faubourgStHonoré = new Terrain(Couleur.JAUNE, 22, 110, 330, 800, 975, 1150, 150, 0, 0, Terrains_enum.FaubourgSaintHonoré, 260, 27);
        Terrain placeDeLaBourse = new Terrain(Couleur.JAUNE, 22, 110, 330, 800, 975, 1150, 150, 0, 0, Terrains_enum.PlaceDeLaBourse, 260, 28);
        Compagnie eau = new Compagnie(Compagnie_enum.CompagnieDeDistributionDEau, 150, 29);
        Terrain rueLaFayette = new Terrain(Couleur.JAUNE, 24, 120, 360, 850, 1025, 1200, 150, 0, 0, Terrains_enum.RueLaFayette, 280, 30);
        CaseAllerEnPrison allerEnPrison = new CaseAllerEnPrison(31);
        Terrain avenueDeBreteuil = new Terrain(Couleur.VERT, 26, 130, 390, 900, 1100, 1275, 200, 0, 0, Terrains_enum.AvenueDeBreteuil, 300, 32);
        Terrain avenueFoch = new Terrain(Couleur.VERT, 26, 130, 390, 900, 1100, 1275, 200, 0, 0, Terrains_enum.AvenueFoch, 300, 33);
        CasesCommunautaires_CartesChance caisseComm3 = new CasesCommunautaires_CartesChance(34);
        Terrain boulevardCapucines = new Terrain(Couleur.BLEU_FONCE, 28, 150, 450, 1000, 1200, 1400, 200, 0, 0, Terrains_enum.BoulevardDesCapucines, 320, 35);
        Gare gareStLazare = new Gare(Gares_enum.GareSaintLazare, 200, 36);
        CasesCommunautaires_CartesChance chance3 = new CasesCommunautaires_CartesChance(37);
        Terrain avenueChampsElysées = new Terrain(Couleur.BLEU_FONCE, 35, 175, 500, 1100, 1300, 1500, 200, 0, 0, Terrains_enum.AvenueChampsElysées, 350, 38);
        ImpotsTaxe taxeLuxe = new ImpotsTaxe(39);
        Terrain rueDeLaPaix = new Terrain(Couleur.BLEU_FONCE, 50, 200, 600, 1400, 1700, 2000, 200, 0, 0, Terrains_enum.RueDeLaPaix, 400, 40);
    }

    public void addJoueur(Joueur j) {
        joueurs.add(j);
    }
}
