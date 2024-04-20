package com.inv1x.samsung_hackathon_mobile;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.inv1x.samsung_hackathon_mobile.api.BoardAPI;
import com.inv1x.samsung_hackathon_mobile.api.UserAPI;

import java.util.concurrent.CompletableFuture;

public class MainActivity extends AppCompatActivity {
    public static UserAPI userAPI;

    public static BoardAPI boardAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        if(userAPI == null) userAPI = new UserAPI();
        if(boardAPI == null) boardAPI = new BoardAPI();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CompletableFuture.supplyAsync(() -> userAPI.getUserById(1))
                .thenAccept(user -> Log.d("MainActivity", user.toString()));

        CompletableFuture.supplyAsync(() -> boardAPI.getAllBoards())
                .thenAccept(boards -> Log.d("MainActivity", boards.toString()));
    }
}