package labassignment_4.assignment_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;



public class loginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        if (v.getId()== R.id.login)
        {
            Intent i = new Intent( loginActivity.this,MapsActivity.class);
            startActivity(i);
        }
    }
}
