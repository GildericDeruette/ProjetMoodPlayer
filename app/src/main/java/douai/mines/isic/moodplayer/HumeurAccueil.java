package douai.mines.isic.moodplayer;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by donna on 17/12/2014.
 */
public class HumeurAccueil extends Activity {

    private Button humeur_btn;
    private Button listeSelonHumeur_btn;
    private Button listeGlobale_btn;
    private TextView untexteView;
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.accueilHumeur);

        humeur_btn.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {

                untexteView.setText("heelllo");

            }
        });

        listeSelonHumeur_btn.setOnClickListener(new OnClickListener() {
         @Override
            public void onClick(View v) {


            }
        });


        listeGlobale_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }
}
