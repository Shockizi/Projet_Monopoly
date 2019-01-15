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
            int nbmaison = 0;
            int nbhotel = 0;
            for (int i = 0; i < joueur.getProprietes().size(); i++) {
                nbmaison = nbmaison + joueur.getProprietes().get(i).getNbMaison();
                nbhotel = nbhotel + joueur.getProprietes().get(i).getNbHotel();
            }
            joueur.setCagnotte(joueur.getCagnotte() - nbmaison * 40 - nbhotel * 115);
        } else if (carteChance == Chance_enum.RéparationsMaisons) {
            int nbmaison = 0;
            int nbhotel = 0;
            for (int i = 0; i < joueur.getProprietes().size(); i++) {
                nbmaison = nbmaison + joueur.getProprietes().get(i).getNbMaison();
                nbhotel = nbhotel + joueur.getProprietes().get(i).getNbHotel();
            }
            joueur.setCagnotte(joueur.getCagnotte() - nbmaison * 25 - nbhotel * 100);
        } else if (carteChance == Chance_enum.AmendeExcèsVitesse) {
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
            joueur.setCagnotte(joueur.getCagnotte() - 150);
        } else if (carteChance == Chance_enum.PrixMotsCroisés) {
            joueur.setCagnotte(joueur.getCagnotte() + 100);
        } else if (carteChance == Chance_enum.Dividende) {
            joueur.setCagnotte(joueur.getCagnotte() + 50);
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

        //LIBERE DE PRISON A FAIRE
    }

    public void effeCarteCommunauté(Communauté_enum carteCommunauté, Joueur joueur) {
        if (carteCommunauté == Communauté_enum.AllezEnPrison) {
            CasePrison prison = new CasePrison(11);
            joueur.setPosition(prison);
        } else if (carteCommunauté == Communauté_enum.Amende) {
            joueur.setCagnotte(joueur.getCagnotte() - 150);
        } else if (carteCommunauté == Communauté_enum.Anniversaire) {
            {}//ArrayList de Joueurs, boucle for : pour chaque joueur -10€ sauf pour le joueur qui a tiré la carte qui lui obtient ArrayList<Joueurs>.size() * 10€
        }
        else if (carteCommunauté == Communauté_enum.ErreurBanque) {
            joueur.setCagnotte(joueur.getCagnotte() + 200);
        } else if (carteCommunauté == Communauté_enum.RdvBelleville) {
            CasePrison belleville = new CasePrison(2);
            if (joueur.getPosition().getNumCase() > 2) {
                joueur.setCagnotte(joueur.getCagnotte() + 200);
            }
            joueur.setPosition(belleville);
        } else if (carteCommunauté == Communauté_enum.NoteMedecin) {
            joueur.setCagnotte(joueur.getCagnotte() - 50);
        } else if (carteCommunauté == Communauté_enum.ContributionRemboursent) {
            joueur.setCagnotte(joueur.getCagnotte() + 20);
        } else if (carteCommunauté == Communauté_enum.Hôpital) {
            joueur.setCagnotte(joueur.getCagnotte() - 100);
        } else if (carteCommunauté == Communauté_enum.Héritage) {
            joueur.setCagnotte(joueur.getCagnotte() + 100);
        } else if (carteCommunauté == Communauté_enum.PolicedAssurance) {
            joueur.setCagnotte(joueur.getCagnotte() - 50);
        } else if (carteCommunauté == Communauté_enum.VenteStock) {
            joueur.setCagnotte(joueur.getCagnotte() + 50);
        } else if (carteCommunauté == Communauté_enum.AvancezCaseDépart) {
            CasePrison départ = new CasePrison(1);
            joueur.setPosition(départ);
        } else if (carteCommunauté == Communauté_enum.IntérêtEmprunt) {
            joueur.setCagnotte(joueur.getCagnotte() + 25);
        } else if (carteCommunauté == Communauté_enum.RevenuAnnuel) {
            joueur.setCagnotte(joueur.getCagnotte() + 100);
        } else if (carteCommunauté == Communauté_enum.DeuxièmePrixBeauté) {
            joueur.setCagnotte(joueur.getCagnotte() + 10);
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
