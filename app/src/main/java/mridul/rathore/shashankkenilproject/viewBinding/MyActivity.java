package mridul.rathore.shashankkenilproject.viewBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import mridul.rathore.shashankkenilproject.databinding.ActivityMyBinding;

public class MyActivity extends AppCompatActivity {
    private ActivityMyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // viewBinding

        // bind your layout into activity



        binding.button5.setOnClickListener(v -> {

        });

        binding.textView2.setText("Tops");

        binding.floatingActionButton2.setOnClickListener(v -> {


        });
    }
}