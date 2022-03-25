package mridul.rathore.shashankkenilproject.firebaseRealtimeDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import mridul.rathore.shashankkenilproject.databinding.ActivityRealtimeBinding;

public class RealtimeActivity extends AppCompatActivity {

    private ActivityRealtimeBinding binding;
    private FirebaseDatabase database;
    private DatabaseReference ref,childRef;

    ArrayList<HashMap<String,String>> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRealtimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("String");
        childRef = ref.child("data");

        getData();

        binding.btnFirebase.setOnClickListener(view -> {

            String data = binding.edtFirebase.getText().toString();

            childRef.push().setValue(data);

        });

        binding.listViewFirebase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String,String> map = list.get(i);

                String key = null;
                for (String key1 : map.keySet()){

                    key = key1;
                }

                String finalKey = key;
                new AlertDialog.Builder(RealtimeActivity.this)
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                childRef.child(finalKey).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(RealtimeActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(RealtimeActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            getData();

                            }
                        }).setNegativeButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // update Data
                    }
                }).create().show();


            }
        });


    }

    private void getData() {

        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot childSnap : snapshot.getChildren()){

//                    list.add((String) childSnap.getValue());

                    HashMap<String,String> map = new HashMap<>();
                    map.put(childSnap.getKey(), (String) childSnap.getValue());
                    list.add(map);

                }

                ArrayAdapter<HashMap<String,String>> adapter = new ArrayAdapter<>(RealtimeActivity.this, android.R.layout.simple_list_item_1,list);
                binding.listViewFirebase.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}