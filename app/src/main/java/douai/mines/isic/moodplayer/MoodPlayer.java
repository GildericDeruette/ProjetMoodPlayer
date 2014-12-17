package douai.mines.isic.moodplayer;

import android.app.ListActivity;
import android.content.Intent;
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

    private static final String MEDIA_PATH = new String("emulated/storage/extSdCard/");
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private MoodPlayList moodPlayList= new MoodPlayList();
    private MoodPlayList moodPlayListSelected= new MoodPlayList();
    private CheckBox checkBox;
    private Mood humeurCourante=new Mood("nil");

    @Override
    public void onCreate(Bundle icicle) {
        Intent intent= getIntent();
        try {
            Boolean suggestedMode=intent.getBooleanExtra("mode", false);
           if (suggestedMode){
               String hum= intent.getStringExtra("Humeur");
                humeurCourante.setName(hum);
            }
           // humeurCourante=new Humeur("Joyeux");
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
        int i=0;
        File home = new File(MEDIA_PATH);
        if (home.listFiles( new MP3Filter()).length > 0) {
            for (File file : home.listFiles( new MP3Filter())) {
                Music muse=new Music(file);
                muse.setHumeurPrincipale(new Mood("joyeux"));
                moodPlayList.addSong(muse);
            }
            //moodPlayList.ecremerHumeur(humeurCourante);
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
    public void onClickButtonRetourPlayList(View v){
        ArrayAdapter<Music> songList = new ArrayAdapter<Music>(this,R.layout.song_item, moodPlayList.getListe());
        setListAdapter(songList);
    }

    public void onClickButtonRetourMenu(View v){
    }

    }
