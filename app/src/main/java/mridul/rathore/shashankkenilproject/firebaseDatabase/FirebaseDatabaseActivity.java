package mridul.rathore.shashankkenilproject.firebaseDatabase;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import mridul.rathore.shashankkenilproject.databinding.ActivityFirebaseDatabaseBinding;

public class FirebaseDatabaseActivity extends AppCompatActivity {

    private ActivityFirebaseDatabaseBinding binding;
    private ActivityResultLauncher<String> gallery , permission;
    private ActivityResultLauncher<Intent> camera;
    private FirebaseStorage storage;
    private StorageReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirebaseDatabaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        storage = FirebaseStorage.getInstance();
        reference = storage.getReference().child("photos");


        gallery = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                binding.ivDatabase.setImageURI(result);

                StorageReference referenceNew = reference.child("image");

                referenceNew.putFile(result).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if(task.isSuccessful()){

                                Toast.makeText(FirebaseDatabaseActivity.this, "ImageUploaded", Toast.LENGTH_SHORT).show();
                            }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(FirebaseDatabaseActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        camera = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Bitmap thumbnail = (Bitmap) result.getData().getExtras().get("data");
                binding.ivDatabase.setImageBitmap(thumbnail);


            }
        });

        permission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if(result){

                    Toast.makeText(FirebaseDatabaseActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(FirebaseDatabaseActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        });

        askPermission();

        binding.ivDatabase.setOnClickListener(view -> {

            new AlertDialog.Builder(this)
                    .setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            gallery.launch("*/*");
                        }
                    }).setNegativeButton("Camera", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    camera.launch(intent);

                }
            }).create().show();


        });

    }

    private void askPermission() {

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){

            permission.launch(Manifest.permission.CAMERA);

        }

    }
}