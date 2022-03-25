package mridul.rathore.shashankkenilproject.multipleContextMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyMultipleBinding;

public class MyMultipleActivity extends AppCompatActivity {
    private ActivityMyMultipleBinding binding;
    private Menu myMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyMultipleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerForContextMenu(binding.btnC1);
        registerForContextMenu(binding.btnC2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderIcon(R.drawable.ic_sun);

        if(v==binding.btnC1){
            getMenuInflater().inflate(R.menu.my_menu,menu);
        }
        if(v==binding.btnC2){
            getMenuInflater().inflate(R.menu.my_menu_2,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_menu1){
            Toast.makeText(MyMultipleActivity.this, "this is item 1", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu2){
            Toast.makeText(MyMultipleActivity.this, "this is item 2", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu3){
            Toast.makeText(MyMultipleActivity.this, "this is item 3", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu4){
            Toast.makeText(MyMultipleActivity.this, "this is item 4", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu5){
            Toast.makeText(MyMultipleActivity.this, "this is item 5", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu6){
            Toast.makeText(MyMultipleActivity.this, "this is item 6", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu7){
            Toast.makeText(MyMultipleActivity.this, "this is item 7", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.action_menu8){
            Toast.makeText(MyMultipleActivity.this, "this is item 8", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}