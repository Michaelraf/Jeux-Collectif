package controller;

import models.jeux.Football;
import view.Menu;
import models.jeux.Basketball;


import java.util.Scanner;

public class Game {

    /**
     * Attribut menu pour le jeu
     */
    Menu menu;

    Game() {
        menu = new Menu("Menu de jeu");
        this.menu.addItem("Football");
        this.menu.addItem("Basketball");
        this.menu.addItem("Volleyball (non disponible)");
    }

    /**
     * Choisir le jeu puis le lancer
     */

    public void run() {
        int choix = 0;
        this.menu.display();
        try (Scanner scanner = new Scanner(System.in)) {
            choix = Integer.parseInt(scanner.nextLine());
            if (choix == 1) {
                while (choix != 0) {
                    Football football = new Football();
                    football.preparer();
                    football.jouer();
                    football.pause();
                    football.jouer();
                    football.fin();
                    System.out.println("Regarder un nouveau match ? 1: OUI, 0: NON");
                    choix = Integer.parseInt(scanner.nextLine());
                }

            } else if (choix == 2) {
                while (choix != 0) {
                    Basketball basketball = new Basketball();
                    basketball.preparer();
                    basketball.jouer();
                    basketball.pause();
                    basketball.randomiserJoueurs();
                    basketball.jouer();
                    basketball.pause();
                    basketball.randomiserJoueurs();
                    basketball.jouer();
                    basketball.pause();
                    basketball.randomiserJoueurs();
                    basketball.jouer();
                    basketball.fin();
                    System.out.println("Regarder un nouveau match ? 1: OUI, 0: NON");
                    choix = Integer.parseInt(scanner.nextLine());
                }

            } else if (choix == 3) {
                System.out.println("Vous avez choisi volleyball");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur du scanner de Game.java");
        }

    }
}