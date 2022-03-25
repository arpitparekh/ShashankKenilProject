package mridul.rathore.shashankkenilproject.adapter_form_fill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import mridul.rathore.shashankkenilproject.databinding.ActivityAddStudentBinding;

public class AddStudentActivity extends AppCompatActivity {
    private ActivityAddStudentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.floatingActionButton3.setOnClickListener(v -> {
//
//            String name = binding.edtNameStudent.getText().toString();
//            int age = Integer.parseInt(binding.edtAgeStudent.getText().toString());
//            String email = binding.edtEmailStudent.getText().toString();
//            String address = binding.edtAddressStudent.getText().toString();
//
//            Student s = new Student(name,age,email,address);
//
//            Intent i = new Intent(this,StudentListActivity.class);
//            i.putExtra("object",s);
//            startActivity(i);
//
//        });
    }
}