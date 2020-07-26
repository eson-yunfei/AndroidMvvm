package com.shon.mvvm.net;

import com.shon.mvvm.net.resopnse.LiveDataCallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/26 17:07
 * Package name : com.shon.mvvm.net
 * Des :
 */
public abstract class BaseApi<T> {

   protected T apiInterface;

   public BaseApi(String baseUrl){
       OkHttpClient okHttpClient = new OkHttpClient.Builder()
               .connectTimeout(10, TimeUnit.SECONDS)
               .build();
       Retrofit retrofit = new Retrofit.Builder()
               .client(okHttpClient)
               .baseUrl(baseUrl)
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
               .build();

       apiInterface = retrofit.create(getApiInterface());

   }

    protected abstract Class<T> getApiInterface();

}
