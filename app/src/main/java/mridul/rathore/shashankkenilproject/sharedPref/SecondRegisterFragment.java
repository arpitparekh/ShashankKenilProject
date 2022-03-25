package mridul.rathore.shashankkenilproject.sharedPref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mridul.rathore.shashankkenilproject.databinding.FragmentSecondRegisterBinding;


public class SecondRegisterFragment extends Fragment {


    private FragmentSecondRegisterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentSecondRegisterBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences preferences = getContext().getSharedPreferences("register", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        binding.btnSend.setOnClickListener(v -> {

            String email = binding.edtEmail.getText().toString();
            String password = binding.edtPassword.getText().toString();

            editor.putString("email",email);
            editor.putString("password",password);
            editor.putBoolean("login",true);

            editor.apply();

            requireActivity().getSupportFragmentManager().popBackStack();

        });
    }
}