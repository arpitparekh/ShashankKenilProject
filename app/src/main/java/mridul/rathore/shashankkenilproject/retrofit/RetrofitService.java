package mridul.rathore.shashankkenilproject.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RetrofitService {

    @GET("posts")
    Call<List<NewPostItem>> getPost();

    @GET("posts/{id}")
    Call<NewPostItem> getSinglePost(@Path("id") int id);

//    Call<NewPostItem> getSinglePost(@Path("id") int id, @Query("name") String name);

    @GET
    Call<List<NewPostItem>> getPostsNew(@Url String url);








}
