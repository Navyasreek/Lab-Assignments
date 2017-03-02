package cardboard.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.R.attr.button;

public class MainActivity extends Activity {

    private TextView mTextView;
   Button roll;
    ImageView Dice;
    Random r;
    int rolledNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                roll = (Button)findViewById(R.id.roll);
                Dice = (ImageView) findViewById(R.id.imageView);
                r = new Random();
                roll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rolledNumber = r.nextInt(6)+1;
                        if (rolledNumber == 1){
                            Dice.setImageResource(R.drawable.ii);
                        }
                        else if (rolledNumber == 2){
                            Dice.setImageResource(R.drawable.i);
                        }
                        else if (rolledNumber == 3){
                            Dice.setImageResource(R.drawable.im);
                        }
                        else if (rolledNumber == 4){
                            Dice.setImageResource(R.drawable.ima);
                        }
                        else if (rolledNumber == 5){
                            Dice.setImageResource(R.drawable.imag);
                        }
                        Toast.makeText(MainActivity.this,"Rolled!",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
