package mridul.rathore.shashankkenilproject.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    static RetrofitService service;

    public static RetrofitService getService(){

        if(service==null){

            Retrofit retrofit = new  Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(RetrofitService.class);

        }
        return service;

    }


}
