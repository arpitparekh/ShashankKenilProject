package mridul.rathore.shashankkenilproject.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyDialogBinding;
import mridul.rathore.shashankkenilproject.databinding.CustomLayoutBinding;

public class MyDialog extends AppCompatActivity {
    private ActivityMyDialogBinding binding;
    private CustomLayoutBinding binding1;
    ArrayList<String> dataList;
    String data="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyDialogBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        dataList = new ArrayList<>();

        String array[] = {"ankit","shwayam","patil"};

        binding.btnd1.setOnClickListener(v -> {

            // alert dialog


            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("This is Alert Dialog");

            builder.setMessage("This alert message");

            builder.setIcon(R.drawable.ic_sun);

            builder.setCancelable(false);

            builder.setPositiveButton("Toast", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MyDialog.this, "toast from dialog", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("Snackbar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Snackbar.make(binding.getRoot(),"scank bar from dialog",Snackbar.LENGTH_SHORT).show();
                }
            });

            builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            builder.show();

        });

        binding.btnd2.setOnClickListener(v -> {

            dataList.clear();

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("This is checkbox dialog");

            builder.setMultiChoiceItems(array, new boolean[]{false,true,false}, new DialogInterface.OnMultiChoiceClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    if(isChecked){

                        dataList.add(array[which]);
                    }else{

                        dataList.remove(array[which]);
                    }
                }
            });


            builder.setPositiveButton("yes", (dialog, which) -> {

                Toast.makeText(this, dataList.toString(), Toast.LENGTH_SHORT).show();
            });

            builder.show();

        });

        binding.btnd3.setOnClickListener(v -> {


            dataList.clear();

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("This is checkbox dialog");

            builder.setSingleChoiceItems(array, -1, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    data = array[which];

                }
            });
            builder.setPositiveButton("yes", (dialog, which) -> {

                Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
            });

            builder.show();
        });

        binding.btnd4.setOnClickListener(v -> {

            binding1 = CustomLayoutBinding.inflate(getLayoutInflater());

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setView(binding1.getRoot());

            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    String name = binding1.edtName.getText().toString();
                    binding.edtRootName.setText(name);
                }
            });

            builder.show();

        });

        binding.btnd5.setOnClickListener(v -> {

            binding1 = CustomLayoutBinding.inflate(getLayoutInflater());

            Dialog dialog = new Dialog(this);

            dialog.setContentView(binding1.getRoot());

            dialog.create();

            dialog.show();

        });
    }
}