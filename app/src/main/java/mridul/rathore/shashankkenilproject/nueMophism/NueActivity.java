package mridul.rathore.shashankkenilproject.nueMophism;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import mridul.rathore.shashankkenilproject.databinding.ActivityNueBinding;

public class NueActivity extends AppCompatActivity {
    private ActivityNueBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNueBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}