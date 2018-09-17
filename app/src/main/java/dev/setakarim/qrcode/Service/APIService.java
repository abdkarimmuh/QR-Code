package dev.setakarim.qrcode.Service;

import dev.setakarim.qrcode.Model.Post;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @POST("/qrcode/")
    @FormUrlEncoded
    Call<Post> savePost(
            @Field("result") String result
    );

}
