package mridul.rathore.shashankkenilproject.get_jsonData_from_server;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import mridul.rathore.shashankkenilproject.databinding.ActivityGetJsonBinding;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetJsonActivity extends AppCompatActivity {
    private ActivityGetJsonBinding binding;
    private String data;
    private ProgressDialog pd;
    ArrayList<Note> list;
    ArrayAdapter<Note> adapter;
    Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGetJsonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        gson = new Gson();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        pd = new ProgressDialog(this);
        pd.setTitle("Wait");
        pd.setMessage("Downloading Data...");
        pd.show();

        getDataFromServer();

    }

    private void getDataFromServer() {


        Executor executor = Executors.newSingleThreadExecutor();

        Handler handler = new Handler();

        executor.execute(new Runnable() {
            @Override
            public void run() {

                OkHttpClient client = new OkHttpClient();

                Request request = new  Request.Builder()
                        .url("https://jsonplaceholder.typicode.com/posts")
                        .build();
                try {

                    Response response = client.newCall(request).execute();

                    data = response.body().string();


                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            try {

                                pd.dismiss();

                                //////////////////////////  gson  //////////////////////////////

                                NoteJsonItem arr[] = gson.fromJson(data,NoteJsonItem[].class);

                                Log.i("gson", Arrays.toString(arr));

                                ////////////////////////////// JSONOBJECT // JSONARRAY  ///////////////////////////////
                                JSONArray array = new JSONArray(data);

                                for(int i=0;i< array.length();i++){

                                    JSONObject object = array.getJSONObject(i);

                                    String title = object.getString("title");
                                    String body = object.getString("body");

                                    Note n = new Note(title,body);
                                    list.add(n);
                                }

                                adapter.notifyDataSetChanged();

                                binding.listViewJson.setAdapter(adapter);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        });


    }
}