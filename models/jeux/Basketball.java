package models.jeux;

import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

import models.personne.arbitre.Arbitre;
import models.personne.equipe.EquipeBasket;
import models.personne.joueur.JoueurBasket;
import view.Menu;

public class Basketball implements Jeux{


    /**
     * listEquipe contient la liste des équipes qui peuvent jouer
     */
    private ArrayList<String> listeEquipe;

    /**
     * equipe1 l'équipe1 choisi
     */
    private EquipeBasket equipe1;
    /**
     * equipe2 l'équipe2 choisi
     */
    private EquipeBasket equipe2;

    /**
     * L'équipe qui est en possession du ballon
     */

    private ArrayList<JoueurBasket> equipeActuel;
    private ArrayList<JoueurBasket> equipeNonActuel;

    /**
     * l'arbitre principal du jeu
     */

    private Arbitre arbitre;


    /**
     * liste des joueurs sur terrain pour l'èquipe1
     */
    private ArrayList<JoueurBasket> joueursActuels1;
    /**
     * liste des joueurs sur terrain pour l'èquipe2
     */
    private ArrayList<JoueurBasket> joueursActuels2;



    /**
     * Le joueur qui a le ballon
     */
    private JoueurBasket joueurActuel;

    /**
     * Constructeur crée la listeEquipe
     */

