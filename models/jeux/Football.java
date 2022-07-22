package models.jeux;

import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

import models.personne.arbitre.Arbitre;
import models.personne.equipe.EquipeFoot;
import models.personne.joueur.JoueurFoot;
import view.Menu;

public class Football implements Jeux{


    /**
     * listEquipe contient la liste des équipes qui peuvent jouer
     */
    private ArrayList<String> listeEquipe;

    /**
     * equipe1 l'équipe1 choisi
     */
    private EquipeFoot equipe1;
    /**
     * equipe2 l'équipe2 choisi
     */
    private EquipeFoot equipe2;

    /**
     * L'équipe qui est en possession du ballon
     */

    private ArrayList<JoueurFoot> equipeActuel;
    private ArrayList<JoueurFoot> equipeNonActuel;

    /**
     * l'arbitre principal du jeu
     */

    private Arbitre arbitre;


    /**
     * liste des joueurs sur terrain pour l'èquipe1
     */
    private ArrayList<JoueurFoot> joueursActuels1;
    /**
     * liste des joueurs sur terrain pour l'èquipe2
     */
    private ArrayList<JoueurFoot> joueursActuels2;



    /**
     * Le joueur qui a le ballon
     */
    private JoueurFoot joueurActuel;

    /**
     * Constructeur crée la listeEquipe
     */

    public Football(){
        equipe1 = new EquipeFoot();
        equipe2 = new EquipeFoot();
        listeEquipe = new ArrayList<String>();
        joueursActuels1 = new ArrayList<JoueurFoot>();
        joueursActuels2 = new ArrayList<JoueurFoot>();
        joueurActuel = new JoueurFoot();
        equipeActuel = new ArrayList<JoueurFoot>();
        equipeActuel = joueursActuels1;
        equipeNonActuel = joueursActuels2;
        
        try{
            File fichier = new File("./data/equipesFootball.data");
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
        equipe1 = new EquipeFoot(listeEquipe.get(choix-1));
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
        equipe2 = new EquipeFoot(listeEquipe.get(choix-1));
        System.out.println("Vous avez choisi "+listeEquipe.get(choix-1)+'\n');
        equipe2.setNom(listeEquipe.get(choix-1));
        equipe2.initialise();
    }

    public void preparer(){
        System.out.println('\n');
        initialiserEquipe1();
        initialiserEquipe2();
        equipe1.sectionner();
        equipe2.sectionner();
        //Initialiser les joueurs qui vont jouer sur terrain suivant la formation 4 3 3

        ///Gardiens
        for (int i=0; i<1; i++){
            int index;

            ///Equipe1
            //Randomiser l'index à prendre
            Random rand = new Random();
            index = rand.nextInt(equipe1.getGardiens().size());
            joueursActuels1.add(equipe1.getGardiens().get(index));
            equipe1.getGardiens().remove(index);

            ///Equipe2

            index = rand.nextInt(equipe2.getGardiens().size());
            joueursActuels2.add(equipe2.getGardiens().get(index));
            equipe2.getGardiens().remove(index);
        }
        /// Defenses
        for (int i=0; i<4; i++){
            int index;

            ///Equipe1
            //Randomiser l'index à prendre
            Random rand = new Random();
            index = rand.nextInt(equipe1.getDefenses().size());
            joueursActuels1.add(equipe1.getDefenses().get(index));
            equipe1.getDefenses().remove(index);

            ///Equipe2

            index = rand.nextInt(equipe2.getDefenses().size());
            joueursActuels2.add(equipe2.getDefenses().get(index));
            equipe2.getDefenses().remove(index);
        }

        /// Milieu
        for (int i=0; i<3; i++){
            int index;

            ///Equipe1
            //Randomiser l'index à prendre
            Random rand = new Random();
            index = rand.nextInt(equipe1.getMilieux().size());
            joueursActuels1.add(equipe1.getMilieux().get(index));
            equipe1.getMilieux().remove(index);

            ///Equipe2

            index = rand.nextInt(equipe2.getMilieux().size());
            joueursActuels2.add(equipe2.getMilieux().get(index));
            equipe2.getMilieux().remove(index);
        }

        /// Attaquants
        for (int i=0; i<3; i++){
            int index;

            ///Equipe1
            //Randomiser l'index à prendre
            Random rand = new Random();
            index = rand.nextInt(equipe1.getAttaquants().size());
            joueursActuels1.add(equipe1.getAttaquants().get(index));
            equipe1.getAttaquants().remove(index);

            ///Equipe2

            index = rand.nextInt(equipe2.getAttaquants().size());
            joueursActuels2.add(equipe2.getAttaquants().get(index));
            equipe2.getAttaquants().remove(index);
        }
        System.out.println("\nequipe1\n");
        for (int i=0; i<joueursActuels1.size(); i++){
            System.out.println(joueursActuels1.get(i).getNom() + ' ' + joueursActuels1.get(i).getPosition()+'\n');
        }
        System.out.println("\nequipe2\n");
        for (int i=0; i<joueursActuels1.size(); i++){
            System.out.println(joueursActuels2.get(i).getNom() + ' ' + joueursActuels2.get(i).getPosition()+'\n');
            
        }
        System.out.println('\n');
        // Respecter le temps de 0.75 seconde 
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            System.out.println("Thread error");
            e.printStackTrace();
        }
    }

