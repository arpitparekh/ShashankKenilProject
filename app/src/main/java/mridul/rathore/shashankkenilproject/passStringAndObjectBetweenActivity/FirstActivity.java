package mridul.rathore.shashankkenilproject.passStringAndObjectBetweenActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import mridul.rathore.shashankkenilproject.R;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // pass String between activity

        FloatingActionButton button = findViewById(R.id.floatingActionButton);

        EditText editText = findViewById(R.id.edtName);

        button.setOnClickListener(v -> {

//            String data = editText.getText().toString();

            Data data =new Data(12,"Arpit",3434.3434f);

            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("object",data);
            startActivity(intent);

        });


    }
}