package com.example.innovaneers;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RectrofitInstance {
    private static RectrofitInstance instance = null;
    public static String BASEURL;
    private APIInterface myApi;


    private RectrofitInstance() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Log.i("BaseURl",BASEURL);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(APIInterface.class);

    }

    public static synchronized RectrofitInstance getInstance() {//Lead
        if (instance == null) {

            instance = new RectrofitInstance();
        }
        return instance;
    }
    private static RectrofitInstance Retrofit1 = null;    //Project
    public static synchronized RectrofitInstance getRetrofit1() {
        if (Retrofit1 == null) {

            Retrofit1 = new RectrofitInstance();
        }
        return Retrofit1;
    }
    private static RectrofitInstance Retrofit2 = null;    //login
    public static synchronized RectrofitInstance getRetrofit2() {
        if (Retrofit2 == null) {

            Retrofit2 = new RectrofitInstance();
        }
        return Retrofit2;
    }
    private static RectrofitInstance Retrofit3 = null;    //Team
    public static synchronized RectrofitInstance getRetrofit3() {
        if (Retrofit3 == null) {

            Retrofit3 = new RectrofitInstance();
        }
        return Retrofit3;
    }
    private static RectrofitInstance Retrofit4 = null;    //HomeStack
    public static synchronized RectrofitInstance getRetrofit4() {
        if (Retrofit4 == null) {

            Retrofit4 = new RectrofitInstance();
        }
        return Retrofit4;
    }
    private static RectrofitInstance Retrofit5 = null;    //Task
    public static synchronized RectrofitInstance getRetrofit5() {
        if (Retrofit5 == null) {

            Retrofit5 = new RectrofitInstance();
        }
        return Retrofit5;
    }

    public APIInterface getMyApi() {
        return myApi;
    }

}
