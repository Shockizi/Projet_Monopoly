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
        casesPlat.add(caseDépart);
        Terrain boulevardDeBellevile = new Terrain(Couleur.MARRON, 2, 10, 30, 90, 160, 250, 50, 0, 0, "BoulevardDeBelleville", 60, 2);
        casesPlat.add(boulevardDeBellevile);
        CasesCommunautaires_CartesChance caisseComm1 = new CasesCommunautaires_CartesChance(3);
        casesPlat.add(caisseComm1);
        Terrain rueLecourbe = new Terrain(Couleur.MARRON, 4, 20, 60, 180, 320, 450, 50, 0, 0, "RueLecourbe", 60, 4);
        casesPlat.add(rueLecourbe);
        ImpotsTaxe impôtsRevenue = new ImpotsTaxe(5);
        casesPlat.add(impôtsRevenue);
        Gare gareMontparnasse = new Gare("GareMontparnasse", 200, 6);
        casesPlat.add(gareMontparnasse);
        Terrain rueDeVaugirard = new Terrain(Couleur.BLEU_CIEL, 6, 30, 90, 270, 400, 550, 50, 0, 0, "RueDeVaugirard", 100, 7);
        casesPlat.add(rueDeVaugirard);
        CasesCommunautaires_CartesChance chance1 = new CasesCommunautaires_CartesChance(8);
        casesPlat.add(chance1);
        Terrain rueDeCourcelles = new Terrain(Couleur.BLEU_CIEL, 6, 30, 90, 270, 400, 550, 50, 0, 0, "RueDeCourcelles", 100, 9);
        casesPlat.add(rueDeCourcelles);
        Terrain avenueDeLaRepublique = new Terrain(Couleur.BLEU_CIEL, 8, 40, 100, 300, 450, 600, 50, 0, 0, "AvenueDeLaRépublique", 120, 10);
        casesPlat.add(avenueDeLaRepublique);
        CasePrison prison = new CasePrison(11);
        casesPlat.add(prison);
        Terrain boulevardVillette = new Terrain(Couleur.ROSE, 10, 50, 150, 450, 625, 750, 100, 0, 0, "BoulevardDeLaVillette", 140, 12);
        casesPlat.add(boulevardVillette);
        Compagnie electricité = new Compagnie("CompagnieDeDistributionElectricité", 150, 13);
        casesPlat.add(electricité);
        Terrain avenueNeuilly = new Terrain(Couleur.ROSE, 10, 50, 150, 450, 625, 750, 100, 0, 0, "AvenueDeNeuilly", 140, 14);
        casesPlat.add(avenueNeuilly);
        Terrain rueParadis = new Terrain(Couleur.ROSE, 12, 60, 180, 500, 700, 900, 100, 0, 0, "RueDeParadis", 160, 15);
        casesPlat.add(rueParadis);
        Gare gareLyon = new Gare("GareDeLyon", 200, 16);
        casesPlat.add(gareLyon);
        Terrain avenueMozart = new Terrain(Couleur.ORANGE, 14, 70, 200, 550, 750, 950, 100, 0, 0, "AvenueMozart", 180, 17);
        casesPlat.add(avenueMozart);
        CasesCommunautaires_CartesChance caisseComm2 = new CasesCommunautaires_CartesChance(18);
        casesPlat.add(caisseComm2);
        Terrain boulevardStMichel = new Terrain(Couleur.ORANGE, 14, 70, 200, 550, 750, 950, 100, 0, 0, "BoulevardSaintMichel", 180, 19);
        casesPlat.add(boulevardStMichel);
        Terrain placePigalle = new Terrain(Couleur.ORANGE, 16, 80, 220, 600, 800, 1000, 100, 0, 0, "PlacePigalle", 200, 20);
        casesPlat.add(placePigalle);
        ParcGratuit parcGratuit = new ParcGratuit(21);
        casesPlat.add(parcGratuit);
        Terrain avenueMatignon = new Terrain(Couleur.ROUGE, 18, 90, 250, 700, 875, 1050, 150, 0, 0, "AvenueMatignon", 220, 22);
        casesPlat.add(avenueMatignon);
        CasesCommunautaires_CartesChance chance2 = new CasesCommunautaires_CartesChance(23);
        casesPlat.add(chance2);
        Terrain boulevardMalesherbes = new Terrain(Couleur.ROUGE, 18, 90, 250, 700, 875, 1050, 150, 0, 0, "BoulevardMalesherbes", 220, 24);
        casesPlat.add(boulevardMalesherbes);
        Terrain avenueHenriMartin = new Terrain(Couleur.ROUGE, 20, 100, 300, 750, 925, 1100, 150, 0, 0, "AvenueMatignon", 240, 25);
        casesPlat.add(avenueHenriMartin);
        Gare gareDuNord = new Gare("GareDeLyon", 200, 26);
        casesPlat.add(gareDuNord);
        Terrain faubourgStHonoré = new Terrain(Couleur.JAUNE, 22, 110, 330, 800, 975, 1150, 150, 0, 0, "FaubourgSaintHonoré", 260, 27);
        casesPlat.add(faubourgStHonoré);
        Terrain placeDeLaBourse = new Terrain(Couleur.JAUNE, 22, 110, 330, 800, 975, 1150, 150, 0, 0, "PlaceDeLaBourse", 260, 28);
        casesPlat.add(placeDeLaBourse);
        Compagnie eau = new Compagnie("CompagnieDeDistributionDEau", 150, 29);
        casesPlat.add(eau);
        Terrain rueLaFayette = new Terrain(Couleur.JAUNE, 24, 120, 360, 850, 1025, 1200, 150, 0, 0, "RueLaFayette", 280, 30);
        casesPlat.add(rueLaFayette);
        CaseAllerEnPrison allerEnPrison = new CaseAllerEnPrison(31);
        casesPlat.add(allerEnPrison);
        Terrain avenueDeBreteuil = new Terrain(Couleur.VERT, 26, 130, 390, 900, 1100, 1275, 200, 0, 0, "AvenueDeBreteuil", 300, 32);
        casesPlat.add(avenueDeBreteuil);
        Terrain avenueFoch = new Terrain(Couleur.VERT, 26, 130, 390, 900, 1100, 1275, 200, 0, 0, "AvenueFoch", 300, 33);
        casesPlat.add(avenueFoch);
        CasesCommunautaires_CartesChance caisseComm3 = new CasesCommunautaires_CartesChance(34);
        casesPlat.add(caisseComm3);
        Terrain boulevardCapucines = new Terrain(Couleur.BLEU_FONCE, 28, 150, 450, 1000, 1200, 1400, 200, 0, 0, "BoulevardDesCapucines", 320, 35);
        casesPlat.add(boulevardCapucines);
        Gare gareStLazare = new Gare("GareSaintLazare", 200, 36);
        casesPlat.add(gareStLazare);
        CasesCommunautaires_CartesChance chance3 = new CasesCommunautaires_CartesChance(37);
        casesPlat.add(chance3);
        Terrain avenueChampsElysées = new Terrain(Couleur.BLEU_FONCE, 35, 175, 500, 1100, 1300, 1500, 200, 0, 0, "AvenueChampsElysées", 350, 38);
        casesPlat.add(avenueChampsElysées);
        ImpotsTaxe taxeLuxe = new ImpotsTaxe(39);
        casesPlat.add(taxeLuxe);
        Terrain rueDeLaPaix = new Terrain(Couleur.BLEU_FONCE, 50, 200, 600, 1400, 1700, 2000, 200, 0, 0, "RueDeLaPaix", 400, 40);
        casesPlat.add(rueDeLaPaix);
    }

    public void addJoueur(Joueur j) {
        joueurs.add(j);
    }
    
    public void addCasePlat(CasePlateau caseCourante) {
        casesPlat.add(caseCourante);
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public ArrayList<CasePlateau> getCasesPlat() {
        return casesPlat;
    }

    public void setCasesPlat(ArrayList<CasePlateau> casesPlat) {
        this.casesPlat = casesPlat;
    }
    
    public String getNomCase(int numCase){
        String nc = "";
        for (CasePlateau cp : casesPlat){
            if (numCase == cp.getNumCase()){
                nc = cp.getNom();
            }
        }
        return nc;
    }
    
}
