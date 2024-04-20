package com.inv1x.samsung_hackathon_mobile.api;

import com.inv1x.samsung_hackathon_mobile.model.Board;

import java.util.Set;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IBoardAPI {
    @GET("board")
    Call<Set<Board>> getAllBoards();
}
