package fr.lo02.karmaka.game;

import fr.lo02.karmaka.game.models.PlateauDeJeu;
import fr.lo02.karmaka.game.models.Player;
import fr.lo02.karmaka.game.models.cards.Cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    public PlateauDeJeu plateauDeJeu;
    public Player joueur1;
    public Player joueur2;
    public Player joueurActuel;
    public int nbJoueur;
    public GameManager(int nbJoueur) {
        //Arrays.stream(Cards.values()).forEach(cards -> );
        this.nbJoueur = nbJoueur;
    }

    public void initPartie(){
        Scanner scanner = new Scanner(System.in);
        if (nbJoueur == 2){
        // Saisie du nom du joueur 1
        System.out.print("Saisissez le nom du joueur 1 : ");
        String nomJoueur1 = scanner.nextLine();
        joueur1 = new Player(nomJoueur1);

        // Saisie du nom du joueur 2
        System.out.print("Saisissez le nom du joueur 2 : ");
        String nomJoueur2 = scanner.nextLine();
        joueur2 = new Player(nomJoueur2);

        // Décision du joueur qui commencera son tour en premier
        System.out.print("Le joueur 1 ou le joueur 2 commencera son tour en premier ? (1/2) : ");
        int choixPremierJoueur = scanner.nextInt();

        if (choixPremierJoueur == 1) {
            joueurActuel = joueur1;
        } else {
            joueurActuel = joueur2;
        }
    } else if (nbJoueur == 1) {
            // Saisie du nom du joueur
            System.out.print("Saisissez le nom du joueur 1 : ");
            String nomJoueur1 = scanner.nextLine();
            joueur1 = new Player(nomJoueur1);
            // SUITE A TERMINER
        }
    }
public void MenuDebut(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Commencer la partie : 1");
    System.out.println("Quitter le jeu : 2");

    int choixMenu = scanner.nextInt();

    switch (choixMenu) {
        case 1:
            // Commencer la partie
            debutPartie();
            break;
        case 2:
            // Quitter le jeu
            System.out.println("Merci d'avoir joué. Au revoir !");
            System.exit(0);
            break;
        default:
            System.out.println("Choix invalide. Veuillez choisir une option valide.");
    }
}
public void debutPartie(){
        PlateauDeJeu pdj = new PlateauDeJeu();
        if (nbJoueur == 2){
            joueur1.distribuerCarte();
            joueur2.distribuerCarte();

        } else if (nbJoueur == 1) {
            //à compléter
        }

}

    public void tourCaracteristique(Scanner saisieJoueur) {
        boolean continuerTour = true;

        while (continuerTour) {
            System.out.println("Consulter sa main : 1");
            System.out.println("Choisir une carte : 2");
            System.out.println("Passer le tour : 3");
            System.out.println("Abandonner la partie : 4");

            int saisie = saisieJoueur.nextInt();

            switch (saisie) {
                case 1:
                    System.out.println(joueurActuel.getMain());
                    break;
                case 2:
                    choisirCarte(saisieJoueur);
                    break;
                case 3:
                    passerTour();
                    continuerTour = false; // Sort de la boucle
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }


    private void passerTour() {
        // Ajoutez la logique pour passer au tour suivant
        if (joueurActuel == joueur1) {
            joueurActuel = joueur2;
        } else {
            joueurActuel = joueur1;
        }
    }
    public void choisirCarte(Scanner saisieJoueur) {
        String saisie;
        boolean carteValide = false;

        // Utilisez une boucle pour demander à l'utilisateur jusqu'à ce qu'il entre une carte valide
        while (!carteValide) {
            System.out.println("Sélectionnez le nom de la carte que vous souhaitez jouer (en majuscules)");
            saisie = saisieJoueur.nextLine();

            // Vérifiez si le nom saisi correspond à une carte existante
            for (Cards carte : Cards.values()) {
                if (carte.name().equals(saisie)) {
                    // Le nom saisi correspond à une carte valide
                    carteValide = true;
                    utilCarte(carte, saisieJoueur);//besoin d'aide ici pour faire appel à utilCarte



                    break;  // Sortez de la boucle for
                }
            }

            // Si la carte n'est pas valide, affichez un message d'erreur et redemandez à l'utilisateur
            if (!carteValide) {
                System.out.println("Nom de carte invalide. Veuillez réessayer.");
            }
        }
    }


    public void utilCarte(Cards card, Scanner scan){
        int choix;
        System.out.println("Jouer la carte pour son pouvoir : 1");
        System.out.println("Jouer la carte pour ses points : 2");
        System.out.println("Jouer la carte pour la vie future : 3");
        choix = scan.nextInt();
        switch (choix){
            case 1 :
                joueurActuel.jouerPouvoir(this, joueurActuel,getRival(), card );
                break;
            case 2 :
                joueurActuel.jouerPoints(card);
                break;
            case 3 :
                joueurActuel.jouerFutur(card);
                break;
        }

    }

    public Player getRival(){
        return joueurActuel == joueur1 ? joueur2 : joueur1;
    }
    public PlateauDeJeu getPlateauDeJeu() {
        return plateauDeJeu;
    }
}












    public void jouerPartie(Scanner scan) {
        while (true) {
            System.out.println("Tour de " + joueurActuel.getNom() + " !");
            tourCaracteristique(scan);

            // Vérifier si le joueur a atteint la transcendance
            if (joueurActuel.getNiveau() >= 8) {
                System.out.println(joueurActuel.getNom() + " a atteint la transcendance ! Félicitations !");
                break;  // Sortir de la boucle si le joueur a atteint la transcendance
            }

            // Changer de joueur pour le prochain tour
            passerTour();
        }
    }

    // ... (votre code existant)
}
