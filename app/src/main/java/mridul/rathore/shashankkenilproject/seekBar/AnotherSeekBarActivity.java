package mridul.rathore.shashankkenilproject.seekBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.RangeSlider;

import java.util.List;

import mridul.rathore.shashankkenilproject.databinding.ActivityAnotherSeekBarBinding;

public class AnotherSeekBarActivity extends AppCompatActivity {
    private ActivityAnotherSeekBarBinding binding;
    private List<Float> numbers;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAnotherSeekBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnDownload.setOnClickListener(v -> {

            new Thread(new Runnable() {
                @Override
                public void run() {

                    for(x=0;x<=20;x++){
                        try {
                            binding.seekBar.setProgress(x);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }).start();

        });

        binding.rangeSlider.addOnChangeListener(new RangeSlider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {
                numbers = binding.rangeSlider.getValues();
                Toast.makeText(AnotherSeekBarActivity.this, numbers.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.rangeSlider.setLabelFormatter(new LabelFormatter() {
            @NonNull
            @Override
            public String getFormattedValue(float value) {

                return String.valueOf(value);
            }
        });


    }
}