package mridul.rathore.shashankkenilproject.room_mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {

     private EmployeeRepo repo;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);

        repo = new EmployeeRepo(application);

    }

    public void insertData(Employee e){

        repo.insertData(e);

    }
     public void updateData(String name,String email,int key){

        repo.updateData(name,email,key);

    }

    public void deleteData(int key){
        repo.deleteData(key);
    }
    LiveData<List<Employee>> showData(){

        return repo.showData();

    }
}
