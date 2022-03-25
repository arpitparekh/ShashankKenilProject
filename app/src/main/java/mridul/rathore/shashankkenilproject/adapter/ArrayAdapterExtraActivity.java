package mridul.rathore.shashankkenilproject.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import java.util.ArrayList;

import mridul.rathore.shashankkenilproject.databinding.ActivityArrayAdapterExtraBinding;

public class ArrayAdapterExtraActivity extends AppCompatActivity {
    private ActivityArrayAdapterExtraBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityArrayAdapterExtraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> list = new ArrayList<>();

        list.add("Kenil");
        list.add("Shashank");
        list.add("Hemant");
        list.add("Opera");
        list.add("Ankit");
        list.add("Modiji");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list);

        binding.spinner.setAdapter(adapter);

        binding.autoCompleteTextView.setAdapter(adapter);

        binding.autoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer()); // for multi auto complete textView
    }

}