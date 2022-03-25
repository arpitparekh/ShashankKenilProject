package mridul.rathore.shashankkenilproject.GetDataFromXAMPP;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetInstance {

    public static String BASE_URL="http://2a16-122-170-75-48.ngrok.io/data/";

    public static ApiData apiData;

    public static ApiData getApiInstance(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        if(apiData==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            apiData = retrofit.create(ApiData.class);

        }
       return apiData;

    }

}
