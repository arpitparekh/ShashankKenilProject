package mridul.rathore.shashankkenilproject.realm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyrealmBinding;
import mridul.rathore.shashankkenilproject.databinding.RealmCarLayoutBinding;

public class MyrealmActivity extends AppCompatActivity {

    private ActivityMyrealmBinding binding;
    RealmConfiguration configuration;
    Realm realm;
    private RealmCarLayoutBinding binding1;
    RealmResults<Car> list;
    ArrayAdapter<Car> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyrealmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Realm.init(this);

        configuration =new  RealmConfiguration.Builder()
                .allowWritesOnUiThread(true)
                .name("CarDatabase")
                .build();
        realm = Realm.getInstance(configuration);

        list = realm.where(Car.class).findAll();

        adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.listViewRealm.setAdapter(adapter);

        binding.listViewRealm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int po, long l) {

            }
        });

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });
//            }
//        }).start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        binding1 = RealmCarLayoutBinding.inflate(getLayoutInflater());

        if(item.getItemId()==R.id.action_add){

            new AlertDialog.Builder(MyrealmActivity.this)
                    .setView(binding1.getRoot())
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            String name = binding1.edtCarName.getText().toString();
                            String color = binding1.edtCarColor.getText().toString();

                            Car c = new Car(name,color);

                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    realm.insert(c);

                                    adapter.notifyDataSetChanged();

                                    Toast.makeText(MyrealmActivity.this, "Data Added SuccessFully", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).create().show();

        }
        return super.onOptionsItemSelected(item);
    }
}