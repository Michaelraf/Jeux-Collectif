package models.personne.joueur;

public class JoueurBasket extends Joueur{
    
    /**
     * Nombre de but marqué par le joueur
     */
    private int nbBut;

    public JoueurBasket(){
        super();
        this.nbBut = 0;
    }
    public void jouer(){
        System.out.println(getNom()+" reçoit le ballon\n");
    }
    // Setters

    // Getters
    public int getNbBut(){
        return this.nbBut;
    }

    public void dribbler(){
        System.out.println(getNom() + " dribble\n");
    }
    
    public void passer(String joueur2){
        System.out.println(getNom() + " fait une passe à " + joueur2 + '\n');
    }

    public void tirer(){
        System.out.println(getNom() + " lance au panier\n");
    }

    public void charger(){

    }

    public void intercepter(){
        System.out.println(getNom() + " intercepte\n");
    }
    /**
     * Incremente le nombre de but du joueur
     */

    public void marquer2Pts(){
        System.out.println(getNom() + " marque\n");
        this.nbBut += 2;
    }
    public void marquer3Pts(){
        System.out.println(getNom() + " marque\n");
        this.nbBut += 3;
    }
    
    public void about(){
        super.about();
        System.out.println("Nombre de panier : " + this.nbBut + '\n');
    }
}
