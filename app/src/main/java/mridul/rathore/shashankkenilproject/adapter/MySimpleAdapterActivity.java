package mridul.rathore.shashankkenilproject.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityMySimpleAdapterBinding;

public class MySimpleAdapterActivity extends AppCompatActivity {

    private ActivityMySimpleAdapterBinding binding;
    private ArrayList<HashMap<String,String>> myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMySimpleAdapterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myList = new ArrayList<>();

        HashMap<String,String> map1 = new HashMap<>();
        map1.put("Country","India");
        map1.put("Capital","Delhi");
        myList.add(map1);

        HashMap<String,String> map2 = new HashMap<>();
        map2.put("Country","USA");
        map2.put("Capital","New York");
        myList.add(map2);

        HashMap<String,String> map3 = new HashMap<>();
        map3.put("Country","Pakistan");
        map3.put("Capital","Lahor");
        myList.add(map3);

        HashMap<String,String> map4 = new HashMap<>();
        map4.put("Country","China");
        map4.put("Capital","Beijing");
        myList.add(map4);

        String from[]={"Country","Capital"};  // get data fro this key
        int to[]={R.id.tvCountry,R.id.tvCapital};


        SimpleAdapter adapter = new SimpleAdapter(this,myList,R.layout.my_simple_layout,from,to);

        binding.listViewSimple.setAdapter(adapter);


    }
}