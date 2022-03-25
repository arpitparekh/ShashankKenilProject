package mridul.rathore.shashankkenilproject.room_mvvm;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class},exportSchema = false,version = 1)
public abstract class EmployeeDatabase extends RoomDatabase {

    public static EmployeeDatabase database;

    public static final String DATABASE_NAME="EmployeeDatabase";

    public static final Object obj = new Object();

    abstract EmployeeDao getDao();

    public static EmployeeDatabase getInstance(Context context){

        if(database==null){

            synchronized (obj) {  // only one class can access database at a ont time
                database = Room.databaseBuilder(context, EmployeeDatabase.class, DATABASE_NAME)
                        .build();
            }
        }
        return database;
    }

}
