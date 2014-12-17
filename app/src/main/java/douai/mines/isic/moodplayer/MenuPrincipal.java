package douai.mines.isic.moodplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Gildéric on 10/12/2014.
 */
public class MenuPrincipal extends Activity{


    private Button humeur_btn;
    private Button listeSelonHumeur_btn;
    private Button listeGlobale_btn;
    private EditText editText;


    @Override
    public void onCreate(Bundle icicle) {
        try {
            super.onCreate(icicle);
           setContentView(R.layout.accueilhumeur);
            this.initialiser();
            humeur_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editText.setText("111");

                    try{
                      //  Intent intent =new Intent(MenuPrincipal.this,FichierChoisir.class);
                     //   startActivityForResult(intent, MY_REQUEST_ID);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });



            listeSelonHumeur_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   // editText.setText("222");
                }
            });


            listeGlobale_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //editText.setText("333");


                }
            });
           // updateSongList();
        } catch (NullPointerException e) {
            Log.v(getString(R.string.app_name), e.getMessage());
        }
    }

    // initialiser tous les datas
    public void initialiser() {
        humeur_btn = (Button) findViewById(R.id.humeur_btn);
        listeSelonHumeur_btn = (Button) findViewById(R.id.listeSelonHumeur_btn);
        listeGlobale_btn = (Button) findViewById(R.id.listeGlobale_btn);

        Intent intent = getIntent();
        editText = (EditText) findViewById(R.id.editText);
        editText.setText(intent.getStringExtra("mood"));

    }

}