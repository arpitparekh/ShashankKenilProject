package mridul.rathore.shashankkenilproject.GetDataFromXAMPP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityGetDataBinding;
import mridul.rathore.shashankkenilproject.databinding.XamppLayoutBinding;

public class GetDataActivity extends AppCompatActivity {

    private ActivityGetDataBinding binding;
    private XamppLayoutBinding binding1;
    private ApiDataModel model;
    private List<Person>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        model = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ApiDataModel.class);

        model.ApiCall();

        model.getMutableLiveData().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> peoples) {
                list = peoples;
                ArrayAdapter<Person> adapter = new ArrayAdapter<>(GetDataActivity.this, android.R.layout.simple_list_item_1,list);

                binding.listViewXampp.setAdapter(adapter);

            }
        });


        binding.listViewXampp.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                binding1 = XamppLayoutBinding.inflate(getLayoutInflater());

                Person p = list.get(i);

                binding1.edtNameXampp.setText(p.getName());
                binding1.edtEmailXampp.setText(p.getEmail());
                binding1.edtAddressXampp.setText(p.getAddress());

                new AlertDialog.Builder(GetDataActivity.this)
                        .setView(binding1.getRoot())
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String name = binding1.edtNameXampp.getText().toString();
                                String email = binding1.edtEmailXampp.getText().toString();
                                String address = binding1.edtAddressXampp.getText().toString();

                                model.updateData(p.getId(),name,email,address);


                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .setNeutralButton("delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                model.deleteData(p.getId());


                            }
                        })
                        .create().show();
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

        binding1 = XamppLayoutBinding.inflate(getLayoutInflater());

        switch (item.getItemId()){

            case R.id.action_add:
                new AlertDialog.Builder(GetDataActivity.this)
                        .setView(binding1.getRoot())
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String name = binding1.edtNameXampp.getText().toString();
                                String email = binding1.edtEmailXampp.getText().toString();
                                String address = binding1.edtAddressXampp.getText().toString();

                                model.insertData(name,email,address);



                            }
                        })
                        .create().show();
        }
        return super.onOptionsItemSelected(item);
    }
}