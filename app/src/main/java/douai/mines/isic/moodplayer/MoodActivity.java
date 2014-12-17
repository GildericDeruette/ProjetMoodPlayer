package douai.mines.isic.moodplayer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MoodActivity extends ActionBarActivity {

    Mood moodChosen= new Mood("Happy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        final Button btnHappy = (Button) findViewById(R.id.btnHappy);
        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoodActivity.this, PlayMusicMenu.class);
                moodChosen= new Mood("Happy");
                intent.putExtra("mood",moodChosen.getName());
                startActivity(intent);
            }
        });
        final Button btnCalm = (Button) findViewById(R.id.btnCalm);
        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoodActivity.this, PlayMusicMenu.class);
                moodChosen= new Mood("Calm");
                intent.putExtra("mood",moodChosen.getName());
                startActivity(intent);
            }
        });
        final Button btnUnHappy = (Button) findViewById(R.id.btnUnHappy);
        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoodActivity.this, PlayMusicMenu.class);
                moodChosen= new Mood("UnHappy");
                intent.putExtra("mood",moodChosen.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mood, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
