package mridul.rathore.shashankkenilproject.sharedPref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.FragmentSecondLoginBinding;


public class SecondLoginFragment extends Fragment {


    private FragmentSecondLoginBinding binding;
    SharedPreferences preferences;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentSecondLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        preferences = getContext().getSharedPreferences("register", Context.MODE_PRIVATE);

        checkLogin();


        binding.tvRegister.setOnClickListener(v -> {

            getParentFragmentManager().beginTransaction()
                    .replace(R.id.prefHolder,new SecondRegisterFragment())
                    .addToBackStack("login")
                    .commit();
        });


        binding.btnSend.setOnClickListener(v -> {

            String email = binding.edtEmail.getText().toString();
            String password = binding.edtPassword.getText().toString();

            // shared preference  // private // internal storage // key value pairs // data/data/packageName/sharedPref

            if(email.equals(preferences.getString("email","")) && password.equals(preferences.getString("password",""))){
                Snackbar.make(binding.getRoot(),"Done",Snackbar.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(),DashBoardActivity.class));
            }

        });

        binding.btnShow.setOnClickListener(v -> {

            String email = preferences.getString("email","");
            String password = preferences.getString("password","");

            binding.tvShow.setText(email+" "+password);

        });



    }

    private void checkLogin() {

        if(preferences.getBoolean("login",false)){

            startActivity(new Intent(getActivity(),DashBoardActivity.class));
        }

    }
}