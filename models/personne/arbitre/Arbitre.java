package models.personne.arbitre;

import models.personne.Personne;

public class Arbitre extends Personne{
    /**
     * position : Position de l'arbitre sur le terrain (Ex: principale, touche)
     */
    private String position;
    
    public Arbitre(){
        super();
        this.position = "principal";
    }

    public void siffler() {
        System.out.println("Arbitre " + this.position + " siffle\n");
    }

    
}
