package mridul.rathore.shashankkenilproject.drawer_toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyRailBinding;

public class MyRailActivity extends AppCompatActivity {
    private ActivityMyRailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyRailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.railview.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()== R.id.action_person_new){
                    item.setChecked(true);  // important
                }
                return false;
            }
        });

        binding.bottomAppBar.setNavigationOnClickListener(v -> {});

        binding.bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
    }
}