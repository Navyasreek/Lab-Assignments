package labassignment_4.assignment_4;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;
import java.io.IOException;

import static labassignment_4.assignment_4.MainActivity.browse_flag;
import static labassignment_4.assignment_4.MainActivity.cam_flag;


public class Photo extends AppCompatActivity {
    int TAKE_PHOTO_CODE = 0;

    public static Bitmap photo;

    ImageView userImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        Button capture = (Button) findViewById(R.id.btn_take_photo);
        userImage = (ImageView) findViewById(R.id.view_photo);
        //take photo Button click eventlistener. Initializes the camera.
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
            }
        });
    }
    //If the photo is captured then set the image view to the photo captured.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");

            userImage.setImageBitmap(photo);
            cam_flag = true;//setting up cam flag to know the cam pic is active.
            browse_flag = false;//setting up bowser to false.
            Log.d("CameraDemo", "Pic saved");
        }
    }

}
