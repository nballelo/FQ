package edu.upc.eetac.dsa.fq;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ignacio on 31/05/2017.
 */

public interface Image {
    String URL="https://avatars1.githubusercontent.com/u/";
    @GET("{id}?v=3")
    Call<ResponseBody> callimage(@Path("id")String id);
}
