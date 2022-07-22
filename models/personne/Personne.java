package models.personne;
public class Personne{

    /**
     * nom de la personne
     */

    private String nom;

    /**
     * sexe de la personne
     */
    private int sex; 

    /**
     * age de la personne
     */

    private int age;

    /**
     * Valeurs par défaut:
     * nom : null
     * sex : 0 //HOMME
     * age : 0
     */

    public Personne(){
        this.nom = null;
        this.sex = 0;
        this.age = 0;
    }

    /// Getters
    public String getNom(){
        return this.nom;
    }
    public int getsex(){
        return this.sex;
    }
    public int getAge(){
        return this.age;
    }
    ///Setters
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setSex(int sex){
        this.sex = sex;        
    }
    public void setAge(int age){
        this.age = age;
    }

    public void about(){
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        System.out.println("Nom : " + this.nom + '\n');
        if(this.sex==0){
            System.out.println("Sex : Homme\n");
        }
        else{
            System.out.println("Sex : Femme\n");
        }
        System.out.println("Age : " + this.age + '\n');
    }

}