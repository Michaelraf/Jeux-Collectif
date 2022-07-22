package view;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author RAFALIMANANA Michaël
 */

public class Menu {
    /**
     * Attribut contenant la liste des choix dans le menu
     */
    private ArrayList<String> items;
    /**
     * Description du menu
     */
    private String description;
    
    /**
     * Le choix de l'utilisateur
     */
    private int choix;

    /**
     * Constructeur
     * @param description la déscription du menu en cours
     */

    public Menu(String description){
        this.description = description;
        this.items = new ArrayList<String>();
        items.add("Quitter");
    }
    /**
     * Destructeur
     */

    /**
     * Ajout d'un élément dans item
     * 
     * @param item l'item à ajouter
     */
    public void addItem(String item){
        this.items.add(item);
    }

    /**
     * Affichage du menu
     */
    public void display(){
        System.out.println("************ "+description+" *************\n");
        for (int i=0; i<items.size() ; i++){
            System.out.println(Integer.toString(i)+" : "+items.get(i)+'\n');
        }
    }
    /**
     * 
     * @return le choix de l'utilisateur
     */
    public int getChoix(){
        Scanner scanner1 = new Scanner(System.in);
        this.choix = Integer.parseInt(scanner1.nextLine());
        if(this.choix==0){
            System.out.println("Arrêt en cours...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Thread error");
                e.printStackTrace();
            }
            System.exit(0);
        }
        return this.choix;
    }
}