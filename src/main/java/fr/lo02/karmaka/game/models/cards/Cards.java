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
        public void onPlayed(GameManager gameManager, Player player, Player rival, Cards carte) {
            // Affiche la main du joueur rival
            System.out.println("Main du rival: " + rival.getMain());

            // Utilisez un scanner pour obtenir l'index des cartes que le joueur veut regarder
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choisissez trois indices de cartes à regarder dans la main du rival (séparés par des espaces) : ");

            // Lit les indices saisis par le joueur
            int indexCarte1 = scanner.nextInt();
            int indexCarte2 = scanner.nextInt();
            int indexCarte3 = scanner.nextInt();

            // Ferme le scanner
            scanner.close();

            // Récupère les cartes choisies dans la main du rival
            Cards carteRival1 = rival.getMain().get(indexCarte1);
            Cards carteRival2 = rival.getMain().get(indexCarte2);
            Cards carteRival3 = rival.getMain().get(indexCarte3);

            // Affiche les cartes choisies par le joueur
            System.out.println("Cartes choisies dans la main du rival: " + carteRival1 + ", " + carteRival2 + ", " + carteRival3);

            // Ajoute l'une des cartes choisies à la main du joueur
            System.out.print("Choisissez l'index de la carte à ajouter à votre main : ");
            int indexCarteAjoutee = scanner.nextInt();
            scanner.close();

            player.getMain().add(rival.getMain().get(indexCarteAjoutee));


        }


    },




    VOL(2, 3, Color.BLUE,
            List.of("Placez dans votre Main l’Oeuvre Exposée d'un rival.\n")) {
@Override
public void onPlayed(GameManager gameManager, Player player, Player rival) {
        // Affiche les œuvres exposées du rival
        System.out.println("Oeuvres exposées du rival: " + rival.getOeuvres());

        // Utilisez un scanner pour obtenir l'index de l'œuvre exposée que le joueur veut voler
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choisissez l'index de l'œuvre exposée à voler : ");

        // Lit l'index saisi par le joueur
        int indexOeuvreVolee = scanner.nextInt();



        // Récupère l'œuvre exposée choisie dans les œuvres du rival
        Cards oeuvreVolee = rival.getOeuvres().get(indexOeuvreVolee);

        // Affiche l'œuvre exposée choisie par le joueur
        System.out.println("Œuvre exposée volée : " + oeuvreVolee);

        // Ajoute l'œuvre exposée volée à la main du joueur
        player.getMain().add(oeuvreVolee);
        }
    },
    DESTINEE(3, 2, Color.BLUE,
            Arrays.asList("Regardez les 3 premières cartes de la Source", "Ajoutez-en jusqu'à 2 à votre pile de Vie Future", "Replacez le reste dans l'ordre souhaité\n")){
@Override
public void onPlayed(GameManager gameManager, Player player, Player rival) {
        // Affiche les trois premières cartes de la source
        List<Cards> cartesSource = gameManager.getPlateauDeJeu().getSource().subList(0, 3);
        System.out.println("Trois premières cartes de la source : " + cartesSource);

        // Utilisez un scanner pour obtenir les indices des cartes que le joueur veut ajouter à sa Vie Future
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choisissez les indices des cartes à ajouter à votre Vie Future (séparés par des espaces) : ");

        // Lit les indices saisis par le joueur
        int indexCarte1 = scanner.nextInt();
        int indexCarte2 = scanner.nextInt();

        // Récupère les cartes choisies dans la source
        Cards carteChoisie1 = cartesSource.get(indexCarte1);
        Cards carteChoisie2 = cartesSource.get(indexCarte2);

        // Affiche les cartes choisies par le joueur
        System.out.println("Cartes choisies dans la source : " + carteChoisie1 + ", " + carteChoisie2);

        // Ajoute les cartes choisies à la Vie Future du joueur
        player.getVieFuture().add(carteChoisie1);
        player.getVieFuture().add(carteChoisie2);

        // Retire les cartes choisies de la source
        gameManager.getPlateauDeJeu().getSource().remove(carteChoisie1);
        gameManager.getPlateauDeJeu().getSource().remove(carteChoisie2);

        }

        },
    REVES_BRISES(3, 2, Color.BLUE,
            List.of("Placez la première carte de la Vie Future d'un rival sur la votre.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {
            // Affiche la première carte de la Vie Future du rival
            Cards carteRival = rival.getVieFuture().get(0);
            System.out.println("Première carte de la Vie Future du rival : " + carteRival);

            // Placez la première carte de la Vie Future du rival sur votre Vie Future
            player.getVieFuture().add(carteRival);

            // Retirez la première carte de la Vie Future du rival
            rival.getVieFuture().remove(carteRival);

        }
    },
    DENI(3, 2, Color.BLUE,
            Arrays.asList("Défaussez une carte de votre main", "Copiez le pouvoir de cette carte.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {
            // Affiche la main du joueur
            System.out.println("Main du joueur : " + player.getMain());

            // Utilisez un scanner pour obtenir l'index de la carte à défausser
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choisissez l'index de la carte à défausser de votre main : ");

            // Lit l'index saisi par le joueur
            int indexCarteADefauster = scanner.nextInt();

            // Récupère la carte choisie dans la main du joueur
            Cards carteADefauster = player.getMain().get(indexCarteADefauster);

            // Défausse la carte choisie
            player.getMain().remove(carteADefauster);

            // Copie le pouvoir de la carte défaussée
            player.jouerPouvoir(carteADefauster);
        }
    },
    LENDEMAIN(3, 1, Color.GREEN,
            Arrays.asList("Puisez une carte à la source", "Vous pouvez ensuite jouer une autre carte.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {
            // Puisez une carte à la source
            Cards cartePiochee = gameManager.getPlateauDeJeu().getSource().remove(0);

            // Affiche la carte piochée
            System.out.println("Carte piochée à la source : " + cartePiochee);

            // Ajoutez la carte piochée à la main du joueur
            player.getMain().add(cartePiochee);
        }
    },
    RECYCLAGE(3, 1, Color.GREEN,
            List.of("Ajoutez à votre Vie Future une des 3 dernières cartes de la fosse.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {
            // Affiche les trois dernières cartes de la fosse
            List<Cards> cartesFosse = gameManager.getPlateauDeJeu().getFosse().subList(Math.max(0, gameManager.getPlateauDeJeu().getFosse().size() - 3), gameManager.getPlateauDeJeu().getFosse().size());
            System.out.println("Trois dernières cartes de la fosse : " + cartesFosse);

            // Utilisez un scanner pour obtenir l'index de la carte à ajouter à la Vie Future du joueur
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choisissez l'index de la carte à ajouter à votre Vie Future (parmi les trois dernières cartes de la fosse) : ");

            // Lit l'index saisi par le joueur
            int indexCarteAjoutee = scanner.nextInt();

            // Ferme le scanner
            scanner.close();

            // Récupère la carte choisie dans la fosse
            Cards carteAjoutee = cartesFosse.get(indexCarteAjoutee);

            // Ajoute la carte choisie à la Vie Future du joueur
            player.getVieFuture().add(carteAjoutee);

            // Retire la carte choisie de la fosse
            gameManager.getPlateauDeJeu().getFosse().remove(carteAjoutee);
        }
    },
    SAUVETAGE(3, 2, Color.GREEN,
            List.of("Ajoutez à votre main une des 3 dernières cartes de la fosse.\n")){
        @Override
        public void onPlayed(GameManager gameManager, Player player, Player rival) {
            // Affiche les trois dernières cartes de la fosse
            List<Cards> cartesFosse = gameManager.getPlateauDeJeu().getFosse().subList(Math.max(0, gameManager.getPlateauDeJeu().getFosse().size() - 3), gameManager.getPlateauDeJeu().getFosse().size());
            System.out.println("Trois dernières cartes de la fosse : " + cartesFosse);

            // Utilisez un scanner pour obtenir l'index de la carte à ajouter à la main du joueur
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choisissez l'index de la carte à ajouter à votre main (parmi les trois dernières cartes de la fosse) : ");

            // Lit l'index saisi par le joueur
            int indexCarteAjoutee = scanner.nextInt();

            // Ferme le scanner
            scanner.close();

            // Récupère la carte choisie dans la fosse
            Cards carteAjoutee = cartesFosse.get(indexCarteAjoutee);

            // Ajoute la carte choisie à la main du joueur
            player.getMain().add(carteAjoutee);

            // Retire la carte choisie de la fosse
            gameManager.getPlateauDeJeu().getFosse().remove(carteAjoutee);
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
            // Puisez deux cartes à la source
            List<Cards> cartesPiochees = gameManager.getPlateauDeJeu().getSource().subList(0, 2);

            // Affiche les deux cartes piochées
            System.out.println("Deux cartes piochées à la source : " + cartesPiochees);

            // Ajoutez les deux cartes piochées à la Vie Future du joueur
            player.getVieFuture().addAll(cartesPiochees);

            // Retirez les deux cartes piochées de la source
            gameManager.getPlateauDeJeu().getSource().removeAll(cartesPiochees);

            // Utilisez un scanner pour obtenir les indices des cartes à placer sur vos oeuvres
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choisissez les indices des cartes à placer sur vos oeuvres (séparés par des espaces) : ");

            // Lit les indices saisis par le joueur
            int indexCarte1 = scanner.nextInt();
            int indexCarte2 = scanner.nextInt();

            // Récupère les cartes choisies dans la Vie Future du joueur
            Cards carteChoisie1 = player.getVieFuture().get(indexCarte1);
            Cards carteChoisie2 = player.getVieFuture().get(indexCarte2);

            // Affiche les cartes choisies par le joueur
            System.out.println("Cartes choisies dans la Vie Future du joueur : " + carteChoisie1 + ", " + carteChoisie2);

            // Ajoutez les cartes choisies sur les oeuvres du joueur
            player.getOeuvres().add(carteChoisie1);
            player.getOeuvres().add(carteChoisie2);

            // Retirez les cartes choisies de la Vie Future du joueur
            player.getVieFuture().remove(carteChoisie1);
            player.getVieFuture().remove(carteChoisie2);
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

