package mridul.rathore.shashankkenilproject.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import mridul.rathore.shashankkenilproject.databinding.ActivityMyDataListBinding;

public class MyDataListActivity extends AppCompatActivity {

    private ActivityMyDataListBinding binding;
    private NewPostViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyDataListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // https://jsonplaceholder.typicode.com/  // base url

        model  = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(NewPostViewModel.class);

        model.getApiCall();

        binding.btnGetData.setOnClickListener(view -> {

            int id = Integer.parseInt(binding.edtPostId.getText().toString());

            model.getSinglePost(id);

        });

        model.getItem().observe(this, new Observer<NewPostItem>() {
            @Override
            public void onChanged(NewPostItem newPostItem) {
                binding.tvPost.setText(newPostItem.toString());
            }
        });

        model.getLiveData().observe(this, new Observer<List<NewPostItem>>() {
            @Override
            public void onChanged(List<NewPostItem> newPostItems) {
                ArrayAdapter<NewPostItem> adapter = new ArrayAdapter<>(MyDataListActivity.this, android.R.layout.simple_list_item_1,newPostItems);

                binding.listViewRetrofit.setAdapter(adapter);
            }
        });


    }
}