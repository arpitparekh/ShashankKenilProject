package mridul.rathore.shashankkenilproject.retrofit;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewPostViewModel extends AndroidViewModel {

    RetrofitService service;
    Application application;
    MutableLiveData<List<NewPostItem>> liveData;
    MutableLiveData<NewPostItem> item;

    public NewPostViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        service = RetrofitUtil.getService();
        liveData = new MutableLiveData<>();
        item = new MutableLiveData<>();

    }


    public MutableLiveData<List<NewPostItem>> getLiveData() {
        return liveData;
    }

    public MutableLiveData<NewPostItem> getItem() {
        return item;
    }

    public void getSinglePost(int id){

        Call<NewPostItem> call = service.getSinglePost(id);

        call.enqueue(new Callback<NewPostItem>() {
            @Override
            public void onResponse(Call<NewPostItem> call, Response<NewPostItem> response) {
                getItem().postValue(response.body());
            }

            @Override
            public void onFailure(Call<NewPostItem> call, Throwable t) {
                Toast.makeText(application, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void getApiCall(){

        Call<List<NewPostItem>> call =  service.getPost();


        call.enqueue(new Callback<List<NewPostItem>>() {
            @Override
            public void onResponse(Call<List<NewPostItem>> call, Response<List<NewPostItem>> response) {
                getLiveData().postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<NewPostItem>> call, Throwable t) {
                Toast.makeText(application, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });




    }

}
