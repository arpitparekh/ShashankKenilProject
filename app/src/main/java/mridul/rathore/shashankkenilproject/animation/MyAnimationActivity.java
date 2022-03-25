package mridul.rathore.shashankkenilproject.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyAnimationBinding;

public class MyAnimationActivity extends AppCompatActivity {

    private ActivityMyAnimationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyAnimationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSlide.setOnClickListener(view -> {

            Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_translate);

            binding.ivAnim.startAnimation(animation);

        });

        binding.btnRotate.setOnClickListener(view -> {

            Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation_rotate);
            binding.ivAnim.startAnimation(animation);
        });

        binding.btnZoom.setOnClickListener(view -> {

            Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation_zoom);
            binding.ivAnim.startAnimation(animation);
        });

        binding.btnBlink.setOnClickListener(view -> {

            Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation_blink);
            binding.ivAnim.startAnimation(animation);

        });
    }
}