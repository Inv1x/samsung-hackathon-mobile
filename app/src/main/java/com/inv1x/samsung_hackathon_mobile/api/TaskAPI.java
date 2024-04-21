package com.inv1x.samsung_hackathon_mobile.api;

import com.inv1x.samsung_hackathon_mobile.model.ColumnTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TaskAPI {
    private final OkHttpClient client;
    private final Retrofit retrofit;
    private final ITaskAPI taskAPI;

    public TaskAPI() {
        client = new OkHttpClient().newBuilder().addInterceptor(chain -> {
            Request request = chain.request().newBuilder().build();
            return chain.proceed(request);
        }).build();

        retrofit = new Retrofit.Builder().baseUrl(ServerSettings.serverURL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        taskAPI = retrofit.create(ITaskAPI.class);
    }

    public ColumnTask createTask(ColumnTask columnTask){
        try {
            return taskAPI.createTask(columnTask).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ColumnTask getTask(long id){
        try {
            return taskAPI.getTask(id).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ColumnTask updateTask(long id, ColumnTask columnTask){
        try {
            return taskAPI.updateTask(id, columnTask).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTask(long id){
        taskAPI.deleteTask(id);
    }

    public ColumnTask linkColumn(long taskId, long columnId){
        try {
            return taskAPI.linkColumn(taskId, columnId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // зачем...
    public ColumnTask unlinkUser(long taskId, long userId){
        try {
            return taskAPI.unlinkUser(taskId, userId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
