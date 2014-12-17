package douai.mines.isic.moodplayer;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.os.IBinder;
import android.widget.TextView;

/**
 * Created by Gildéric on 10/12/2014.
 */
public class MoodPlayer extends ListActivity {

    private static final String MEDIA_PATH = new String("/sdcard/");
    private List<String> songs = new ArrayList<String>();
    private MediaPlayer mp = new MediaPlayer();
    private Button humeur_btn;
    private Button listeSelonHumeur_btn;
    private Button listeGlobale_btn;
    private TextView untexteView;

    @Override
    public void onCreate(Bundle icicle) {
        try {
            super.onCreate(icicle);
            setContentView(R.layout.accueilHumeur);
            this.initialiser();
            humeur_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    untexteView.setText("helllo");
                }
            });


            listeSelonHumeur_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    untexteView.setText("helllo2");

                }
            });


            listeGlobale_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    untexteView.setText("helllo3");

                }
            });
            updateSongList();
        } catch (NullPointerException e) {
            Log.v(getString(R.string.app_name), e.getMessage());
        }
    }

    // initialiser tous les datas
    public void initialiser() {
        humeur_btn = (Button) findViewById(R.id.humeur_btn);
        listeSelonHumeur_btn = (Button) findViewById(R.id.listeSelonHumeur_btn);
        listeGlobale_btn = (Button) findViewById(R.id.listeGlobale_btn);
        untexteView = (TextView) findViewById(R.id.untexteView);



    }
    public void updateSongList() {
        File home = new File(MEDIA_PATH);
        if (home.listFiles( new MP3Filter()).length > 0) {
            for (File file : home.listFiles( new MP3Filter())) {
                songs.add(file.getName());
            }

            ArrayAdapter<String> songList = new ArrayAdapter<String>(this,R.layout.song_item,songs);
            setListAdapter(songList);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        try {

            mp.reset();
            mp.setDataSource(MEDIA_PATH + songs.get(position));
            mp.prepare();
            mp.start();
        } catch(IOException e) {
            Log.v(getString(R.string.app_name), e.getMessage());
        }
    }
}