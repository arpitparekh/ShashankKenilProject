package mridul.rathore.shashankkenilproject.external_internal_Storage;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import mridul.rathore.shashankkenilproject.databinding.ActivityMyExternalStorageBinding;

public class MyExternalStorageActivity extends AppCompatActivity {

    private ActivityMyExternalStorageBinding binding;
    ActivityResultLauncher<String> permission;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyExternalStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        permission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if(result){
                    Toast.makeText(MyExternalStorageActivity.this,"Permission granted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MyExternalStorageActivity.this,"Permission not granted",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ActivityResultLauncher<String> gallary = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                Toast.makeText(MyExternalStorageActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ActivityResultLauncher<Intent> openIntent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Uri uri = result.getData().getData();
                Toast.makeText(MyExternalStorageActivity.this, uri.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnGallary.setOnClickListener(v -> {
            gallary.launch("image/jpeg");

//            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//            intent.setType("application/pdf");
//            openIntent.launch(intent);

        });



        isPermissionGranted();

        binding.btnWriteExternal.setOnClickListener(v -> {

            String data = binding.edtExternal.getText().toString();

            File file = Environment.getExternalStorageDirectory();

            File dir = new File(file,"Data");

            if(dir.mkdir()){

                Toast.makeText(this, "Directory Created", Toast.LENGTH_SHORT).show();
                File innerFile = new File(dir,"hello.txt");

                try {

                    FileOutputStream out = new FileOutputStream(innerFile);
                    out.write(data.getBytes());
                    out.close();

                    Toast.makeText(this, "Data Write Successfully", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }else{
                Toast.makeText(this, "Can't Create Directory", Toast.LENGTH_SHORT).show();
            }

        });


    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void isPermissionGranted() {

        permission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);

    }
}