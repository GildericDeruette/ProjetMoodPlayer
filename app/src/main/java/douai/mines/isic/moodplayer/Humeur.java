package douai.mines.isic.moodplayer;

/**
 * Created by Gildéric on 17/12/2014.
 */
public class Humeur {

    public Humeur(){
        libelle="Nil";
    }

    public Humeur(String uneHumeur){
        libelle=uneHumeur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    private String libelle;
}
