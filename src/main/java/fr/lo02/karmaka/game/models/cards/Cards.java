package fr.lo02.karmaka.game.models.cards;
import fr.lo02.karmaka.game.GameManager;
import fr.lo02.karmaka.game.models.Player;


import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public enum Cards {

    TRANSMIGRATION(3, 1, Color.BLUE,
            List.of("Placez dans votre Main n’importe quelle carte de votre Vie Future.\n")) {
        @Override
        public void onPlayed(GameManager gameManager , Player player, Player rival, Cards carte) {
            player.getVieFuture();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choisissez l'index de la carte à ajouter à votre main : ");
            int indexCarteChoisie = scanner.nextInt();
            scanner.close();
            player.main.add(player.vieFuture.get(indexCarteChoisie));
        }

    },
    COUP_DOEIL(3, 1,Color.BLUE,
            Arrays.asList("Regardez la Main d’un rival.", "Vous pouvez ensuite jouer une autre carte.\n")) {
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival, Cards carte) {
            System.out.println(rival.getMain());
            System.out.println("Comment souhaitez vous utiliser votre carte ? ");

        }
    },
    DUPERIE(2, 3, Color.BLUE,
            List.of("Regardez 3 cartes de la Main d’un rival ; ajoutez-en une à votre Main.\n")) {
        @Override
        public void onPlayed(GameManager gameManager , Player player, Player rival, Cards carte) {

        }
    },
    VOL(2, 3, Color.BLUE,
            List.of("Placez dans votre Main l’Oeuvre Exposée d'un rival.\n")) {
        @Override
        public void onPlayed(GameManager gameManager , Player player, Player rival) {
        }
    },
    DESTINEE(3, 2, Color.BLUE,
            Arrays.asList("Regardez les 3 premières cartes de la Source", "Ajoutez-en jusqu'à 2 à votre pile de Vie Future", "Replacez le reste dans l'ordre souhaité\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {

        }
    },
    REVES_BRISES(3, 2, Color.BLUE,
            List.of("Placez la première carte de la Vie Future d'un rival sur la votre.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {

        }
    },
    DENI(3, 2, Color.BLUE,
            Arrays.asList("Défaussez une carte de votre main", "Copiez le pouvoir de cette carte.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {

        }
    },
    LENDEMAIN(3, 1, Color.GREEN,
            Arrays.asList("Puisez une carte à la source", "Vous pouvez ensuite jouer une autre carte.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {

        }
    },
    RECYCLAGE(3, 1, Color.GREEN,
            List.of("Ajoutez à votre Vie Future une des 3 dernières cartes de la fosse.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {

        }
    },
    SAUVETAGE(3, 2, Color.GREEN,
            List.of("Ajoutez à votre main une des 3 dernières cartes de la fosse.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {

        }
    },
    LONGEVITE(3, 2, Color.GREEN,
            List.of("Placez 2 cartes puisés à la source sur la pile d'un joueur.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {

        }
    },
    LONGEVITE(3, 2, Color.GREEN,
            List.of("Placez 2 cartes puisés à la source sur la pile d'un joueur.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {

        }
    },
    SEMIS(3, 2, Color.GREEN,
            Arrays.asList("Puisez 2 cartes à la source", "Placez sur votre Vie Future 2 cartes de votre main.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {

        }
    },
    SEMIS(2, 3, Color.GREEN,
            Arrays.asList("Puisez 3 cartes à la source", "Vous pouvez ensuite jouer une autre carte.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {

        }
    },
    SEMIS(2, 3, Color.GREEN,
            List.of("Placez jusqu'à 2 cartes de votre main sur vos oeuvres.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {

        }
    };



    private final int number, points;
    private final Color color;
    private final List<String> description;



    Cards(int number, int points, Color color, List<String> description){
        this.number = number;
        this.points = points;
        this.color = color;
        this.description = description;

    }

    public int getNumber() {return number;}
    public int getPoints() {return points;}
    public List<String> getDescription() {return description;}
    public Color getColor() {return color;}


    public abstract void onPlayed(GameManager gameManager , Player player, Player rival);
}

