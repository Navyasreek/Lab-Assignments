package labassignment_4.assignment_4;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class App_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app__page);
    }

public void onSpeakClick(View v) {
    if (v.getId()== R.id.bspeak)
    {
    TextView Result = (TextView)findViewById(R.id.tvResult);
        promptSpeechInput();
    }
}
    public void promptSpeechInput(){

        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say Something!!");

     try{
   startActivityForResult(i,100);
    }
     catch (ActivityNotFoundException a)
     {
         Toast.makeText(App_Page.this,"Sorry your device doesnt support current language",Toast.LENGTH_LONG).show();
        }
    }
}
