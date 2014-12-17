package douai.mines.isic.moodplayer;

/**
 * Created by Gildéric on 17/12/2014.
 */
public class Mood {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Mood(String name) {
        this.name = name;
    }
}
