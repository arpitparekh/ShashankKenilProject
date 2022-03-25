package mridul.rathore.shashankkenilproject.coordinatorLAyout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import mridul.rathore.shashankkenilproject.databinding.ActivityCoBinding;

public class CoActivity extends AppCompatActivity {
    private ActivityCoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.button6.setOnClickListener(v -> {
//
//            Snackbar.make(binding.getRoot(),"This is SnackBar",Snackbar.LENGTH_SHORT).show();
//
//        });

    }
}