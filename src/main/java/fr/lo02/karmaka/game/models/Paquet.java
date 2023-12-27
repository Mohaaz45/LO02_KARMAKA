package fr.lo02.karmaka.game.models;

import fr.lo02.karmaka.game.models.cards.Card;
import fr.lo02.karmaka.game.models.cards.CardColor;

import java.util.ArrayList;

public class Paquet {
    private ArrayList<Card> paquet;



    public void FormerPaquet(){
        ArrayList<Card> paquet = new ArrayList<Card>();
        for (int i=0; i<3; i++){
            Card transmigration = new Card(1, "Transmigration", CardColor.BLUE);
            paquet.add(transmigration);
        }
        for (int i=0; i<3; i++){
            Card CoupdOeil = new Card(1, "CoupdOeil", CardColor.BLUE);
            paquet.add(CoupdOeil);
        }
        for (int i=0; i<3; i++){
            Card Destinée = new Card(1, "Destinée", CardColor.BLUE);
            paquet.add(Destinée);
        }
        for (int i=0; i<3; i++){
            Card ReveBrisé = new Card(1, "ReveBrisé", CardColor.BLUE);
            paquet.add(ReveBrisé);
        }
        for (int i=0; i<3; i++){
            Card Déni = new Card(1, "Déni", CardColor.BLUE);
            paquet.add(Déni);
        }
        for (int i=0; i<3; i++){
            Card Lendemain = new Card(1, "Lendemain", CardColor.GREEN);
            paquet.add(Lendemain);
        }
        for (int i=0; i<3; i++){
            Card Recyclage = new Card(1, "Recyclage", CardColor.GREEN);
            paquet.add(Recyclage);
        }
        for (int i=0; i<3; i++){
            Card Sauvetage = new Card(1, "Sauvetage", CardColor.GREEN);
            paquet.add(Sauvetage);
        }
        for (int i=0; i<3; i++){
            Card Longévité = new Card(1, "Longévité", CardColor.GREEN);
            paquet.add(Longévité);
        }
        for (int i=0; i<3; i++){
            Card Semis = new Card(1, "Semis", CardColor.GREEN);
            paquet.add(Semis);
        }
        for (int i=0; i<3; i++){
            Card Panique = new Card(1, "Panique", CardColor.GREEN);
            paquet.add(Panique);
        }
        for (int i=0; i<3; i++){
            Card DernierSouffle = new Card(1, "DernierSouffle", CardColor.RED);
            paquet.add(DernierSouffle);
        }
        for (int i=0; i<3; i++){
            Card Crise = new Card(1, "Crise", CardColor.RED);
            paquet.add(Crise);
        }
        for (int i=0; i<3; i++){
            Card Roulette = new Card(1, "Roulette", CardColor.RED);
            paquet.add(Roulette);
        }
        for (int i=0; i<3; i++){
            Card Fournaise = new Card(1, "Fournaise", CardColor.RED);
            paquet.add(Fournaise);
        }
        //--------------------------------------------------------------------------Cartes Disponible en doublons
        for (int i=0; i<2; i++){
            Card Duperie = new Card(1, "Duperie", CardColor.BLUE);
            paquet.add(Duperie);
        }
        for (int i=0; i<2; i++){
            Card Vol = new Card(1, "Vol", CardColor.BLUE);
            paquet.add(Vol);
        }
        for (int i=0; i<2; i++){
            Card Voyage = new Card(1, "Voyage", CardColor.GREEN);
            paquet.add(Voyage);
        }
        for (int i=0; i<2; i++){
            Card Jubilé = new Card(1, "Jubilé", CardColor.GREEN);
            paquet.add(Jubilé);
        }
        for (int i=0; i<2; i++){
            Card Vengeance = new Card(1, "Vengeance", CardColor.RED);
            paquet.add(Vengeance);
        }
        for (int i=0; i<2; i++){
            Card Bassesse = new Card(1, "Bassesse", CardColor.RED);
            paquet.add(Bassesse);
        }
        for (int i=0; i<2; i++){
            Card Mimétisme = new Card(1, "Mimétisme", CardColor.GREEN);
            paquet.add(Mimétisme);
        }
        for (int i=0; i<5; i++){
            Card Incarnation = new Card(1, "Incarnation", CardColor.GREEN);
            paquet.add(Incarnation );
        }
    }
}
