package mridul.rathore.shashankkenilproject.external_internal_Storage;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import mridul.rathore.shashankkenilproject.databinding.ActivityMyExternalStorageBinding;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyInternalStorageBinding;

public class MyInternalStorageActivity extends AppCompatActivity {

    private ActivityMyInternalStorageBinding binding;

    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyInternalStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        ActivityResultLauncher<Intent> result = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                Uri uri = result.getData().getData();

                OutputStream outputStream = null;
                try {
                    outputStream = getContentResolver().openOutputStream(uri);

                    outputStream.write(data.getBytes());

                    outputStream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        binding.btnInternalWrite.setOnClickListener(v -> {

            data = binding.edtInternal.getText().toString();

            try {
//
//                ContextWrapper wrapper = new ContextWrapper(this);
//                File mydir = this.getDir("MyData", Context.MODE_PRIVATE); //Creating an internal dir;
//                File fileWithinMyDir = new File(mydir, "hi.txt"); //Getting a file within the dir.
//                FileOutputStream out = new FileOutputStream(fileWithinMyDir); //Use the stream as usual to write into the file.

////                FileOutputStream os = openFileOutput("data\\hello.txt",MODE_PRIVATE);
////                os.write(data.getBytes());
////                os.close();


//                File file = new File(URI.create(""))
//                File file = new File("data/data/"+getApplicationContext().getPackageName()+"/12.txt");
//
//                FileOutputStream os = new FileOutputStream(file);
//                os.write(data.getBytes());
//                os.close();

                Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TITLE,"enter title");
                result.launch(intent);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        binding.btnInternalRead.setOnClickListener(v -> {

            try {
                FileInputStream is = openFileInput("kemCho.txt");
                byte arr[] = new byte[is.available()];
                is.read(arr);
                binding.tvInternal.setText(new String(arr));
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}