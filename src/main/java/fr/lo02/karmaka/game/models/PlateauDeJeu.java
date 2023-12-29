package fr.lo02.karmaka.game.models;

import fr.lo02.karmaka.game.models.cards.Cards;

import java.util.ArrayList;
import java.util.List;

public class PlateauDeJeu {
    private final List<Cards> source = new ArrayList<>();
    private List<Cards> fosse = new ArrayList<>();
    private int anneauxKarmiques;

    public PlateauDeJeu(){
        for (Cards card : Cards.values()){
            for (int i=0; i<card.getNumber(); i++){
                this.source.add(card);
            }
        }
        this.anneauxKarmiques = 12;
    }
    public List<Cards> getSource(){
        return this.source;
    }
    public List<Cards> getFosse(){
        return this.fosse;
    }

    public void defausserCarte(Cards card){
        this.fosse.add(card);
    }
    public Cards piocherCarte(){
        this.source.remove(0);
    }
    public void prendreAnneaux(int nbAnneau){
        this.anneauxKarmiques -= nbAnneau;
    }
}
