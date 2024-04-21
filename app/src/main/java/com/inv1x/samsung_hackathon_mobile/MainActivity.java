package com.inv1x.samsung_hackathon_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.inv1x.samsung_hackathon_mobile.api.BoardAPI;
import com.inv1x.samsung_hackathon_mobile.api.UserAPI;
import com.inv1x.samsung_hackathon_mobile.ui.LoginActivity;

import java.util.concurrent.CompletableFuture;

public class MainActivity extends AppCompatActivity {
    public static UserAPI userAPI;
    public static BoardAPI boardAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(userAPI == null) userAPI = new UserAPI();
        if(boardAPI == null) boardAPI = new BoardAPI();

        boolean userNeedsLogin = checkUserData();

        CompletableFuture.supplyAsync(() -> userAPI.getUserById(1))
                .thenAccept(user -> Log.d("MainActivity", user.toString()));

        CompletableFuture.supplyAsync(() -> boardAPI.getAllBoards())
                .thenAccept(boards -> Log.d("MainActivity", boards.toString()));

        if (userNeedsLogin) {
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        } else {
            Intent mainIntent = new Intent(this, BoardActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }

    private boolean checkUserData() {
        // TODO implement ASAP!
        return true;
    }
}
