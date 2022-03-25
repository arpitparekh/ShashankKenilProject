package mridul.rathore.shashankkenilproject.mvvm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.FragmentRBinding;


public class RFragment extends Fragment {

    private FragmentRBinding binding;
    private MyViewModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentRBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSend.setOnClickListener(v -> {

            String data = binding.edtString.getText().toString();

            model.setLiveData(data);
        });

        model = new ViewModelProvider(requireActivity()).get(MyViewModel.class);

        model.getLiveData().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {

                binding.edtString.setText(s);
            }
        });

    }
}