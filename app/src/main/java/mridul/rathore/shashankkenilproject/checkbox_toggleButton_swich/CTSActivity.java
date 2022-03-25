package mridul.rathore.shashankkenilproject.checkbox_toggleButton_swich;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.CompoundButton;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityCtsactivityBinding;

public class CTSActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private ActivityCtsactivityBinding binding;
    Boolean myBool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCtsactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.getRoot().setBackgroundColor(Color.GRAY);

        binding.tb.setOnCheckedChangeListener(this);
        binding.cb.setOnCheckedChangeListener(this);
        binding.sw.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        myBool = isChecked ;
        if(isChecked){
            buttonView.setButtonDrawable(R.drawable.ic_moon);
            binding.tb.setChecked(true);
            binding.cb.setChecked(true);
            binding.sw.setChecked(true);
            binding.getRoot().setBackgroundColor(Color.YELLOW);

        }
        else{
            buttonView.setButtonDrawable(R.drawable.ic_sun);
            binding.sw.setChecked(false);
            binding.cb.setChecked(false);
            binding.tb.setChecked(false);
            binding.getRoot().setBackgroundColor(Color.GRAY);
        }


    }
}