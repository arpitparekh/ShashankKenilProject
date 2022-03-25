package mridul.rathore.shashankkenilproject.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mridul.rathore.shashankkenilproject.databinding.ActivityValidationBinding;

public class ValidationActivity extends AppCompatActivity {
    private ActivityValidationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityValidationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.button6.setOnClickListener(v -> {

            String email = binding.edtData.getText().toString();

            // compare string to regex pattern

            Pattern pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+");

            Matcher matcher = pattern.matcher(email);

            if(matcher.matches()){
                Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
            }

        });
    }
}