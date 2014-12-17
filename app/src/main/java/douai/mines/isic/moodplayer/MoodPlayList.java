package douai.mines.isic.moodplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gildéric on 17/12/2014.
 */
public class MoodPlayList {
    private List<Music> liste;

    public MoodPlayList(){
        liste= new ArrayList<Music>();
    }
    public void addSong(Music musique){
        liste.add(musique);
    }

    public void removeMusic(Music musique){
        liste.remove(musique);
    }

    public List getListe() {
        return liste;
    }

    public void setListe(List<Music> liste) {
        this.liste = liste;
    }

    public int findByTitle(String title){
        int resultat=-1;
        for (int i=0; i< liste.size();i++){
            if(liste.get(i).toString().equals(title)){
                resultat=i;
            }
        }
        return resultat;
    }

    public void ecremerHumeur(Mood humeur){
        ArrayList<Music> resultat= new ArrayList();
        for (int i=0; i< liste.size();i++){
            if(liste.get(i).getHumeurPrincipale().equals(humeur)){
                resultat.add(liste.get(i));
            }
        }
        liste= resultat;
    }
}
