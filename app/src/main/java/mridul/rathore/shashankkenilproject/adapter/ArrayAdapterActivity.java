package mridul.rathore.shashankkenilproject.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;

import mridul.rathore.shashankkenilproject.databinding.ActivityArrayAdapterBinding;

public class ArrayAdapterActivity extends AppCompatActivity {

    private ActivityArrayAdapterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityArrayAdapterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<String> list = new ArrayList<>();

        list.add("Kenil");
        list.add("Shashank");
        list.add("Hemant");
        list.add("Opera");
        list.add("Ankit");
        list.add("Modiji");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,list);

        binding.listView.setAdapter(adapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(binding.getRoot(),list.get(position),Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.pullToRefresh.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(ArrayAdapterActivity.this, "pull", Toast.LENGTH_SHORT).show();
                binding.pullToRefresh.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        binding.pullToRefresh.setRefreshing(false);
                    }
                },2000);
            }
        });

        // adapter

        // array adapter

        // simple adapter

        // custom adapter
    }
}