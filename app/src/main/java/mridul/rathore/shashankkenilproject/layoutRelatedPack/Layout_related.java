package mridul.rathore.shashankkenilproject.layoutRelatedPack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.LayoutFrameBinding;
import mridul.rathore.shashankkenilproject.databinding.LayoutRelativeBinding;

public class Layout_related extends AppCompatActivity {
    private LayoutFrameBinding binding;
    private LayoutRelativeBinding binding1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=LayoutFrameBinding.inflate(getLayoutInflater());
        binding1=LayoutRelativeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        // View

        // View

        // ViewGroup

    }
}