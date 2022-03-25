package mridul.rathore.shashankkenilproject.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.navigation_androidx.AnotherHostActivity;

public class MySplashScrrenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_splash_scrren);


        // Handler

        // UI Thread

        new Handler().postDelayed(() -> {

            Intent i = new Intent(MySplashScrrenActivity.this, AnotherHostActivity.class);
            startActivity(i);
            finish();

        },3000);

    }
}