    public Basketball(){
        equipe1 = new EquipeBasket();
        equipe2 = new EquipeBasket();
        listeEquipe = new ArrayList<String>();
        joueursActuels1 = new ArrayList<JoueurBasket>();
        joueursActuels2 = new ArrayList<JoueurBasket>();
        joueurActuel = new JoueurBasket();
        equipeActuel = new ArrayList<JoueurBasket>();
        equipeActuel = joueursActuels1;
        equipeNonActuel = joueursActuels2;
        
        try{
            File fichier = new File("./data/equipesBasketball.data");
            try (Scanner scanner = new Scanner(fichier)) {
                while(scanner.hasNextLine()){
                    String data = scanner.nextLine();
                    listeEquipe.add(data);
                }
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("Erreur lors de l'initialisation de la liste des equipes");
            e.printStackTrace();
        }

        arbitre = new Arbitre();
    }

    /**
     * initialisation des équipes
     */
    public void initialiserEquipe1(){
        Menu menu = new Menu("Choisissez l'équipe 1");
        int choix = 0; 
        for (int i=0; i<listeEquipe.size(); i++){
            menu.addItem(listeEquipe.get(i));
        }
        menu.display();
        choix = menu.getChoix();
        equipe1 = new EquipeBasket(listeEquipe.get(choix-1));
        System.out.println("Vous avez choisi "+listeEquipe.get(choix-1)+'\n');
        equipe1.setNom(listeEquipe.get(choix-1));
        equipe1.initialise();
    }
    public void initialiserEquipe2(){
        Menu menu = new Menu("Choisissez l'équipe 2");
        int choix = 0; 
        for (int i=0; i<listeEquipe.size(); i++){
            menu.addItem(listeEquipe.get(i));
        }
        menu.display();
        choix = menu.getChoix();
        equipe2 = new EquipeBasket(listeEquipe.get(choix-1));
        System.out.println("Vous avez choisi "+listeEquipe.get(choix-1)+'\n');
        equipe2.setNom(listeEquipe.get(choix-1));
        equipe2.initialise();
    }

    public void preparer(){
        System.out.println('\n');
        initialiserEquipe1();
        initialiserEquipe2();        
        randomiserJoueurs();
        System.out.println("\nequipe1\n");
        for (int i=0; i<joueursActuels1.size(); i++){
            System.out.println(joueursActuels1.get(i).getNom() + ' ' + joueursActuels1.get(i).getPosition()+'\n');
        }
        System.out.println("\nequipe2\n");
        for (int i=0; i<joueursActuels1.size(); i++){
            System.out.println(joueursActuels2.get(i).getNom() + ' ' + joueursActuels2.get(i).getPosition()+'\n');
            
        }
        System.out.println('\n');
        // Respecter le temps de 0.163 seconde 
        try {
            Thread.sleep(163);
        } catch (InterruptedException e) {
            System.out.println("Thread error");
            e.printStackTrace();
        }
    }

    public void randomiserJoueurs(){
        equipe1.sectionner();
        equipe2.sectionner();

        //Initialiser les joueurs qui vont jouer sur terrain pendant le quart temps

        ///Arriere
        for (int i=0; i<1; i++){
            int index;

            ///Equipe1
            //Randomiser l'index à prendre
            Random rand = new Random();
            index = rand.nextInt(equipe1.getArriere().size());
            joueursActuels1.add(equipe1.getArriere().get(index));
            equipe1.getArriere().remove(index);

            ///Equipe2

            index = rand.nextInt(equipe2.getArriere().size());
            joueursActuels2.add(equipe2.getArriere().get(index));
            equipe2.getArriere().remove(index);
        }
        /// Aillier
        for (int i=0; i<2; i++){
            int index;

            ///Equipe1
            //Randomiser l'index à prendre
            Random rand = new Random();
            index = rand.nextInt(equipe1.getAillier().size());
            joueursActuels1.add(equipe1.getAillier().get(index));
            equipe1.getAillier().remove(index);

            ///Equipe2

            index = rand.nextInt(equipe2.getAillier().size());
            joueursActuels2.add(equipe2.getAillier().get(index));
            equipe2.getAillier().remove(index);
        }

        /// Meneur
        for (int i=0; i<1; i++){
            int index;

            ///Equipe1
            //Randomiser l'index à prendre
            Random rand = new Random();
            index = rand.nextInt(equipe1.getMeneur().size());
            joueursActuels1.add(equipe1.getMeneur().get(index));
            equipe1.getMeneur().remove(index);

            ///Equipe2

            index = rand.nextInt(equipe2.getMeneur().size());
            joueursActuels2.add(equipe2.getMeneur().get(index));
            equipe2.getMeneur().remove(index);
        }

        /// Pivot
        for (int i=0; i<1; i++){
            int index;

            ///Equipe1
            //Randomiser l'index à prendre
            Random rand = new Random();
            index = rand.nextInt(equipe1.getPivot().size());
            joueursActuels1.add(equipe1.getPivot().get(index));
            equipe1.getPivot().remove(index);

            ///Equipe2

            index = rand.nextInt(equipe2.getPivot().size());
            joueursActuels2.add(equipe2.getPivot().get(index));
            equipe2.getPivot().remove(index);
        }
    }
    /**
     * Echanger equipeActuelle et equipeNonActuelles
     */
    public void echanger(){
        ArrayList<JoueurBasket> temp;
        temp = new ArrayList<JoueurBasket>();
        temp = equipeActuel;
        equipeActuel = equipeNonActuel;
        equipeNonActuel = temp;
    }
    /**
     * 
     * @param equipe l'équipe qui va toucher le ballon en premier
     */
    public void jouer(){
        arbitre.siffler();

        // Génération des actions

        int index = 4;
        Random rand = new Random();

        // L'attaquant touche le ballon en premier
        joueurActuel = equipeActuel.get(index);
        joueurActuel.jouer();
        for (int i=0; i<45; i++){

            // Un temps de 0.163 seconde avant chaque nouvelle action
            try {
                Thread.sleep(163);
            } catch (InterruptedException e) {
                System.out.println("Thread error");
                e.printStackTrace();
            }

            Random rand1 = new Random();
            int randIndex = 1 + rand1.nextInt(4);
            int chance = rand.nextInt(5);
            /*
            Chance pour qu'un joueur tire
                Arrière : 1/5
                Milieu : 2/5
                Aillier : 3/5
                Pivot : 4/5
             */

            if(
                //Arrière
                (joueurActuel.getPosition().charAt(0) == 'L' && chance != 0) ||
                //Aillier
                (joueurActuel.getPosition().charAt(0) == 'A' && (chance != 0 && chance != 1 && chance != 2)) ||
                //Meneur
                (joueurActuel.getPosition().charAt(0) == 'M' && (chance != 0 && chance != 1 && chance != 2 
                && chance != 3)) ||
                //Pivot
                (joueurActuel.getPosition().charAt(0) == 'P' && (chance != 0 && chance != 1 && chance != 2 
                && chance != 3 ))
            ){
                if (equipeActuel.get(randIndex).getNumero() == joueurActuel.getNumero()){
                    joueurActuel.dribbler();
                }
                else{
                    joueurActuel.passer(equipeActuel.get(randIndex).getNom());
                    // Respecter le temps de 0.163 seconde 
                    try {
                        Thread.sleep(163);
                    } catch (InterruptedException e) {
                        System.out.println("Thread error");
                        e.printStackTrace();
                    }
                    Random rand2 = new Random();
                    if(joueurActuel.getCapacite()+rand2.nextInt(2)<
                        equipeNonActuel.get(5-randIndex).getCapacite()+rand2.nextInt(3)){
                        joueurActuel = equipeNonActuel.get(5-randIndex);
                        joueurActuel.intercepter();

                        // Respecter le temps de 0.163 seconde 
                        try {
                            Thread.sleep(163);
                        } catch (InterruptedException e) {
                            System.out.println("Thread error");
                            e.printStackTrace();
                        }

                        echanger();
                        randIndex = 5 - randIndex;
                    }
                    equipeActuel.get(randIndex).jouer();
                    joueurActuel = equipeActuel.get(randIndex);
                }
            }
            else {
                joueurActuel.tirer();
                // Respecter le temps de 0.163 seconde 
                try {
                    Thread.sleep(163);
                } catch (InterruptedException e) {
                    System.out.println("Thread error");
                    e.printStackTrace();
                }
                Random rand2 = new Random();
                if(joueurActuel.getCapacite()+rand2.nextInt(2)<
                    equipeNonActuel.get(0).getCapacite()+rand2.nextInt(2)){
                    joueurActuel = equipeNonActuel.get(0);
                    joueurActuel.intercepter();
                    
                    echanger();
                }
                else{
                    if(joueurActuel.getCapacite()+rand2.nextInt(2)>
                    equipeNonActuel.get(0).getCapacite()){
                    joueurActuel.marquer2Pts();
                    echanger();
                    }
                    else if(joueurActuel.getCapacite()+rand2.nextInt(2)>
                    equipeNonActuel.get(0).getCapacite()+rand2.nextInt(1)){
                    joueurActuel.marquer3Pts();
                    echanger();
                    }
                    // Respecter le temps de 0.163 seconde 
                    try {
                        Thread.sleep(163);
                    } catch (InterruptedException e) {
                        System.out.println("Thread error");
                        e.printStackTrace();
                    }
                    echanger();
                    joueurActuel = equipeActuel.get(4);
                }
            }
        }
    
        arbitre.siffler();
    }
    public void pause(){
        // Respecter le temps de 0.163 seconde 
        try {
            Thread.sleep(163);
        } catch (InterruptedException e) {
            System.out.println("Thread error");
            e.printStackTrace();
        }
        System.out.println("Pause\n");
        echanger();
    }
    public void fin(){
        int score1 = 0;
        int score2 = 0;
        System.out.println("\nFin du match\n");
        System.out.println("Score : ");
        System.out.println("Equipe 1 : " + equipe1.getNom());
        for (int i = 0; i<joueursActuels1.size(); i++){
            if(joueursActuels1.get(i).getNbBut()>0)
                System.out.println(joueursActuels1.get(i).getNom() + 
                ':' + joueursActuels1.get(i).getNbBut());
                score1 += joueursActuels1.get(i).getNbBut();
        }
        System.out.println(score1);
        System.out.println("Equipe 2 : " + equipe2.getNom());
        for (int i = 0; i<joueursActuels2.size()-1; i++){
            if(joueursActuels2.get(i).getNbBut()>0)
                System.out.println(joueursActuels2.get(i).getNom() + 
                ':' + joueursActuels2.get(i).getNbBut());
                score2 += joueursActuels2.get(i).getNbBut();
        }
        System.out.println(score2);
    }

}
