package models.jeux;

public interface Jeux {

    /**
     * Preparation d'avant jeu
     */
    public void preparer();
    /**
     * lancement du jeu
     */
    public void jouer();
    /**
     * pause
     */
    public void pause();
    /**
     * arrêt du jeu
     */
    public void fin();
}
