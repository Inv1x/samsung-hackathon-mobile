package com.inv1x.samsung_hackathon_mobile.api;

import com.inv1x.samsung_hackathon_mobile.model.User;
import com.inv1x.samsung_hackathon_mobile.model.UserAuthDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IUserAPI {

    @GET("users")
    Call<List<User>> getAllUsers();

    @POST("users/register")
    Call<User> registerUser(@Body UserAuthDto user);

    @GET("users/login")
    Call<User> loginUser(@Body UserAuthDto user);

    @GET("users/by-id/{id}")
    Call<User> getUserById(@Path("id") long id);

    @PUT("users/by-id/{id}")
    Call<User> updateUser(@Path("id") long id, @Body User user);

    @DELETE("users/by-id/{id}")
    void deleteUser(@Path("id") long id);

    @POST("{userId}/link-board/{boardId}")
    Call<User> linkBoard(@Path("userId") long userId, @Path("boardId") long boardId);

    @POST("{userId}/assign-task/{taskId}")
    Call<User> assignTask(@Path("userId") long userId, @Path("taskId") long taskId);
}
