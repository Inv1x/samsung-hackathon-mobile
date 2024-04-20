package com.inv1x.samsung_hackathon_mobile.api;

import com.inv1x.samsung_hackathon_mobile.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IUserAPI {
    @GET("users/by-id/{id}")
    Call<User> getUserById(@Path("id") long id);
}
