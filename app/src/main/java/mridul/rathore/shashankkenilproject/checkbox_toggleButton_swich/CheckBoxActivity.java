package mridul.rathore.shashankkenilproject.checkbox_toggleButton_swich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Toast;

import mridul.rathore.shashankkenilproject.databinding.ActivityCheckBoxBinding;

public class CheckBoxActivity extends AppCompatActivity {
    private ActivityCheckBoxBinding binding;
    String hobbies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCheckBoxBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnShow.setOnClickListener(v -> {

            hobbies = "";

            if(binding.cb1.isChecked()){

                hobbies = hobbies + binding.cb1.getText().toString();
            }
            if(binding.cb2.isChecked()){

                hobbies = hobbies + binding.cb2.getText().toString();

            }
            if(binding.cb4.isChecked()){

                hobbies = hobbies + binding.cb4.getText().toString();

            }
            if(binding.cb5.isChecked()){

                hobbies = hobbies + binding.cb5.getText().toString();
            }

            Toast.makeText(this,hobbies,Toast.LENGTH_LONG).show();

        });




    }
}