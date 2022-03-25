package mridul.rathore.shashankkenilproject.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import mridul.rathore.shashankkenilproject.databinding.ActivityBottomSheetBinding;

public class BottomSheetActivity extends AppCompatActivity {


    private ActivityBottomSheetBinding binding;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBottomSheetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);;
        list.add("Kenil");
        list.add("Shashank");
        list.add("rahul");
        list.add("goa");

        adapter.notifyDataSetChanged();

        binding.listViewBottomSheet.setAdapter(adapter);

        binding.listViewBottomSheet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MyBottomSheetFragment sheet = new MyBottomSheetFragment(list.get(position));
                sheet.show(getSupportFragmentManager(),"sheet1");
            }
        });
    }

}