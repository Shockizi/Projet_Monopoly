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
            this.getProprietaire().setPosition(this);   //à modifier quand classe case_prison sera faite
        };
    }

    @Override
    public Joueur getProprietaire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
