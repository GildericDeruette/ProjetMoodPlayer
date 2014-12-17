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
}
