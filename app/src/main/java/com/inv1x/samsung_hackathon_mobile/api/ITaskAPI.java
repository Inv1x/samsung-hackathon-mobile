package com.inv1x.samsung_hackathon_mobile.api;

import com.inv1x.samsung_hackathon_mobile.model.ColumnTask;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ITaskAPI {
    @POST
    public Call<ColumnTask> createTask(ColumnTask columnTask);

    @GET("task/{id}")
    public Call<ColumnTask> getTask(@Path("id") long id);

    @PUT("task/{id}")
    public Call<ColumnTask> updateTask(@Path("id") long id, @Body ColumnTask columnTask);

    @DELETE("task/{id}")
    public void deleteTask(@Path("id") long id);

    @PUT("{taskId}/link-column/{columnId}")
    public Call<ColumnTask> linkColumn(@Path("taskId") long taskId, @Path("columnId") long columnId);

    // зачем...
    @PUT("{taskId}/unlink-user/{columnId}")
    public Call<ColumnTask> unlinkUser(@Path("taskId") long taskId, @Path("userId") long userId);
}
