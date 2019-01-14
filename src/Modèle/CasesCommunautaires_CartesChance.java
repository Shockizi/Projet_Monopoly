/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.ArrayList;

/**
 *
 * @author lorauxs
 */
public class CasesCommunautaires_CartesChance extends CasePlateau {

    private ArrayList<Chance_enum> deckChance;
    private Chance_enum carteChance;
    private ArrayList<Communauté_enum> deckCommunauté;
    private Communauté_enum carteCommunauté;
    private int aléatoire = 0;

    public CasesCommunautaires_CartesChance(int numCase) {
        super(numCase);
        this.deckChance = deckChance;
        this.deckCommunauté = deckCommunauté;
        this.carteChance = carteChance;
        this.carteCommunauté = carteCommunauté;
    }

    public ArrayList<Chance_enum> getDeckChance() {
        return deckChance;
    }

    public void setDeckChance(ArrayList<Chance_enum> deckChance) {
        this.deckChance = deckChance;
    }

    public ArrayList<Communauté_enum> getDeckCommunauté() {
        return deckCommunauté;
    }

    public void setDeckCommunauté(ArrayList<Communauté_enum> deckCommunauté) {
        this.deckCommunauté = deckCommunauté;
    }

    public Chance_enum getCarteChance() {
        return carteChance;
    }

    public void setCarteChance(Chance_enum carteChance) {
        this.carteChance = carteChance;
    }

    public Communauté_enum getCarteCommunauté() {
        return carteCommunauté;
    }

    public void setCarteCommunauté(Communauté_enum carteCommunauté) {
        this.carteCommunauté = carteCommunauté;
    }

    public int getAléatoire() {
        return aléatoire;
    }

    public void setAléatoire(int aléatoire) {
        this.aléatoire = aléatoire;
    }

    public Chance_enum tirerCarteChance() {
        this.setAléatoire((int) (Math.random() * (this.getDeckChance().size() - 1)));
        return this.getDeckChance().get(aléatoire);
    }

    public Communauté_enum tirerCarteCommunauté() {
        this.setAléatoire((int) (Math.random() * (this.getDeckCommunauté().size() - 1)));
        return this.getDeckCommunauté().get(aléatoire);
    }

    public void effetCarteChance(Chance_enum carteChance, Joueur joueur) {
        if (carteChance == Chance_enum.AllezEnPrison) {
            CasePrison prison = new CasePrison(11);
            joueur.setPosition(prison);
        } else if (carteChance == Chance_enum.ReculezDeTroisCases) {
            CasePrison caseJ = new CasePrison(joueur.getPosition().getNumCase() - 3);
            joueur.setPosition(caseJ);
        } else if (carteChance == Chance_enum.ImpôtsRéparationVoirie) {
            joueur.setCagnotte(joueur.getCagnotte());
        } //à finir quand on poura compter les maisons/hôtels d'un joueur
        else if (carteChance == Chance_enum.RéparationsMaisons) {
            joueur.setCagnotte(joueur.getCagnotte());
        } //à finir quand on poura compter les maisons/hôtels d'un joueur
        else if (carteChance == Chance_enum.AmendeExcèsVitesse) {
            joueur.setCagnotte(joueur.getCagnotte() - 15);
        } else if (carteChance == Chance_enum.AmendeIvresse) {
            joueur.setCagnotte(joueur.getCagnotte() - 20);
        } else if (carteChance == Chance_enum.AvancezCaseDépart) {
            CasePrison départ = new CasePrison(1);
            joueur.setPosition(départ);
        } else if (carteChance == Chance_enum.RdvAveHenriMartin) {
            CasePrison avenue = new CasePrison(25);
            if (joueur.getPosition().getNumCase() > 25) {
                joueur.setCagnotte(joueur.getCagnotte() + 200);
            }
            joueur.setPosition(avenue);
        } else if (carteChance == Chance_enum.RdvGareLyon) {
            CasePrison gareLyon = new CasePrison(16);
            if (joueur.getPosition().getNumCase() > 16) {
                joueur.setCagnotte(joueur.getCagnotte() + 200);
            }
            joueur.setPosition(gareLyon);
        } else if (carteChance == Chance_enum.FraisScolarité) {
            joueur.setCagnotte(this.getProprietaire().getCagnotte() - 150);
        } else if (carteChance == Chance_enum.PrixMotsCroisés) {
            joueur.setCagnotte(joueur.getCagnotte() + 100);
        } else if (carteChance == Chance_enum.RdvRueDelaPaix) {
            CasePrison ruePaix = new CasePrison(40);
            if (joueur.getPosition().getNumCase() > 40) {
                joueur.setCagnotte(joueur.getCagnotte() + 200);
            }
            joueur.setPosition(ruePaix);
        } else if (carteChance == Chance_enum.ImmeubleEtPrêtRapportent) {
            joueur.setCagnotte(joueur.getCagnotte() + 150);
        } else if (carteChance == Chance_enum.RdvBoulevardVillette) {
            CasePrison boulevard = new CasePrison(12);
            if (joueur.getPosition().getNumCase() > 12) {
                joueur.setCagnotte(joueur.getCagnotte() + 200);
            }
            joueur.setPosition(boulevard);
        }
    }

    public Joueur getProprietaire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Action> getActionPossible(Joueur j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
