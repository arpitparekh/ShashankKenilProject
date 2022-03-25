package mridul.rathore.shashankkenilproject.passDataBetweenFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.FragmentMumbaiBinding;


public class MumbaiFragment extends Fragment {

    private FragmentMumbaiBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentMumbaiBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.myEfb.shrink();

        binding.myEfb.setOnClickListener(v -> {

            if(!binding.myEfb.isExtended()){
                binding.myEfb.extend();
            }else{

                String data = binding.editTextTextPersonName3.getText().toString();

                Bundle b = new Bundle();

                b.putString("data",data);

                requireActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.myHostActivity,GoaFragment.class,b)
                        .addToBackStack("mumbai")
                        .commit();

            }






        });

    }
}