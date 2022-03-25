package mridul.rathore.shashankkenilproject.permission;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import mridul.rathore.shashankkenilproject.databinding.ActivityYourPermissionBinding;

public class YourPermissionActivity extends AppCompatActivity {

    private ActivityYourPermissionBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityYourPermissionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        ActivityResultLauncher<String> askPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission, new ActivityResultCallback<Object>() {
//            @Override
//            public void onActivityResult(Object result) {
//
//            }
//        });

        ActivityResultLauncher<String> permission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {
            if(result){
                Toast.makeText(YourPermissionActivity.this,"Permission Granted",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(YourPermissionActivity.this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        });


        binding.btnMethod.setOnClickListener(v -> {

            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA},101);

        });

        binding.btn11.setOnClickListener(v -> {

            if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){

//                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},101);
                permission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);

            }


        });


    }

}