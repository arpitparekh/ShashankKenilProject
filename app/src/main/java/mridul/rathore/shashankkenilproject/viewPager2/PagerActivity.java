package mridul.rathore.shashankkenilproject.viewPager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityPagerBinding;

public class PagerActivity extends AppCompatActivity {

    private ActivityPagerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),getLifecycle());

        binding.viewPager.setAdapter(adapter);

        binding.tabLayout.addTab(binding.tabLayout.newTab());
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Video"));

        TabLayout.Tab t1 = binding.tabLayout.getTabAt(0);
        TabLayout.Tab t2 = binding.tabLayout.getTabAt(1);

        t1.setIcon(R.drawable.ic_person);

        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
            }
        });

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


    }


}