package com.inv1x.samsung_hackathon_mobile.api;

import com.inv1x.samsung_hackathon_mobile.model.User;
import com.inv1x.samsung_hackathon_mobile.model.UserAuthDto;
import com.inv1x.samsung_hackathon_mobile.model.UserRegisterDto;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class UserAPI {
    private final OkHttpClient client;
    private final Retrofit retrofit;
    private final IUserAPI userAPI;

    public UserAPI() {
        client = new OkHttpClient().newBuilder().addInterceptor(chain -> {
            Request request = chain.request().newBuilder().build();
            return chain.proceed(request);
        }).build();

        retrofit = new Retrofit
                .Builder()
                .baseUrl(ServerSettings.serverURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userAPI = retrofit.create(IUserAPI.class);
    }


    public List<User> getAllUsers(){
        try {
            return userAPI.getAllUsers().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User registerUser(UserRegisterDto user){
        try {
            return userAPI.registerUser(user).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User loginUser(UserAuthDto user){
        try {
            return userAPI.loginUser(user).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserById(long id) {
        try {
            return userAPI.getUserById(id).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User updateUser(long id, User user){
        try {
            return userAPI.updateUser(id, user).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(long id){
        userAPI.deleteUser(id);  // TODO не отлажено исключение, когда нет такого пользователя
    }

    public User linkBoard(long userId, long boardId){
        try {
            return userAPI.linkBoard(userId, boardId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User assignTask(long userId, long taskId){
        try {
            return userAPI.assignTask(userId, taskId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
