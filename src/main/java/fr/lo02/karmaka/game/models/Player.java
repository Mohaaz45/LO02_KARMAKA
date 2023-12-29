package fr.lo02.karmaka.game.models;

import fr.lo02.karmaka.game.GameManager;
import fr.lo02.karmaka.game.models.cards.Cards;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String nom;
    private String niveau;
    private List<Cards> main;
    private List<Cards> pile;
    private List<Cards> vieFuture;
    private List<Cards> oeuvres;
    private int anneauxJoueur;

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNiveau() {
        return this.niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public ArrayList<Card> getMain() {
        return this.main;
    }

    public void setMain(ArrayList<Card> main) {
        this.main = main;
    }

    public ArrayList<Card> getPile() {
        return this.pile;
    }

    public void setPile(ArrayList<Card> pile) {
        this.pile = pile;
    }

    public Player(String nom, String niveau){
        this.nom = nom;
        this.niveau = niveau;
       // this.main = new ArrayList<Cards>();
        // this.pile = new ArrayList<Cards>();
        this.main.addAll(PlateauDeJeu.source.subList(0, 5));
        this.pile.addAll(PlateauDeJeu.source.subList(0, 2));
    }

    public Cards piocherCarte(List<Cards> pileDeCarte){

    }
    public void poserCarte(Cards card, List<Cards> pileDeCarte){

    }

    public void jouerFutur(Cards card){
        this.vieFuture.add(card);
    }
    public void jouerPoints(){

    }
    public void jouerOeuvres(){

    }


}
