package models.personne.equipe;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.personne.joueur.JoueurBasket;
public class EquipeBasket extends Equipe{
        /**
     * Liste des joueurs dans l'équipe
     */

    private ArrayList<JoueurBasket> joueurs;

    /**
     * Liste des gardiens
     */
    private ArrayList<JoueurBasket> arriere;
    /**
     * Liste des defenses
     */
    private ArrayList<JoueurBasket> aillier;
    /**
     * Liste des milieux
     */
    private ArrayList<JoueurBasket> pivot;
    /**
     * Liste des attaquants
     */
    private ArrayList<JoueurBasket> meneur;


    public EquipeBasket() {
        setNom(null);
        this.joueurs = new ArrayList<JoueurBasket>();
    }

    public EquipeBasket(String nom) {
        setNom(nom);
        this.joueurs = new ArrayList<JoueurBasket>();
    }

    /**
     * Ajout d'un joueur dans l'équipe
     * 
     * @param joueur le joueur à ajouter
     */

    public void addJoueur(JoueurBasket joueur) {
        this.joueurs.add(joueur);
    }

    /**
     * 
     * @return la liste des joueurs
     */
    public ArrayList<JoueurBasket> getJoueurs(){
        return this.joueurs;
    }

    /**
     * Initialisation depuis un fichier
     * @param string
     * @param nomFichier le nom du fichier contenant les données
     */
    public void initialise(){
        this.meneur =  new ArrayList<JoueurBasket>();
        this.arriere = new ArrayList<JoueurBasket>();
        this.aillier = new ArrayList<JoueurBasket>();
        this.pivot = new ArrayList<JoueurBasket>();
        try{
            File fichier = new File("./data/"+getNom()+".data");
            try (Scanner scanner = new Scanner(fichier)) {
                while(scanner.hasNextLine()){
                    String data = scanner.nextLine();
                    String[] splitArr = data.split(" ",0);
                    JoueurBasket joueur = new JoueurBasket();
                    joueur.setNom(splitArr[0]);
                    joueur.setSex(Integer.parseInt(splitArr[1]));
                    joueur.setPosition(splitArr[2]);
                    joueur.setAge(Integer.parseInt(splitArr[3]));
                    joueur.setNumero(Integer.parseInt(splitArr[4]));
                    //joueur.setCapacite(Integer.parseInt(splitArr[5]));
                    addJoueur(joueur);
                }
            } catch (NumberFormatException e) {
                System.out.println("erreur du scanner dans EquipeBasket");
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("Impossible de lire le fichier");
            e.printStackTrace();
        }

    }

    public void sectionner(){

        int i=0;
        while(joueurs.get(i).getPosition().charAt(0) == 'L'){
            arriere.add(getJoueurs().get(i));
            i++;
        }
        while(joueurs.get(i).getPosition().charAt(0) == 'A'){
            aillier.add(getJoueurs().get(i));
            i++;
        }
        while(joueurs.get(i).getPosition().charAt(0) == 'M'){
            meneur.add(getJoueurs().get(i));
            i++;
        }
        while(joueurs.get(i).getPosition().charAt(0) == 'P'){
            pivot.add(getJoueurs().get(i));
            i++;
            if(i>joueurs.size()-1)
                break;
        }
    }

    // Getters

    public ArrayList<JoueurBasket> getMeneur(){
        return meneur;
    }
    public ArrayList<JoueurBasket> getArriere(){
        return arriere;
    }
    public ArrayList<JoueurBasket> getAillier(){
        return aillier;
    }
    public ArrayList<JoueurBasket> getPivot(){
        return pivot;
    }
}
