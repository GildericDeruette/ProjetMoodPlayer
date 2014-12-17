package douai.mines.isic.moodplayer;

import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gildéric on 10/12/2014.
 */
public class MoodPlayer extends ListActivity {

    private static final String MEDIA_PATH = new String("/storage/extSdCard/");
    private List<String> songs = new ArrayList<String>();
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    public void onCreate(Bundle icicle) {
        try {
            super.onCreate(icicle);
            setContentView(R.layout.songlist);
            updateSongList();
        } catch (NullPointerException e) {
            Log.v(getString(R.string.app_name), e.getMessage());
        }
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
<<<<<<< HEAD
            mp.reset();
            mp.setDataSource(MEDIA_PATH + songs.get(position));
            mp.prepare();
            mp.start();
=======

            mediaPlayer.reset();
            mediaPlayer.setDataSource(MEDIA_PATH + songs.get(position));
            mediaPlayer.prepare();
            mediaPlayer.start();
>>>>>>> 58a207501ccee3a038fc3dc2dc62974129125ab4
        } catch(IOException e) {
            Log.v(getString(R.string.app_name), e.getMessage());
        }
    }
}