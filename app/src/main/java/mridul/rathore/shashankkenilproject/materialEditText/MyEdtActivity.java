package mridul.rathore.shashankkenilproject.materialEditText;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import mridul.rathore.shashankkenilproject.databinding.ActivityMyEdtBinding;

public class MyEdtActivity extends AppCompatActivity {
    private ActivityMyEdtBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyEdtBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}