    /**
     * Echanger equipeActuelle et equipeNonActuelles
     */
    public void echanger(){
        ArrayList<JoueurFoot> temp;
        temp = new ArrayList<JoueurFoot>();
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

        int index = 10;
        Random rand = new Random();

        // L'attaquant touche le ballon en premier
        joueurActuel = equipeActuel.get(index);
        joueurActuel.jouer();
        for (int i=0; i<45; i++){

            // Un temps de 0.75 seconde avant chaque nouvelle action
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                System.out.println("Thread error");
                e.printStackTrace();
            }

            Random rand1 = new Random();
            int randIndex = 1 + rand1.nextInt(10);
            int chance = rand.nextInt(20);
            /*
            Chance pour qu'un joueur tire
                Gardien de but: 1/20
                Défense : 3/20 = 1/5
                Milieu: 5/20
                Attaquant: 8/20 = 2/5
             */

            if(
                //Gardien de but
                (joueurActuel.getPosition().charAt(0) == 'G' && chance != 0) ||
                //Défense
                (joueurActuel.getPosition().charAt(0) == 'D' && (chance != 0 && chance != 1 && chance != 2)) ||
                //Milieu
                (joueurActuel.getPosition().charAt(0) == 'M' && (chance != 0 && chance != 1 && chance != 2 
                && chance != 3 && chance != 4)) ||
                //Attaquant
                (joueurActuel.getPosition().charAt(0) == 'A' && (chance != 0 && chance != 1 && chance != 2 
                && chance != 3 && chance != 4 && chance != 5  && chance != 6 && chance != 7 ))
            ){
                // int randIndex = 8 + rand1.nextInt(3);
                if (equipeActuel.get(randIndex).getNumero() == joueurActuel.getNumero()){
                    joueurActuel.dribbler();
                }
                else{
                    char position = 'c';
                    joueurActuel.passer(equipeActuel.get(randIndex).getNom());
                    // Respecter le temps de 0.75 seconde 
                    try {
                        Thread.sleep(750);
                    } catch (InterruptedException e) {
                        System.out.println("Thread error");
                        e.printStackTrace();
                    }
                    Random rand2 = new Random();
                    if(joueurActuel.getCapacite()+rand2.nextInt(2)<
                    equipeNonActuel.get(11-randIndex).getCapacite()){
                        joueurActuel = equipeNonActuel.get(11-randIndex);
                        joueurActuel.intercepter();

                        // Respecter le temps de 0.75 seconde 
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e) {
                            System.out.println("Thread error");
                            e.printStackTrace();
                        }

                        echanger();
                        randIndex = 11 - randIndex;
                    }
                    equipeActuel.get(randIndex).jouer();
                    joueurActuel = equipeActuel.get(randIndex);
                }
            }
            else {
                joueurActuel.tirer();
                // Respecter le temps de 0.75 seconde 
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                    System.out.println("Thread error");
                    e.printStackTrace();
                }
                Random rand2 = new Random();
                if(joueurActuel.getCapacite()+rand2.nextInt(2)<
                equipeNonActuel.get(0).getCapacite()+rand2.nextInt(5)){
                    joueurActuel = equipeNonActuel.get(0);
                    joueurActuel.intercepter();
                    
                    echanger();
                }
                else{
                    joueurActuel.marquer();
                    // Respecter le temps de 1 seconde 
                    try {
                        Thread.sleep(750);
                    } catch (InterruptedException e) {
                        System.out.println("Thread error");
                        e.printStackTrace();
                    }
                    System.out.println("Célébration\n");
                    echanger();
                    joueurActuel = equipeActuel.get(10);
                }
            }
        }
    
        arbitre.siffler();
    }
    public void pause(){
        // Respecter le temps de 0.75 seconde 
        try {
            Thread.sleep(750);
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
        for (int i = 0; i<11; i++){
            if(joueursActuels1.get(i).getNbBut()>0)
            System.out.println(joueursActuels1.get(i).getNom() + 
            ':' + joueursActuels1.get(i).getNbBut());
            score1 += joueursActuels1.get(i).getNbBut();
        }
        System.out.println(score1);
        System.out.println("Equipe 2 : " + equipe2.getNom());
        for (int i = 0; i<11; i++){
            if(joueursActuels2.get(i).getNbBut()>0)
            System.out.println(joueursActuels2.get(i).getNom() + 
            ':' + joueursActuels2.get(i).getNbBut());
            score2 += joueursActuels2.get(i).getNbBut();
        }
        System.out.println(score2);
    }

}
