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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gildéric on 10/12/2014.
 */
public class MPInterface extends ListActivity {

    private static final String MEDIA_PATH = new String("/sdcard/");
    private MediaPlayer mediaPlayer = new MediaPlayer();
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

        } catch (NullPointerException e) {
            Log.v(getString(R.string.app_name), e.getMessage());
        }
    }

}