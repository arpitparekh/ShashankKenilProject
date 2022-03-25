package mridul.rathore.shashankkenilproject.room_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import mridul.rathore.shashankkenilproject.databinding.ActivityAddEmployeeBinding;

public class AddEmployeeActivity extends AppCompatActivity {

    private ActivityAddEmployeeBinding binding;
    private EmployeeViewModel model;
    private Employee e=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddEmployeeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(EmployeeViewModel.class);

        Intent in = getIntent();
        e = (Employee) in.getSerializableExtra("object");

        if(e!=null){
            binding.edtNameRoom.setText(e.name);
            binding.edtEmailRoom.setText(e.email);
        }

        binding.btnRoom.setOnClickListener(v -> {

            String name = binding.edtNameRoom.getText().toString();
            String email = binding.edtEmailRoom.getText().toString();

            if(e==null){  // insert new

                e = new Employee(name,email);

                model.insertData(e);

                startActivity(new Intent(this,DisplayEmployeeActivity.class));

            }else{   // update


                model.updateData(name,email,e.key);

                startActivity(new Intent(this,DisplayEmployeeActivity.class));

            }


        });
    }
}