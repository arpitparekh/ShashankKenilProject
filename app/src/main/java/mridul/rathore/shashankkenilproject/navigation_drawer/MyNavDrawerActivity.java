package mridul.rathore.shashankkenilproject.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyNavDrawerBinding;

public class MyNavDrawerActivity extends AppCompatActivity {
    private ActivityMyNavDrawerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyNavDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.action_settings){
                    Toast.makeText(MyNavDrawerActivity.this, "This is Setting From Drawer", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_person){
                    Toast.makeText(MyNavDrawerActivity.this, "This is Person From Drawer", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_logout){
                    Toast.makeText(MyNavDrawerActivity.this, "This is Logout From Drawer", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_sun){
                    Toast.makeText(MyNavDrawerActivity.this, "This is Sun From Drawer", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        getSupportActionBar().hide();

        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(v -> {

            binding.drawer.openDrawer(Gravity.LEFT);

        });

        toolbar.inflateMenu(R.menu.drawer_menu);  // insert menu in toolbar

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.action_settings){
                    Toast.makeText(MyNavDrawerActivity.this, "This is Setting From Toolbar", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_person){
                    Toast.makeText(MyNavDrawerActivity.this, "This is Person From Toolbar", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_logout){
                    Toast.makeText(MyNavDrawerActivity.this, "This is Logout From Toolbar", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_sun){
                    Toast.makeText(MyNavDrawerActivity.this, "This is Sun From Toolbar", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        binding.bottomAppBar.setNavigationOnClickListener(v -> {
            binding.drawer.openDrawer(Gravity.LEFT);

        });


        binding.railView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.action_settings){
                    item.setChecked(true);
                    Toast.makeText(MyNavDrawerActivity.this, "This is Setting From Rail", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_person){
                    item.setChecked(true);
                    Toast.makeText(MyNavDrawerActivity.this, "This is Person From Rail", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_logout){
                    item.setChecked(true);
                    Toast.makeText(MyNavDrawerActivity.this, "This is Logout From Rail", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_sun){
                    item.setChecked(true);
                    Toast.makeText(MyNavDrawerActivity.this, "This is Sun From rail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });


        binding.bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.action_settings){
                    item.setChecked(true);
                    Toast.makeText(MyNavDrawerActivity.this, "This is Setting From Bottom AppBAr", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_person){
                    item.setChecked(true);
                    Toast.makeText(MyNavDrawerActivity.this, "This is Person From Bottom AppBAr", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_logout){
                    item.setChecked(true);
                    Toast.makeText(MyNavDrawerActivity.this, "This is Logout From Bottom AppBAr", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.action_sun){
                    item.setChecked(true);
                    Toast.makeText(MyNavDrawerActivity.this, "This is Sun From Bottom AppBAr", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        binding.floatingActionButton.setOnClickListener(v -> {

            Toast.makeText(MyNavDrawerActivity.this, "This is Floating button", Toast.LENGTH_SHORT).show();

        });




    }
}