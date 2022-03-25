package mridul.rathore.shashankkenilproject.tabview_viewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyPagerAdapter extends FragmentStateAdapter {

    public MyPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){

            return new OneFragment();
        }else if(position==1){

            return new TwoFragment();
        }else if(position==2){

            return new ThreeFragment();
        }
        return new OneFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
