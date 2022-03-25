package mridul.rathore.shashankkenilproject.room_mvvm;

import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "EmployeeTable")
public class Employee implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int key;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "email")
    String email;

    public Employee(String name, String email) {

        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
