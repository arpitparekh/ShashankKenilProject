package mridul.rathore.shashankkenilproject.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import mridul.rathore.shashankkenilproject.R;

public class MyMvvmHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_mvvm_host);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.linearMvvm,new QFragment())
                .add(R.id.linearMvvm,new RFragment())
                .commit();
    }
}