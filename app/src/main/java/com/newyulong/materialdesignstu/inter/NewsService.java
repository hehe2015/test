package com.newyulong.materialdesignstu.inter;

import com.newyulong.materialdesignstu.bean.News;
import com.newyulong.materialdesignstu.bean.User;

import java.util.Map;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2017/11/29.
 */

public interface NewsService {

    @GET("basil2style")
    Observable<News> getString();

    @GET("login")
    Observable<String> login(@Query("username") String name,@Query("password") String pwd);

    @POST("getUserInfo")
    Observable<User> getUserInfo(@Query("token") String token);

    @POST("")
    Call<ResponseBody> t1(@QueryMap Map<String,String> map);

}
