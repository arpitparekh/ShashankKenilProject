package mridul.rathore.shashankkenilproject.room_mvvm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import mridul.rathore.shashankkenilproject.adapter_form_fill.Student;

public class EmployeeRepo {

    // do  data related activity here
    // do all the background thread activity hear

    // Repo  // get data from server // send data to the server // API calling

    private EmployeeDatabase database;

    EmployeeRepo(Context context){

        database = EmployeeDatabase.getInstance(context);

    }

    Executor executor = Executors.newSingleThreadExecutor();

    void insertData(Employee e){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.getDao().insertData(e);
            }
        });

    }
    void updateData(String name,String email,int key){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.getDao().updateDataOther(name,email,key);
            }
        });

    }
    void deleteData(int key){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.getDao().deleteDataOther(key);
            }
        });

    }
    LiveData<List<Employee>> showData(){

        return database.getDao().displayData();

    }






}
