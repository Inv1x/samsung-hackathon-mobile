package com.inv1x.samsung_hackathon_mobile.api;

import com.inv1x.samsung_hackathon_mobile.model.BoardColumn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IColumnAPI {
    @GET
    public Call<List<BoardColumn>> getAllColumns();

    @POST("column/by-id/{id}")
    public Call<BoardColumn> createColumn(@Body BoardColumn boardColumn);

    @GET("column/by-id/{id}")
    public Call<BoardColumn> getColumn(@Path("id") long id);

    @PUT("column/by-id/{id}")
    public Call<BoardColumn> updateColumn(@Path("id") long id, @Body BoardColumn boardColumn);
    @DELETE("column/by-id/{id}")
    public void deleteColumn(@Path("id") long id);

    @PUT("{listId}/add-task/{taskId}")
    public Call<BoardColumn> addTask(@Path("listId") long listId, @Path("taskId") long taskId);

    @DELETE("{listId}/remove-task/{taskId}")
    public Call<BoardColumn> removeTask(@Path("listId") long listId, @Path("taskId") long taskId);


    // бесполезно?
    @DELETE("{listId}/unlink-board/{boardId}")
    public Call<BoardColumn> unlinkBoard(@Path("listId") long listId, @Path("boardId") long boardId);
}
