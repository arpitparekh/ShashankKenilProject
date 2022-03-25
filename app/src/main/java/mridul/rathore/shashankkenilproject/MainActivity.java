package mridul.rathore.shashankkenilproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Hello");
        Button button = findViewById(R.id.btnSubmit);
        Button button1 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"Hello Student",Toast.LENGTH_LONG).show();

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //explicit intent
                Intent i =new Intent(MainActivity.this,AnotherActivity.class);  // explicit intent
                startActivity(i);

                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("tag","resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("tag","stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("tag","start");
    }

    @Override
    protected void onDestroy() {    // on destroy not working
        super.onDestroy();
        Log.i("tag","Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("tag","Pause");
    }
}