package fr.lo02.karmaka.game.models;

import fr.lo02.karmaka.game.models.cards.Card;

import java.util.ArrayList;

public class MainJoueur {
    private ArrayList<Card> main;

    public MainJoueur() {
        this.main = new ArrayList<Card>();
    }

    public void ajouterCarte(Card carte) {
        main.add(carte);
    }

    public void retirerCarte(Card carte) {
        main.remove(carte);
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    // Méthode pour mélanger les cartes dans le deck (si nécessaire)
    public void melangerDeck() {

    }
}
