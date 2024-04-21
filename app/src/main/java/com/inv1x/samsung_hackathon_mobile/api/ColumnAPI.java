package com.inv1x.samsung_hackathon_mobile.api;

import com.inv1x.samsung_hackathon_mobile.model.BoardColumn;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ColumnAPI {
    private final OkHttpClient client;
    private final Retrofit retrofit;
    private final IColumnAPI columnAPI;

    public ColumnAPI() {
        client = new OkHttpClient().newBuilder().addInterceptor(chain -> {
            Request request = chain.request().newBuilder().build();
            return chain.proceed(request);
        }).build();

        retrofit = new Retrofit.Builder().baseUrl(ServerSettings.serverURL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        columnAPI = retrofit.create(IColumnAPI.class);
    }

    public List<BoardColumn> getAllColumns(){
        try {
            return columnAPI.getAllColumns().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BoardColumn createColumn(BoardColumn boardColumn){
        try {
            return columnAPI.createColumn(boardColumn).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BoardColumn getColumn(long id){
        try {
            return columnAPI.getColumn(id).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BoardColumn updateColumn(long id, BoardColumn boardColumn){
        try {
            return columnAPI.updateColumn(id, boardColumn).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteColumn(long id){
        columnAPI.deleteColumn(id);  // TODO проверка что такая колонка сущуствует
    }

    public BoardColumn addTask(long listId, long taskId){
        try {
            return columnAPI.addTask(listId, taskId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BoardColumn removeTask(long listId, long taskId){
        try {
            return columnAPI.removeTask(listId, taskId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // бесполезно?
    public BoardColumn unlinkBoard(long listId, long boardId){
        try {
            return columnAPI.unlinkBoard(listId, boardId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
