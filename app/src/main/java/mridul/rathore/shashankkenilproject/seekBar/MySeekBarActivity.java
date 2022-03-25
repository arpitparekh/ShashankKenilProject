package mridul.rathore.shashankkenilproject.seekBar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import mridul.rathore.shashankkenilproject.databinding.ActivityMySeekBarBinding;

public class MySeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private ActivityMySeekBarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMySeekBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.seekBar1.setOnSeekBarChangeListener(this);
        binding.seekBar2.setOnSeekBarChangeListener(this);
        binding.seekBar3.setOnSeekBarChangeListener(this);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        int red = binding.seekBar1.getProgress();
        int green = binding.seekBar2.getProgress();
        int blue = binding.seekBar3.getProgress();

        Log.i("rgb",red+" " +green+" "+blue);

        binding.imageViewColorCode.setBackgroundColor(Color.rgb(red,green,blue));

        binding.textView6.setText("red : "+red+" green : "+green+" blue : "+blue);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}