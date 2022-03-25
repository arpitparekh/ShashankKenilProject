package mridul.rathore.shashankkenilproject.permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import mridul.rathore.shashankkenilproject.databinding.ActivityMyPermissionBinding;

public class MyPermissionActivity extends AppCompatActivity {

    private ActivityMyPermissionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyPermissionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCamera.setOnClickListener(v ->{

            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_DENIED){

                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_EXTERNAL_STORAGE},101);

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==101){

            if(grantResults.length>0){

                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }else{

                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }

        }
    }


}