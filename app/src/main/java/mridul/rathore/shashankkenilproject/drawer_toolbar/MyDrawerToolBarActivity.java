package mridul.rathore.shashankkenilproject.drawer_toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyDrawerToolBarBinding;
import mridul.rathore.shashankkenilproject.databinding.HeaderLayoutBinding;
import mridul.rathore.shashankkenilproject.databinding.MyHeaderLayoutNewBinding;
import mridul.rathore.shashankkenilproject.databinding.MyToolbarNewBinding;

public class MyDrawerToolBarActivity extends AppCompatActivity {
    private ActivityMyDrawerToolBarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyDrawerToolBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.outerTolBar.setNavigationOnClickListener(v -> {

            binding.drawerNew.openDrawer(Gravity.LEFT);
        });

////        binding.toolbarNew.imageViewToolBar.setOnClickListener(v -> {
//
//            binding.drawerNew.openDrawer(Gravity.RIGHT);
//        });

        binding.navDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;
            }
        });

        View view = binding.navDrawer.getHeaderView(0);

        view.findViewById(R.id.imageViewPerson).setOnClickListener(v -> {

            Toast.makeText(MyDrawerToolBarActivity.this, "Hello", Toast.LENGTH_SHORT).show();

        });

    }
}