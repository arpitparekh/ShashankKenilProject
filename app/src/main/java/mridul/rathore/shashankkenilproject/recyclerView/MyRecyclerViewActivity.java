package mridul.rathore.shashankkenilproject.recyclerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import mridul.rathore.shashankkenilproject.R;
import mridul.rathore.shashankkenilproject.databinding.ActivityMyRecyclerViewBinding;
import mridul.rathore.shashankkenilproject.databinding.CustomDilaogRecyclerviewBinding;

public class MyRecyclerViewActivity extends AppCompatActivity implements EmpAdapter.OnClickInterface {
    private ActivityMyRecyclerViewBinding binding;
    private CustomDilaogRecyclerviewBinding binding1;
    ArrayList<Employee> list;
    EmpAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding=ActivityMyRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        // recyclerView

        // 3 layout

        // 1 linear layout (vertical / horizontal)
        // 2 grid layout
        // 3 staggered grid

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

//          binding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));

//            binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL));
        // static raw data
        list.add(new Employee(1,"smit","it","smit@gmail.com"));
        list.add(new Employee(4,"Hemang","civil","hemang@gmail.com"));
        list.add(new Employee(9,"Shashank","medical","shashank@gmail.com"));
        list.add(new Employee(10,"Kenil","chemistry","kenil@gmail.com"));

        adapter = new EmpAdapter();

        adapter.setEmployees(list);
        adapter.setOnClickInterface(this);

        binding.recyclerView.setAdapter(adapter);


        ItemTouchHelper helper1 = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.DOWN | ItemTouchHelper.UP,0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

                int newPosition = target.getAdapterPosition();
                int oldPosition = viewHolder.getAdapterPosition();
                Collections.swap(list,newPosition,oldPosition);

                adapter.notifyItemMoved(oldPosition,newPosition);

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
        helper1.attachToRecyclerView(binding.recyclerView);

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                int position = viewHolder.getAdapterPosition();
                if(direction==ItemTouchHelper.LEFT){

                    // delete
                    showMyDialog(position);

                }else if(direction==ItemTouchHelper.RIGHT){

                    // update
                    shoeEditDialog(position);
                }
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                View itemView = viewHolder.itemView;
                int height = itemView.getHeight();
                int verticalMid = height/3;
                Paint paint = new Paint();
                Paint bitmapColor = new Paint();
                Bitmap bitmap;
                bitmapColor.setColor(Color.BLACK);
                if(actionState==ItemTouchHelper.ACTION_STATE_SWIPE){
                    if(dX>0){
                        paint.setColor(Color.GREEN);
                        bitmapColor.setColor(Color.BLACK);
                        c.drawRect(itemView.getLeft(),itemView.getTop(),dX,itemView.getBottom(),paint);
                        bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_edit);
                        c.drawBitmap(bitmap,verticalMid,itemView.getTop()+verticalMid,bitmapColor);

                    }else{
                        paint.setColor(Color.RED);
                        c.drawRect(itemView.getRight()+dX,itemView.getTop(),itemView.getRight(),itemView.getBottom(),paint);
                        bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_delete);
                        c.drawBitmap(bitmap,itemView.getRight()-(verticalMid*2),itemView.getTop()+verticalMid,bitmapColor);
                    }
                }
//                if(!isCurrentlyActive){
//                    c.drawColor(Color.WHITE);
//
//                }

            }
        });


        helper.attachToRecyclerView(binding.recyclerView); ////////////////////////////
    }

    private void shoeEditDialog(int position) {

        Employee e = list.get(position);

        binding1 = CustomDilaogRecyclerviewBinding.inflate(getLayoutInflater());

        binding1.empId.setText(String.valueOf(e.id));
        binding1.empDep.setText(e.depName);
        binding1.empEmail.setText(e.email);
        binding1.empName.setText(e.name);

        new AlertDialog.Builder(this)
                .setView(binding1.getRoot())
                .setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Employee eNew = new Employee();
                        eNew.id = Integer.parseInt(binding1.empId.getText().toString());
                        eNew.depName = binding1.empDep.getText().toString();
                        eNew.email = binding1.empEmail.getText().toString();
                        eNew.name = binding1.empName.getText().toString();
                        list.set(position,eNew);
                        adapter.setEmployees(list);
                        adapter.notifyDataSetChanged();

                    }
                })
                .create().show();
    }

    private void showMyDialog(int position) {

        Employee e = list.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                list.remove(e);
                adapter.setEmployees(list);
                adapter.notifyDataSetChanged();
            }
        });

        builder.setOnDismissListener(new DialogInterface.OnDismissListener() { //////////////////
            @Override
            public void onDismiss(DialogInterface dialog) {
                adapter.notifyDataSetChanged();
            }
        });

        builder.show();
    }

    @Override
    public void onClick(int position) {
        Employee employee = list.get(position);
        Toast.makeText(this,employee.name , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongClick(int position) {
        Employee employee = list.get(position);
        Toast.makeText(this,employee.depName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);

        MenuItem item = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }


}