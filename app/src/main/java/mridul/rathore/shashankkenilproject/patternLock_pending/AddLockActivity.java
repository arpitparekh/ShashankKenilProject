package mridul.rathore.shashankkenilproject.patternLock_pending;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import mridul.rathore.shashankkenilproject.databinding.ActivityAddLockBinding;

public class AddLockActivity extends AppCompatActivity {
    private ActivityAddLockBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddLockBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}