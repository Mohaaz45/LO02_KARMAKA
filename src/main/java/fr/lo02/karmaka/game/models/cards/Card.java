package fr.lo02.karmaka.game.models.cards;

import java.util.ArrayList;

public class Card {
    private int Point;
    private String Name;

    private CardColor CardColor;

    public int getPoint(){
        return this.Point;
    }

    public void setPoint(int point) {
        this.Point = point;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public enum getCardColor(){
        return this.CardColor;
    }
    public void setCardColor(CardColor cardcolor){
        this.CardColor = cardcolor;
    }

    public Card(int point, String name, CardColor cardcolor){
        this.Point = point;
        this.Name = name;
        this.CardColor = cardcolor;
    }



    public String DisplayCapacity(){
        switch (Name){
            case "Transmigration":
                return "Placez dans votre Main n’importe quelle carte de votre Vie Future";
                break;
            case "CoupdOeil":
                return "Regardez la Main d’un rival. Vous pouvez ensuite jouer une autre carte.";
                break;
            case "Destinée":
                return "Regardez les 3 premières cartes de la source ajoutez-en jusqu’à 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité.";
                break;
            case "RêveBrisé":
                return "Placez la première carte de la Vie Future d'un rival sur la vôtre.";
                break;
            case "Déni":
                return "Défaussez une carte de votre Main Copiez le pouvoir de cette carte";
                break;
            case "Duperie":
                return "Regardez 3 cartes de la Main d’un rival ; ajoutez-en une à votre Main";
                break;
            case "Vol":
                return "Placez dans votre Main l’Oeuvre Exposée d'un rival.";
                break;
            case "Lendemain":
                return "Puisez une carte à la Source Vous pouvez ensuite jouer une autre carte.";
                break;
            case "Recyclage":
                return "Ajoutez à votre Vie Future une des 3 dernières cartes de la Fosse";
                break;
            case "Sauvetage":
                return "Ajoutez à votre Main une des3 dernières cartes de la Fosse";
                break;
            case "Longévité":
                return "Placez 2 cartes puisées à la Source sur la Pile d'un joueur";
                break;
            case "Semi":
                return "Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de votre Main";
                break;
            case "Voyage":
                return "Puisez 3 cartes à la Source Vous pouvez ensuite jouer une autre carte.";
                break;
            case "Jubilé":
                return "Placez jusqu’à 2 cartes de votre Main sur vos Oeuvres";
                break;
            case "Panique":
                return "Défaussez la première carte de la Pile d'un joueur Vous pouvez ensuite jouer une autre carte";
                break;
            case "DernierSouffle":
                return "Le joueur de votre choix défausse une carte de sa Main.";
                break;
            case "Crise":
                return "Le rival de votre choix défausse une de ses Oeuvres";
                break;
            case "Roulette":
                return "Défaussez jusqu’à 2 cartes de votre Main Vous pouvez ensuite puiser à la Source autant de carte(s) + 1.";
                break;
            case "Fournaise":
                return "Défaussez les 2 premières cartes de la Vie Future d'un rival.";
                break;
            case "Vengeance":
                return "Défaussez l’Oeuvre Exposée d’un rival";
                break;
            case "Bassesse":
                return "Défaussez au hasard 2 cartes de la Main d’un rival.";
                break;
            case "Incarnation":
                return "Choisissez une de vos Oeuvres Copiez son pouvoir.";
                break;
            case "Mimétisme":
                return "Choisissez un Rival Copiez le pouvoir de son Oeuvre Exposée";
                break;
        }
    }


}
