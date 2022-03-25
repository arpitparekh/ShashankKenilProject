package mridul.rathore.shashankkenilproject.tabview_viewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyWhatsappLikeBinding;

public class MyWhatsappLikeActivity extends AppCompatActivity {
    private ActivityMyWhatsappLikeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyWhatsappLikeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tabLayout.addTab(binding.tabLayout.newTab());
        binding.tabLayout.addTab(binding.tabLayout.newTab());
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Status"));

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),getLifecycle());

        binding.viewPager.setAdapter(adapter);

        binding.tabLayout.getTabAt(0).setIcon(R.drawable.ic_sun);
        binding.tabLayout.getTabAt(1).setIcon(R.drawable.ic_moon);
        binding.tabLayout.getTabAt(2).setIcon(R.drawable.ic_person);



        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
            }
        });
    }
}