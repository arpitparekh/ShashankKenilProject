package mridul.rathore.shashankkenilproject.getJsonFromAsset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import mridul.rathore.shashankkenilproject.GetJson;
import mridul.rathore.shashankkenilproject.databinding.ActivityGetJson2Binding;
import mridul.rathore.shashankkenilproject.databinding.ActivityGetJsonBinding;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetJsonActivity extends AppCompatActivity {

    private ActivityGetJson2Binding binding;
    private String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetJson2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Gson gson  = new Gson();

        data = GetJson.getJsonData("demo",this);

        Student s[] = gson.fromJson(data,Student[].class);

        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,s);

        binding.listViewAsset.setAdapter(adapter);
    }
}