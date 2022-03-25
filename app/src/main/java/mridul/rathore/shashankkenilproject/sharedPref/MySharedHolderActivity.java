package mridul.rathore.shashankkenilproject.sharedPref;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import mridul.rathore.shashankkenilproject.R;


public class MySharedHolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shared_holder);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.prefHolder,new SecondLoginFragment())
                .commit();

    }
}