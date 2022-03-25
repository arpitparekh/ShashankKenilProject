package mridul.rathore.shashankkenilproject.external_internal_Storage;

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
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import mridul.rathore.shashankkenilproject.databinding.ActivityAndroid11StorageBinding;

public class Android11StorageActivity extends AppCompatActivity {

    private ActivityAndroid11StorageBinding binding;
    ActivityResultLauncher<Intent> permission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAndroid11StorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // android 11

        // scope storage

        permission = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onActivityResult(ActivityResult result) {
                if(Environment.isExternalStorageManager()){
                    Toast.makeText(Android11StorageActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Android11StorageActivity.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkStoragePermission();
        
        storeDataInExternalStorage();


        binding.btnExternalRead.setOnClickListener(v -> {

            File file = Environment.getExternalStorageDirectory();

            file = new File(file,"MyFolder");

            if(file.mkdir()){
                Toast.makeText(Android11StorageActivity.this, "Folder Created", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Android11StorageActivity.this, "Folder Not Created", Toast.LENGTH_SHORT).show();
            }

            file = new File(file,"demo.txt");

            try {
                FileInputStream is = new FileInputStream(file);
                byte[] arr =new byte[is.available()];
                is.read(arr);
                binding.tvExternal.setText(new String(arr));

            } catch (Exception e) {
                e.printStackTrace();
            }


        });


    }

    private void storeDataInExternalStorage() {
        
        binding.btnEXternalWrite.setOnClickListener(v -> {
            
            String data = binding.edtExternal.getText().toString();
            
            File file = Environment.getExternalStorageDirectory();
            
            file = new File(file,"MyFolder");
            
            if(file.mkdir()){
                Toast.makeText(Android11StorageActivity.this, "Folder Created", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Android11StorageActivity.this, "Folder Not Created", Toast.LENGTH_SHORT).show();
            }

            file = new File(file,"demo.txt");

            try {
                FileOutputStream os = new FileOutputStream(file);
                os.write(data.getBytes());
                os.close();

                Toast.makeText(Android11StorageActivity.this, "File Write Successfully", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }


        });
    }

    private void checkStoragePermission() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){ // for android 11 and above

            if(!Environment.isExternalStorageManager()){

                try{
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    intent.setData(Uri.parse(String.format("package:%s",getApplicationContext().getPackageName())));
                    permission.launch(intent);
                }catch (Exception e){
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
//                    intent.setData(Uri.parse(String.format("package:%s",getApplicationContext().getPackageName())));
                    permission.launch(intent);
                }
            }

        }else{

            if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED
                    && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){

                ActivityCompat.requestPermissions(Android11StorageActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},101);
            }

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==101){

            if(grantResults.length>0){

                Toast.makeText(Android11StorageActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(Android11StorageActivity.this, "Permission not Granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}