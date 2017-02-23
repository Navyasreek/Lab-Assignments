package labassignment_4.assignment_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;


public class loginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void onButtonClick(View v)
    {
      if (v.getId()== R.id.signup1)
      {
          Intent i = new Intent( loginActivity.this,signup.class);
          startActivity(i);
      }
    }
    public void onLoginClick(View v)
    {
        if (v.getId()== R.id.image)
        {
            Intent i = new Intent( loginActivity.this,MapsActivity.class);
            startActivity(i);
        }
    }
}
