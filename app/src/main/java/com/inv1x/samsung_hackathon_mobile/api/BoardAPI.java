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
    public Board createBoard(Board board){
        try {
            return boardAPI.createBoard(board).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Board getBoard(long id){
        try {
            return boardAPI.getBoard(id).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Board updateBoard(long id, Board board){
        try {
            return boardAPI.updateBoard(id, board).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBoard(long id){
        boardAPI.deleteBoard(id);  // TODO проверка что такая вообще существует
    }

    public Board addColumn(long boardId, long columnId){
        try {
            return boardAPI.addColumn(boardId, columnId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Board removeColumn(long boardId, long columnId){
        try {
            return boardAPI.removeColumn(boardId, columnId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Board addCollaborator(long boardId, long collaboratorId){
        try {
            return boardAPI.addCollaborator(boardId, collaboratorId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Board removeCollaborator(long boardId, long collaboratorId){
        try {
            return boardAPI.removeCollaborator(boardId, collaboratorId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
