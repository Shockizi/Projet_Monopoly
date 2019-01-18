/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import Controleur.Controleur;
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
            joueur.setPosition(31); //prison
        } else if (carteChance == Chance_enum.ReculezDeTroisCases) {
            joueur.setPosition(joueur.getNumCaseCourante() - 3);
        } else if (carteChance == Chance_enum.ImpôtsRéparationVoirie) {
            int nbmaison = 0;
            int nbhotel = 0;
            for (int i = 0; i < joueur.getProprietes().size(); i++) {
                for (Propriete p : joueur.getProprietes()) {
                    if (p instanceof Terrain) {
                        nbmaison = nbmaison + ((Terrain) p).getNbMaison();
                        nbhotel = nbhotel + ((Terrain) p).getNbHotel();
                    }
                }
            }
            joueur.setCagnotte(joueur.getCagnotte() - nbmaison * 40 - nbhotel * 115);
        } else if (carteChance == Chance_enum.RéparationsMaisons) {
            int nbmaison = 0;
            int nbhotel = 0;
            for (Propriete p : joueur.getProprietes()) {
                if (p instanceof Terrain) {
                    nbmaison = nbmaison + ((Terrain) p).getNbMaison();
                    nbhotel = nbhotel + ((Terrain) p).getNbHotel();
                }

            }
            joueur.setCagnotte(joueur.getCagnotte() - nbmaison * 25 - nbhotel * 100);
        } else if (carteChance == Chance_enum.AmendeExcèsVitesse) {
            joueur.setCagnotte(joueur.getCagnotte() - 15);
        } else if (carteChance == Chance_enum.AmendeIvresse) {
            joueur.setCagnotte(joueur.getCagnotte() - 20);
        } else if (carteChance == Chance_enum.AvancezCaseDépart) {
            joueur.setPosition(1);
        } else if (carteChance == Chance_enum.RdvAveHenriMartin) {
            if (joueur.getNumCaseCourante() > 25) {
                joueur.setCagnotte(joueur.getCagnotte() + 200);
            }
            joueur.setPosition(25);
        } else if (carteChance == Chance_enum.RdvGareLyon) {
            if (joueur.getNumCaseCourante() > 16) {
                joueur.setCagnotte(joueur.getCagnotte() + 200);
            }
            joueur.setPosition(16);
        } else if (carteChance == Chance_enum.FraisScolarité) {
            joueur.setCagnotte(joueur.getCagnotte() - 150);
        } else if (carteChance == Chance_enum.PrixMotsCroisés) {
            joueur.setCagnotte(joueur.getCagnotte() + 100);
        } else if (carteChance == Chance_enum.Dividende) {
            joueur.setCagnotte(joueur.getCagnotte() + 50);
        } else if (carteChance == Chance_enum.RdvRueDelaPaix) {
            Terrain ruePaix = new Terrain(40);
            if (joueur.getNumCaseCourante() > 40) {
                joueur.setCagnotte(joueur.getCagnotte() + 200);
            }
            joueur.setPosition(40);
        } else if (carteChance == Chance_enum.ImmeubleEtPrêtRapportent) {
            joueur.setCagnotte(joueur.getCagnotte() + 150);
        } else if (carteChance == Chance_enum.RdvBoulevardVillette) {
            if (joueur.getNumCaseCourante() > 12) {
                joueur.setCagnotte(joueur.getCagnotte() + 200);
            }
            joueur.setPosition(12);
        } else if (carteChance == Chance_enum.LibéréDePrison) {
            joueur.setCarteLiberéDePrison(joueur.getCarteLiberéDePrison() + 1);
        }

    }

    public void effeCarteCommunauté(Communauté_enum carteCommunauté, Joueur joueur) {
        if (carteCommunauté == Communauté_enum.AllezEnPrison) {
            joueur.setPosition(11);
        } else if (carteCommunauté == Communauté_enum.Amende) {
            joueur.setCagnotte(joueur.getCagnotte() - 150);
        } else if (carteCommunauté == Communauté_enum.Anniversaire) {
            {
                Controleur c1 = new Controleur();
                for (int i = 0; i < c1.getJoueurs().size(); i++) {
                    c1.getJoueurs().get(i).setCagnotte(c1.getJoueurs().get(i).getCagnotte() - 10);
                }
                joueur.setCagnotte(joueur.getCagnotte() + c1.getJoueurs().size() * 10);
            }//Tous les joueurs : -10€ (y compris celui qui a tiré la carte) et ensuite ce dernier reçois 10€ * nbJoueurs(le comptant)
        } else if (carteCommunauté == Communauté_enum.ErreurBanque) {
            joueur.setCagnotte(joueur.getCagnotte() + 200);
        } else if (carteCommunauté == Communauté_enum.RdvBelleville) {
            if (joueur.getNumCaseCourante() > 2) {
                joueur.setCagnotte(joueur.getCagnotte() + 200);
            }
            joueur.setPosition(2);
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
            joueur.setPosition(1);
        } else if (carteCommunauté == Communauté_enum.IntérêtEmprunt) {
            joueur.setCagnotte(joueur.getCagnotte() + 25);
        } else if (carteCommunauté == Communauté_enum.RevenuAnnuel) {
            joueur.setCagnotte(joueur.getCagnotte() + 100);
        } else if (carteCommunauté == Communauté_enum.DeuxièmePrixBeauté) {
            joueur.setCagnotte(joueur.getCagnotte() + 10);
        } else if (carteCommunauté == Communauté_enum.LibéréDePrison) {
            joueur.setCarteLiberéDePrison(joueur.getCarteLiberéDePrison() + 1);
        }
    }

    @Override
    public ArrayList<Action> getActionPossible(Joueur j) {
        ArrayList<Action> actionsPossibes = new ArrayList<>();
        actionsPossibes.add(Action.DEPLACER);
        return actionsPossibes;
    }

    @Override
    public String getNom() {
        String s = null;
        if (getNumCase() == 3) {
            s = "Caisse de communauté 1";
        } else if (getNumCase() == 8) {
            s = "Chance 1";
        } else if (getNumCase() == 18) {
            s = "Caisse de communauté 2";
        } else if (getNumCase() == 23) {
            s = "Chance 2";
        } else if (getNumCase() == 34) {
            s = "Caisse de communauté 3";
        } else if (getNumCase() == 37) {
            s = "Chance 3";
        }

        return s;
    }

}
