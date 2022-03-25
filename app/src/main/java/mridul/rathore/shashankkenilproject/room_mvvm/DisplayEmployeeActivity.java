package mridul.rathore.shashankkenilproject.room_mvvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityDisplayEmployeeBinding;

public class DisplayEmployeeActivity extends AppCompatActivity {

    private ActivityDisplayEmployeeBinding binding;
    private EmployeeViewModel model;
    ArrayAdapter<Employee> adapter;
    List<Employee> listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisplayEmployeeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listData = new ArrayList<>();

        model = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(EmployeeViewModel.class);


        model.showData().observe(DisplayEmployeeActivity.this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> list) {
                listData = list;
                adapter = new ArrayAdapter<>(DisplayEmployeeActivity.this, android.R.layout.simple_list_item_1,list);
                binding.listView.setAdapter(adapter);
            }
        });

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int po, long l) {

                Employee e = listData.get(po);

                new AlertDialog.Builder(DisplayEmployeeActivity.this)
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent in = new Intent(DisplayEmployeeActivity.this,AddEmployeeActivity.class);
                                in.putExtra("object",e);
                                startActivity(in);

                            }
                        }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                            model.deleteData(e.key);

                    }
                }).create().show();


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_add){

            startActivity(new Intent(this,AddEmployeeActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }
}