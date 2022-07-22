package models.personne.joueur;

import models.personne.Personne;

public class Joueur extends Personne{

    /**
     * Poste du joueur
     */
    private String position;
    /**
     * Numéro du joueur
     */
    private int numero;
    /**
     * Condition du joueur : de 4 (excellente) à 1(piteuse)
     */
    private int condition;
    /**
     * Etat du joueur :  de 10 (en forme) à 1 (très fatigué)
     */
    private int etat;
    /**
     * Capacité : de 1 (trés faible) à 10 (très fort)
    */
    private int capacite;

    public Joueur(){
        super();
        this.position = null;
        this.numero = 0;
        this.condition = 4;
        this.etat = 10;
        this.capacite = 10;
    }

    // Setters

    public void setPosition(String position){
        this.position = position;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public void setCondition(int condition){
        this.condition = condition;
    }
    public void setEtat(int etat){
        this.etat = etat;
    }
    public void setCapacite(int capacite){
        this.capacite = capacite;
    }

    // Getters

    public String getPosition(){
        return this.position;
    }
    public int getCondition(){
        return this.condition;
    }
    public int getEtat(){
        return this.etat;
    }

    public int getNumero(){
        return this.numero;
    }
    public int getCapacite(){
        return this.capacite;
    }


    public void seFatiguer(){
        this.etat--;
    }


    public void seBlesser(){
        this.condition -=2;
        this.capacite -=2;
    }

    /**
     * 
     */
    public void about(){
        super.about();
        System.out.println("Position : " + this.position + '\n');
        System.out.println("Numéro : " + this.numero + '\n');
        System.out.println("Condition : " + this.condition + '\n');
        System.out.println("Etat : " + this.etat + '\n');
        System.out.println("Capacité : " + this.capacite + '\n');

    }
    
}
