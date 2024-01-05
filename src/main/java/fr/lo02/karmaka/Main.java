package fr.lo02.karmaka;

import fr.lo02.karmaka.game.GameManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("-------------------| Bienvenue sur notre jeu du Karmaka ! Pourrez-vous atteindre la transcendance ? |-------------------");
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Souhaitez-vous jouer seul (1) ou à deux (2) ?");

        Integer ModeDeJeu = Integer.valueOf(scan.nextLine());  // Read user input

        if (ModeDeJeu == 1){
            GameManager partieVsOrdi = new GameManager(1);
        } else if (ModeDeJeu == 2) {
            GameManager partieVsJoueur = new GameManager(2);
            partieVsJoueur.initPartie();
            partieVsJoueur.MenuDebut();
            partieVsJoueur.tourCaracteristique();
        }else {
            System.out.println("Erreur saisie");
        }

    }
}
