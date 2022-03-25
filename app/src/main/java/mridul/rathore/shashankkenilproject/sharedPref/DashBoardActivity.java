package mridul.rathore.shashankkenilproject.sharedPref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;

import mridul.rathore.shashankkenilproject.R;

public class DashBoardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        Button button = findViewById(R.id.btnLogout);

        SharedPreferences preferences = getSharedPreferences("register", MODE_PRIVATE);
        SharedPreferences.Editor editor =  preferences.edit();

        button.setOnClickListener(v -> {

            editor.putBoolean("login",false);
            editor.apply();
            startActivity(new Intent(this,MySharedHolderActivity.class));

        });
    }
}