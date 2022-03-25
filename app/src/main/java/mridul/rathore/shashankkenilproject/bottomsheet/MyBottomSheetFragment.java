package mridul.rathore.shashankkenilproject.bottomsheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;

import mridul.rathore.shashankkenilproject.databinding.CustomBottomSheetBinding;

public class MyBottomSheetFragment extends BottomSheetDialogFragment {

    private String data;

    MyBottomSheetFragment(String data){
        this.data=data;
    }

    private CustomBottomSheetBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=CustomBottomSheetBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toast.setOnClickListener(v -> {

            Toast.makeText(getContext(), "toast", Toast.LENGTH_SHORT).show();
        });

        binding.snackBar.setOnClickListener(v -> {

            Snackbar.make(binding.getRoot(),"snackbar",Snackbar.LENGTH_SHORT).show();
        });

//        binding.btnSheet.setOnClickListener(v -> {
//
//
//            dismiss();
//        });

        binding.tvSheet.setText(data);
    }
}
