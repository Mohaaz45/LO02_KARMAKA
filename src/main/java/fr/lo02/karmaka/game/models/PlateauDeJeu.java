package fr.lo02.karmaka.game.models;

import fr.lo02.karmaka.game.models.cards.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlateauDeJeu {
    public static List<Cards> source = new ArrayList<>();
    public static  List<Cards> fosse = new ArrayList<>();


    public PlateauDeJeu(){
        for (Cards card : Cards.values()){
            for (int i=0; i<card.getNumber(); i++){
                this.source.add(card);
            }
        }
        Collections.shuffle(this.source);
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

    public void melangerSource(){
        Collections.shuffle(this.source);
    }
}
