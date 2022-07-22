package models.personne.equipe;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.personne.joueur.JoueurFoot;

public class EquipeFoot extends Equipe{

    /**
     * Liste des joueurs dans l'équipe
     */

    private ArrayList<JoueurFoot> joueurs;

    /**
     * Liste des gardiens
     */
    private ArrayList<JoueurFoot> gardiens;
    /**
     * Liste des defenses
     */
    private ArrayList<JoueurFoot> defenses;
    /**
     * Liste des milieux
     */
    private ArrayList<JoueurFoot> milieux;
    /**
     * Liste des attaquants
     */
    private ArrayList<JoueurFoot> attaquants;


    public EquipeFoot() {
        setNom(null);
        this.joueurs = new ArrayList<JoueurFoot>();
    }

    public EquipeFoot(String nom) {
        setNom(nom);
        this.joueurs = new ArrayList<JoueurFoot>();
    }

    /**
     * Ajout d'un joueur dans l'équipe
     * 
     * @param joueur le joueur à ajouter
     */

    public void addJoueur(JoueurFoot joueur) {
        this.joueurs.add(joueur);
    }

    /**
     * 
     * @return la liste des joueurs
     */
    public ArrayList<JoueurFoot> getJoueurs(){
        return this.joueurs;
    }

    /**
     * Initialisation depuis un fichier
     * @param string
     * @param nomFichier le nom du fichier contenant les données
     */
    public void initialise(){
        try{
            File fichier = new File("./data/"+getNom()+".data");
            try (Scanner scanner = new Scanner(fichier)) {
                while(scanner.hasNextLine()){
                    String data = scanner.nextLine();
                    String[] splitArr = data.split(" ",0);
                    JoueurFoot joueur = new JoueurFoot();
                    joueur.setNom(splitArr[0]);
                    joueur.setSex(Integer.parseInt(splitArr[1]));
                    joueur.setPosition(splitArr[2]);
                    joueur.setAge(Integer.parseInt(splitArr[3]));
                    joueur.setNumero(Integer.parseInt(splitArr[4]));
                    //joueur.setCapacite(Integer.parseInt(splitArr[5]));
                    addJoueur(joueur);
                }
            } catch (NumberFormatException e) {
                System.out.println("erreur du scanner");
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("Impossible de lire le fichier");
            e.printStackTrace();
        }

    }

    public void sectionner(){
        this.gardiens =  new ArrayList<JoueurFoot>();
        this.defenses = new ArrayList<JoueurFoot>();
        this.milieux = new ArrayList<JoueurFoot>();
        this.attaquants = new ArrayList<JoueurFoot>();

        // String data = this.joueurs.get(0).getPosition();
        int i=0;
        while(this.joueurs.get(i).getPosition().charAt(0) == 'G'){
            this.gardiens.add(getJoueurs().get(i));
            i++;
        }
        while(this.joueurs.get(i).getPosition().charAt(0) == 'D'){
            this.defenses.add(getJoueurs().get(i));
            i++;
        }
        while(this.joueurs.get(i).getPosition().charAt(0) == 'M'){
            this.milieux.add(getJoueurs().get(i));
            i++;
        }
        while(this.joueurs.get(i).getPosition().charAt(0) == 'A'){
            this.attaquants.add(getJoueurs().get(i));
            i++;
            if(i>joueurs.size()-1)
                break;
        }
    }

    // Getters

    public ArrayList<JoueurFoot> getGardiens(){
        return this.gardiens;
    }
    public ArrayList<JoueurFoot> getDefenses(){
        return this.defenses;
    }
    public ArrayList<JoueurFoot> getMilieux(){
        return this.milieux;
    }
    public ArrayList<JoueurFoot> getAttaquants(){
        return this.attaquants;
    }

}
