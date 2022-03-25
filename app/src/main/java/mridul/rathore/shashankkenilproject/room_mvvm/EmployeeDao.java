package mridul.rathore.shashankkenilproject.room_mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {  // data access object  // abstract method

    // crud operation  // Dao provides CRUD methods

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertData(Employee e);

    @Query("insert into EmployeeTable (name,email) values (:name,:email)")
    void insertDataOther(String name,String email);

    @Update
    void updateData(Employee e);

    @Query("update EmployeeTable set name=:name,email=:email where `key` = :key")
    void updateDataOther(String name,String email,int key);

    @Delete
    void deleteData(Employee e);

    @Query("delete from EmployeeTable where `key` = :key")
    void deleteDataOther(int key);

    @Query("select * from EmployeeTable")
    LiveData<List<Employee>> displayData();        // from live Data

    @Query("select name from EmployeeTable")
    List<String> displayName();

    @Insert
    void insertWholeList(List<Employee> list);

    @Delete
    void deleteWholeList(List<Employee> list);

    @Update
    void updateWholeList(List<Employee> list);

    @Query("select email from EmployeeTable where name=:name")
    String getSpecificEmail(String name);



}
