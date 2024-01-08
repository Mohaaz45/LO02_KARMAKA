package fr.lo02.karmaka.game.models;

import fr.lo02.karmaka.game.GameManager;
import fr.lo02.karmaka.game.models.cards.Cards;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    public String nom;
    public int niveau;
    public List<Cards> main;
    public List<Cards> pile;
    public List<Cards> vieFuture;
    public List<Cards> oeuvres;
    public int anneauxJoueur;

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
        this.main = new ArrayList<>();
        this.pile = new ArrayList<>();
        this.vieFuture = new ArrayList<>();
        this.oeuvres = new ArrayList<>();
        this.anneauxJoueur = 6;

    }


    public void distribuerCarte(){
        this.main.addAll(PlateauDeJeu.source.subList(0, 5));
        this.pile.addAll(PlateauDeJeu.source.subList(0, 2));
    }
    public String piocherCarte(List<Cards> pileDeCarte) {
        // Vérifier s'il reste suffisamment de cartes dans la pile
        if (pileDeCarte.size() >= 1) {
            main.addAll(pileDeCarte.subList(0, 1));
            pileDeCarte.subList(0, 1).clear();
            return "Carte piochée avec succès.";
        } else {
            return "La pile de cartes est vide. Impossible de piocher.";
        }
    }

    public void poserCarte(Cards card, List<Cards> pileDeCarte){
        pileDeCarte.add(card);
        main.remove(card);
    }

    public void jouerFutur(Cards card){
        //this.vieFuture.add(card);
        poserCarte(card, vieFuture);
    }
    public void jouerPoints(Cards card){
        //this.oeuvres.add(card);
        poserCarte(card, oeuvres);
    }
    public void jouerPouvoir(GameManager gameManager, Player player, Player rival , Cards card ){
        card.onPlayed(gameManager, player, rival);
    }


    public void evolutionKarmique(Color color, int nbAnneaux){
        int pointReincarnation = 0;
        for (Cards card : oeuvres){
            if (card.getColor() == color){
                pointReincarnation += card.getPoints();
            }
        }
        this.anneauxJoueur -= nbAnneaux;
        pointReincarnation += nbAnneaux;
        if (pointReincarnation < 4 || pointReincarnation < this.niveau){
            System.out.println("Dommage, vous n'avez pas assez de points pour évoluer sur l'échelle karmique...");
        } else if (pointReincarnation == 4 && pointReincarnation > this.niveau) {
            setNiveau(pointReincarnation);
            System.out.println("Félicitations, vous vous êtes réincarné en bousier");
        } else if (pointReincarnation == 5 && pointReincarnation > this.niveau) {
            setNiveau(pointReincarnation);
            System.out.println("Félicitations, vous vous êtes réincarné en serpent");
        } else if (pointReincarnation == 6 && pointReincarnation > this.niveau) {
            setNiveau(pointReincarnation);
            System.out.println("Félicitations, vous vous êtes réincarné en loup");
        } else if (pointReincarnation == 7 && pointReincarnation > this.niveau) {
            setNiveau(pointReincarnation);
            System.out.println("Félicitations, vous vous êtes réincarné en singe");
        }else {
            setNiveau(pointReincarnation);
            System.out.println("Félicitations, vous avez atteint la transcendance");
        }
    }
    public void seReincarner(PlateauDeJeu plateauDeJeu){
        for (Cards card : oeuvres){
            plateauDeJeu.defausserCarte(card);
        }
        for (Cards card : vieFuture){
            main.add(card);
        }
        int cardsToAdd = 6 - (main.size() + pile.size());
        pile.addAll(PlateauDeJeu.source.subList(0, cardsToAdd));
        PlateauDeJeu.source.subList(0, cardsToAdd).clear();
    }
    public boolean isMainVide(){
        return main.isEmpty();
    }
    public boolean isPileVide(){
        return pile.isEmpty();
    }




}
