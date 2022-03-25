package mridul.rathore.shashankkenilproject.mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    // Store Data in LiveData Object

    MutableLiveData<String> liveData = new MutableLiveData<>();

    void setLiveData(String data){

        liveData.setValue(data);

    }

    MutableLiveData<String> getLiveData(){

        return liveData;
    }

}
