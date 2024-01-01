package fr.lo02.karmaka.game.models;

import fr.lo02.karmaka.game.GameManager;
import fr.lo02.karmaka.game.models.cards.Cards;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String nom;
    private int niveau;
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

    public int getNiveau() {
        return this.niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public List<Cards> getMain() {
        return main;
    }

    public void setMain(List<Cards> main) {
        this.main = main;
    }

    public List<Cards> getPile() {
        return pile;
    }

    public void setPile(List<Cards> pile) {
        this.pile = pile;
    }

    public List<Cards> getOeuvres() {
        return oeuvres;
    }

    public void setOeuvres(List<Cards> oeuvres) {
        this.oeuvres = oeuvres;
    }

    public List<Cards> getVieFuture() {
        return vieFuture;
    }

    public void setVieFuture(List<Cards> vieFuture) {
        this.vieFuture = vieFuture;
    }

    public int getAnneauxJoueur() {
        return anneauxJoueur;
    }

    public void setAnneauxJoueur(int anneauxJoueur) {
        this.anneauxJoueur = anneauxJoueur;
    }

    public Player(String nom){
        this.nom = nom;
        this.niveau = 0;
       // this.main = new ArrayList<Cards>();
        // this.pile = new ArrayList<Cards>();
        this.main.addAll(PlateauDeJeu.source.subList(0, 5));
        this.pile.addAll(PlateauDeJeu.source.subList(0, 2));
        this.anneauxJoueur = 6;
    }

    public void piocherCarte(List<Cards> pileDeCarte){
        //main.add(pileDeCarte.get(0));
        main.addAll(pileDeCarte.subList(0, 1));
        pileDeCarte.subList(0, 1).clear();
    }
    public void poserCarte(Cards card, List<Cards> pileDeCarte){
        pileDeCarte.add(card);
    }

    public void jouerFutur(Cards card){
        //this.vieFuture.add(card);
        poserCarte(card, vieFuture);
    }
    public void jouerPoints(Cards card){
        //this.oeuvres.add(card);
        poserCarte(card, oeuvres);
    }
    public void jouerPouvoir(Cards card){
        card.getDescription();
        card.onPlayed();
    }

    public void evolutionKarmique(Color color, int nbAnneaux){
        int pointReincarnation = 0;
        for (Cards card : oeuvres){
            if (card.getColor() = color){
                pointReincarnation += card.getPoints();
            }
        }
        this.anneauxJoueur -= nbAnneaux;
        pointReincarnation += nbAnneaux;
        if (pointReincarnation < 4){
            System.out.println("Dommage, vous n'avez pas assez de points pour évoluer sur l'échelle karmique...");
        } else if (pointReincarnation == 4) {
            setNiveau(pointReincarnation);
            System.out.println("Félicitations, vous vous êtes réincarné en bousier");
        } else if (pointReincarnation == 5) {
            setNiveau(pointReincarnation);
            System.out.println("Félicitations, vous vous êtes réincarné en serpent");
        } else if (pointReincarnation == 6) {
            setNiveau(pointReincarnation);
            System.out.println("Félicitations, vous vous êtes réincarné en loup");
        } else if (pointReincarnation == 7) {
            setNiveau(pointReincarnation);
            System.out.println("Félicitations, vous vous êtes réincarné en singe");
        }else {
            setNiveau(pointReincarnation);
            System.out.println("Félicitations, vous avez atteint la transcendance");
        }
    }
    public void seRéincarner(){
        for (Cards card : oeuvres){
            PlateauDeJeu.defausserCarte(card);
        }
        for (Cards card : vieFuture){
            main.add(card);
        }
        while ((main.size() + pile.size()) < 6){
            //pile.add(PlateauDeJeu.source(0));
            pile.addAll(PlateauDeJeu.source.subList(0, 1));
            PlateauDeJeu.source.subList(0, 1).clear();
        }
    }


}
