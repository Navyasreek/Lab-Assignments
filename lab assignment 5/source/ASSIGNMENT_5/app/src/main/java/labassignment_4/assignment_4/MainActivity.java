package labassignment_4.assignment_4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    public static boolean cam_flag = false;
    public static boolean browse_flag = false;
    public static String picturePath;//refer to browse file
    public static ImageView BrowseView;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onimageClick(View v) {
        if (v.getId() == R.id.signup1) {
            Intent i = new Intent(MainActivity.this, Photo.class);
            startActivity(i);
        }
    }

    public void onLocateClick(View v) {
        if (v.getId() == R.id.signup1) {
            Intent i = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(i);
        }
    }

}