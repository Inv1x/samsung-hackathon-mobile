package com.inv1x.samsung_hackathon_mobile.api;

import com.inv1x.samsung_hackathon_mobile.model.User;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserAPI {
    private final OkHttpClient client;
    private final Retrofit retrofit;
    private final IUserAPI userAPI;

    public UserAPI() {
        client = new OkHttpClient().newBuilder().addInterceptor(chain -> {
            Request request = chain.request().newBuilder().build();
            return chain.proceed(request);
        }).build();

        retrofit = new Retrofit.Builder().baseUrl(ServerSettings.serverURL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        userAPI = retrofit.create(IUserAPI.class);
    }

    public User getUserById(long id) {
        try {
            return userAPI.getUserById(id).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
