package mridul.rathore.shashankkenilproject.passStringAndObjectBetweenActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import mridul.rathore.shashankkenilproject.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

//        String data = intent.getStringExtra("string");

        Data data = (Data) intent.getSerializableExtra("object");

        TextView tv = findViewById(R.id.tvName);

        tv.setText(data.toString());


    }
}