package edu.upc.eetac.dsa.fq;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ignacio on 31/05/2017.
 */

public interface Service {
    String URL="https://api.github.com/";

    @GET("users/{name}/followers")
    Call<List<User>> callFol(@Path("name")String name);
    @GET("users/{name}")
    Call<User> callUser(@Path("name")String name);

}
