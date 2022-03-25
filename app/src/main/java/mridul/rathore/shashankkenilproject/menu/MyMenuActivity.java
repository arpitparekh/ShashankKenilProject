package mridul.rathore.shashankkenilproject.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyMenuBinding;

public class MyMenuActivity extends AppCompatActivity {
    private ActivityMyMenuBinding binding;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        MenuBuilder menuBuilder =new MenuBuilder(this);
//        MenuInflater inflater = new MenuInflater(this);
//        inflater.inflate(R.menu.my_menu, menuBuilder);
//        @SuppressLint("RestrictedApi") MenuPopupHelper optionsMenu = new MenuPopupHelper(this, menuBuilder, binding.btn1);
//        optionsMenu.setForceShowIcon(true);

        // menu

        // 3 types

        // option menu

        // context menu // long press

        // pop up menu


        registerForContextMenu(binding.btn1);



        binding.btn2.setOnClickListener(v -> {

            PopupMenu pop = new PopupMenu(this,v);
            pop.getMenuInflater().inflate(R.menu.my_menu,pop.getMenu());

             MenuItem item = pop.getMenu().getItem(0);


            pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {




                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if(item.getItemId()==R.id.action_menu1){

                        item.setIcon(R.drawable.ic_sun);
                        Toast.makeText(MyMenuActivity.this, "this is item 1", Toast.LENGTH_SHORT).show();
                    }else if(item.getItemId()==R.id.action_menu2){
                        Toast.makeText(MyMenuActivity.this, "this is item 2", Toast.LENGTH_SHORT).show();
                    }else if(item.getItemId()==R.id.action_menu3){
                        Toast.makeText(MyMenuActivity.this, "this is item 3", Toast.LENGTH_SHORT).show();
                    }else if(item.getItemId()==R.id.action_menu4){
                        Toast.makeText(MyMenuActivity.this, "this is item 4", Toast.LENGTH_SHORT).show();
                    }else if (item.getItemId()==R.id.action_sub_item_1){
                        Toast.makeText(MyMenuActivity.this, "this is subitem 1", Toast.LENGTH_SHORT).show();
                    }

                    return false;
                }
            });
            pop.show();


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_menu1){
            Toast.makeText(MyMenuActivity.this, "this is item 1", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu2){
            Toast.makeText(MyMenuActivity.this, "this is item 2", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu3){
            Toast.makeText(MyMenuActivity.this, "this is item 3", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu4){
            Toast.makeText(MyMenuActivity.this, "this is item 4", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.my_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_menu1){
            Toast.makeText(MyMenuActivity.this, "this is item 1", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu2){
            Toast.makeText(MyMenuActivity.this, "this is item 2", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu3){
            Toast.makeText(MyMenuActivity.this, "this is item 3", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu4){
            Toast.makeText(MyMenuActivity.this, "this is item 4", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}