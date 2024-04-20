package com.inv1x.samsung_hackathon_mobile.api;

import com.inv1x.samsung_hackathon_mobile.model.Board;

import java.io.IOException;
import java.util.Set;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BoardAPI {
    private final OkHttpClient client;
    private final Retrofit retrofit;
    private final IBoardAPI boardAPI;

    public BoardAPI() {
        client = new OkHttpClient().newBuilder().addInterceptor(chain -> {
            Request request = chain.request().newBuilder().build();
            return chain.proceed(request);
        }).build();

        retrofit = new Retrofit.Builder().baseUrl(ServerSettings.serverURL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        boardAPI = retrofit.create(IBoardAPI.class);
    }

    public Set<Board> getAllBoards() {
        try {
            return boardAPI.getAllBoards().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
