package fr.lo02.karmaka.game.models;

import fr.lo02.karmaka.game.models.cards.Card;

import java.util.ArrayList;

public class Player {
    private String nom;
    private String niveau;
    private ArrayList<Card> main;
    private ArrayList<Card> pile;

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
        this.main = new ArrayList<Card>();
        this.pile = new ArrayList<Card>();
    }

    public void AjouterCarteMain(){

    }
}
