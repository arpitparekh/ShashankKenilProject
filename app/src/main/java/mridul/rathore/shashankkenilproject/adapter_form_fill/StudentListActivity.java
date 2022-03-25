package mridul.rathore.shashankkenilproject.adapter_form_fill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityStudentListBinding;
import mridul.rathore.shashankkenilproject.databinding.CustomDialogLayoutBinding;

public class StudentListActivity extends AppCompatActivity {
    private ActivityStudentListBinding binding;
    private CustomDialogLayoutBinding binding1;
    private ArrayList<Student> studentArrayList;
    ArrayAdapter<Student> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityStudentListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        studentArrayList = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,studentArrayList);

        binding.listViewForm.setAdapter(adapter);
//        Intent i = getIntent();

//        if(i!=null){
//
//            Student s = i.getParcelableExtra("object");
//            studentArrayList.add(s);
//
//            adapter.notifyDataSetChanged();
//        }

        binding.listViewForm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(StudentListActivity.this, studentArrayList.get(position).toString(), Toast.LENGTH_SHORT).show();
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
        binding1 = CustomDialogLayoutBinding.inflate(getLayoutInflater());
        if(item.getItemId()==R.id.action_add){

            new AlertDialog.Builder(this)
                    .setView(binding1.getRoot())
                    .setPositiveButton("ADD Data", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            String name = binding1.edtNameStudent.getText().toString();
                            int age = Integer.parseInt(binding1.edtAgeStudent.getText().toString());
                            String email = binding1.edtEmailStudent.getText().toString();
                            String address = binding1.edtAddressStudent.getText().toString();

                            Student s = new Student(name,age,email,address);

                            studentArrayList.add(s);

                            adapter.notifyDataSetChanged();

                        }
                    }).create().show();

        }
        return super.onOptionsItemSelected(item);
    }
}