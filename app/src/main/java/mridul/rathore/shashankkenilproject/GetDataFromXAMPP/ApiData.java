package mridul.rathore.shashankkenilproject.GetDataFromXAMPP;

import java.util.List;

import io.realm.annotations.RealmField;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiData {

    @GET("myFile.php?flag=SELECT")
    public Call<List<Person>> getData();

    @FormUrlEncoded
    @POST("myFile.php?flag=INSERT")
    Call<List<Person>> insertData(@Field("name") String name,
                                  @Field("email")String email,
                                  @Field("address") String address);

    @FormUrlEncoded
    @POST("myFile.php?flag=UPDATE")
    Call<List<Person>> updateData(@Field("id")int id,
                                @Field("name") String name,
                                  @Field("email")String email,
                                  @Field("address") String address);

    @FormUrlEncoded
    @POST("myFile.php?flag=DELETE")
    Call<List<Person>> deleteData(@Field("id")int id);

}
