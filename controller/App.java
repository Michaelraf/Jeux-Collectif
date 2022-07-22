package controller;

import view.Menu;
public class App {
    public static void main(String[] args){
        int choix = 0;
        Menu menu = new Menu("Menu principale");
        Game game;
        menu.addItem("Regarder un match");
        while (choix != 1){
            menu.display();
            choix = menu.getChoix();
        }
        game = new Game();
        game.run();
    }
}
