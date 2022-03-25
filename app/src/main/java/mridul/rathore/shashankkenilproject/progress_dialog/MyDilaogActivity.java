package mridul.rathore.shashankkenilproject.progress_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import mridul.rathore.shashankkenilproject.databinding.ActivityMyDialogBinding;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyDilaogBinding;

public class MyDilaogActivity extends AppCompatActivity {
    private ActivityMyDilaogBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMyDilaogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.dialog1.setOnClickListener(v -> {

            ProgressDialog d = new ProgressDialog(this);

            d.setTitle("THis is ProgressDialog");
            d.setMessage("message");
            d.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            d.show();
        });

        binding.dialog2.setOnClickListener(v -> {

//            Dialog d = new Dialog(this, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen)
            ProgressDialog d = new ProgressDialog(this);
            d.setTitle("THis is ProgressDialog");
            d.setMessage("message");
            d.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            d.setMax(100);
            d.setProgress(0);

            new Thread(new Runnable() {
                @Override
                public void run() {

                    for(int i=0;i<=d.getMax();i++){

                        try {
                            Thread.sleep(50);
                            d.setProgress(i);

                            if(d.getProgress()==d.getMax()){
                                d.dismiss();
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }).start();


            d.show();

        });

    }
}