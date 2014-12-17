package douai.mines.isic.moodplayer;

import java.io.File;

/**
 * Created by Gildéric on 17/12/2014.
 */
public class Music {
    private String nom;
    private File fichier;
    private Mood humeurPrincipale;

    public Music(File fichier){
        this.fichier=fichier;
        this.nom=fichier.getName();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public File getFichier() {
        return fichier;
    }

    public void setFichier(File fichier) {
        this.fichier = fichier;
    }

    public Mood getHumeurPrincipale() {
        return humeurPrincipale;
    }

    public void setHumeurPrincipale(Mood humeurPrincipale) {
        this.humeurPrincipale = humeurPrincipale;
    }
    public String toString(){
        return nom;
    }

}
