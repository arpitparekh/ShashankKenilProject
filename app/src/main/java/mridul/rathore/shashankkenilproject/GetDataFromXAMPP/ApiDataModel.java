package mridul.rathore.shashankkenilproject.GetDataFromXAMPP;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiDataModel extends AndroidViewModel {

    private ApiData data;
    private MutableLiveData<List<Person>> mutableLiveData;
    Application application;

    ScheduledExecutorService service = Executors.newScheduledThreadPool(1);


    public ApiDataModel(@NonNull Application application) {

        super(application);
        data = GetInstance.getApiInstance();
        mutableLiveData = new MutableLiveData<>();
        this.application = application;
    }

    public MutableLiveData<List<Person>> getMutableLiveData() {
        return mutableLiveData;
    }

    void ApiCall(){

            service.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {

                    Call<List<Person>> call = data.getData();
                    call.enqueue(new Callback<List<Person>>() {
                        @Override
                        public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {

                                getMutableLiveData().postValue(response.body());
                        }

                        @Override
                        public void onFailure(Call<List<Person>> call, Throwable t) {
                            Toast.makeText(application, t.toString(), Toast.LENGTH_SHORT).show();
                            Log.i("error",t.toString());
                        }
                    });


                }
            },0,500, TimeUnit.MILLISECONDS);

            }

            void insertData(String name,String email,String address){

                Call<List<Person>> call = data.insertData(name, email, address);

                call.enqueue(new Callback<List<Person>>() {
                    @Override
                    public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                        Toast.makeText(application, "SuccessFull", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<List<Person>> call, Throwable t) {
                        Log.i("error",t.toString());
                    }
                });

            }

    void updateData(int id,String name,String email,String address){

        Call<List<Person>> call = data.updateData(id,name, email, address);

        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                Toast.makeText(application, "SuccessFull", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Log.i("error",t.toString());
            }
        });

    }

    void deleteData(int id){

        Call<List<Person>> call = data.deleteData(id);

        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                Toast.makeText(application, "SuccessFull", Toast.LENGTH_SHORT).show();
                ApiCall();
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Log.i("error",t.toString());
            }
        });


    }


}
