package models.personne.equipe;

public class Equipe {

    /**
     * nom de l'équipe
     */
    private String nom;
    /**
     * nb des joueurs dans l'equipe
     */
    private int nbJoueurs = 0;
    
    // Getters
    public String getNom(){
        return nom;
    }

    public int getNbJoueurs(){
        return nbJoueurs;
    }
    // Setters
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setNbJoueurs(int n){
        this.nbJoueurs = n;
    }

}
