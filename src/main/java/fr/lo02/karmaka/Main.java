package fr.lo02.karmaka;

import fr.lo02.karmaka.game.GameManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Souhaitez-vous jouer seul (1) ou à deux (2) ?");

        Integer ModeDeJeu = Integer.valueOf(scan.nextLine());  // Read user input

        if (ModeDeJeu == 1){
            GameManager PartieTest = new GameManager();
        } else if (ModeDeJeu == 2) {
            GameManager PartieTest = new GameManager();
        }else {
            System.out.println("Erreur saisie");
        }
    }
}
