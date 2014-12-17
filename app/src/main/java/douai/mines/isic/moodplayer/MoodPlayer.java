package douai.mines.isic.moodplayer;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * Created by Gildéric on 10/12/2014.
 */
public class MoodPlayer extends ListActivity {

    private static final String MEDIA_PATH = new String("/sdcard/");
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private MoodPlayList moodPlayList= new MoodPlayList();
    private MoodPlayList moodPlayListSelected= new MoodPlayList();
    private CheckBox checkBox;

    @Override
    public void onCreate(Bundle icicle) {
        try {
            super.onCreate(icicle);
            setContentView(R.layout.songlist);
            updateSongList();
            moodPlayListSelected = new MoodPlayList();
            checkBox = (CheckBox) findViewById(R.id.checkbox);
        } catch (NullPointerException e) {
            Log.v(getString(R.string.app_name), e.getMessage());
        }
    }

    public void updateSongList() {
        File home = new File(MEDIA_PATH);
        if (home.listFiles( new MP3Filter()).length > 0) {
            for (File file : home.listFiles( new MP3Filter())) {
                moodPlayList.addSong(new Music(file));
            }
            ArrayAdapter<Music> songList = new ArrayAdapter<Music>(this,R.layout.song_item, moodPlayList.getListe());
            setListAdapter(songList);
        }
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        try {

            mediaPlayer.reset();
            mediaPlayer.setDataSource(MEDIA_PATH + moodPlayList.getListe().get(position));
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch(IOException e) {
            Log.v(getString(R.string.app_name), e.getMessage());
        }
    }

    public void onClickCheckBox(View v) {
        try {
           mediaPlayer.reset();
           CheckBox laBox= (CheckBox) v;
            int position=moodPlayList.findByTitle((String) laBox.getText());
           if(laBox.isChecked()){
                moodPlayListSelected.addSong((Music) moodPlayList.getListe().get(position));
           }
            else{
               moodPlayListSelected.removeMusic((Music) moodPlayList.getListe().get(position));
            };
           mediaPlayer.setDataSource(MEDIA_PATH + moodPlayList.getListe().get(position));
           mediaPlayer.prepare();
           mediaPlayer.start();
        } catch(IOException e) {
            Log.v(getString(R.string.app_name), e.getMessage());
        }}

    public void onClickButtonOk(View v){
            ArrayAdapter<Music> songList = new ArrayAdapter<Music>(this,R.layout.song_item, moodPlayListSelected.getListe());
            setListAdapter(songList);
        }
    }