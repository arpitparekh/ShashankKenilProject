package mridul.rathore.shashankkenilproject.passDataBetweenFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import mridul.rathore.shashankkenilproject.R;

public class MyHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_host);

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.myHostActivity,new MumbaiFragment());

        ft.commit();

    }
}