package mridul.rathore.shashankkenilproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        setTitle("Another Activity");

    }
}