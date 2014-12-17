package douai.mines.isic.moodplayer;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;

/**
 * Created by zzmax_000 on 17/12/2014.
 */
public class MPInterface extends ListActivity {


    private static final String MEDIA_PATH = new String("/res/");
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private MoodPlayList moodPlayList= new MoodPlayList();
    private ImageButton playBtn = null;
    private ImageButton pauseBtn = null;
    private Button nextButton = null;

    @Override
    public void onCreate(Bundle icicle) {
        try {
            super.onCreate(icicle);
            setContentView(R.layout.mediaplayer);
            playBtn = (ImageButton)findViewById(R.id.playBtn);
            pauseBtn = (ImageButton)findViewById(R.id.pauseBtn);
            updateSongList();
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

            ArrayAdapter<String> songList = new ArrayAdapter<String>(this,R.layout.song_item, moodPlayList.getListe());
            setListAdapter(songList);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        try {
            playBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mediaPlayer.isPlaying()){
                        mediaPlayer.pause();
                        //playBtn.setBackgroundResource(
                              //  R.drawable.play_selecor);
                    } else{
                        mediaPlayer.start();
                        //playBtn.setBackgroundResource(
                               // R.drawable.pause_selecor);

                    }
                }
            });
            //mediaPlayer.reset();
            mediaPlayer.setDataSource(MEDIA_PATH + moodPlayList.getListe().get(position));
           // mediaPlayer.prepare();

        } catch(IOException e) {
            Log.v(getString(R.string.app_name), e.getMessage());
        }
    }
}
