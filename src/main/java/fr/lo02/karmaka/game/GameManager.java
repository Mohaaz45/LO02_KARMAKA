package fr.lo02.karmaka.game;

import fr.lo02.karmaka.game.models.Player;
import fr.lo02.karmaka.game.models.cards.Cards;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final List<Cards> source = new ArrayList<>();
    private Player joueur1;
    private Player joueur2;
    public GameManager() {
        //Arrays.stream(Cards.values()).forEach(cards -> );
        for (Cards card : Cards.values()){
            for (int i=0; i<card.getNumber(); i++){
                this.source.add(card);
            }
        }
    }


}
