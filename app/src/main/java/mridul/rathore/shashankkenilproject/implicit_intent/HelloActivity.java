package mridul.rathore.shashankkenilproject.implicit_intent;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import mridul.rathore.shashankkenilproject.R;

public class HelloActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button3);
        Button button3 = findViewById(R.id.button4);


        // lambda method

//        void display(int x){
//            x=x+2;
//        }
//
//
//        (x->{x+=2})

        button.setOnClickListener(v -> {


//            Intent intent = new Intent(Intent.ACTION_MAIN);
//            intent.addCategory(Intent.CATEGORY_APP_BROWSER);
//            intent.addCategory(Intent.CATEGORY_APP_EMAIL);


//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse("https://stackoverflow.com/questions/62453991/caused-by-when-trying-to-play-lottie-animation"));
//            startActivity(intent);


//            Intent intent1 = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:"+"+91 9601397062"));
//            startActivity(intent1);

            // implicit intent

            Intent intent =new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));

            Intent intent1 = new Intent(Intent.ACTION_SEND);
            intent1.putExtra(Intent.EXTRA_EMAIL,new String[]{"address@mail.com","sdfsdfsdfsdf@gmail.com"});
            intent1.putExtra(Intent.EXTRA_SUBJECT,"fsdfsdff");
            intent1.putExtra(Intent.EXTRA_TEXT,"dsfgsd");
            intent1.setSelector(intent);

            startActivity(Intent.createChooser(intent1, "Send email..."));

        });
    }
}