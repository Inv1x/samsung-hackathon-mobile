package com.inv1x.samsung_hackathon_mobile.api;

import com.inv1x.samsung_hackathon_mobile.model.Board;

import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IBoardAPI {
    @GET("board")
    Call<Set<Board>> getAllBoards();

    @POST
    public Call<Board> createBoard(@Body Board board);

    @GET("board/by-id/{id}")
    public Call<Board> getBoard(@Path("id") long id);

    @PUT("board/by-id/{id}")
    public Call<Board> updateBoard(@Path("id") long id, @Body Board board);

    @DELETE("board/by-id/{id}")
    public void deleteBoard(@Path("id") long id);

    @PUT("{boardId}/add-column/{columnId}")
    public Call<Board> addColumn(@Path("id") long boardId, @Path("id") long columnId);

    @DELETE("{boardId}/remove-column/{columnId}")
    public Call<Board> removeColumn(@Path("id") long boardId, @Path("id") long columnId);

    @PUT("{boardId}/add-collaborator/{collaboratorId}")
    public Call<Board> addCollaborator(@Path("id") long boardId, @Path("id") long collaboratorId);

    @DELETE("{boardId}/remove-collaborator/{collaboratorId}")
    public Call<Board> removeCollaborator(@Path("id") long boardId, @Path("id") long collaboratorId);
}
