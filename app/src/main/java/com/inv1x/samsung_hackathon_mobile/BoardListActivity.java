package com.inv1x.samsung_hackathon_mobile;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.inv1x.samsung_hackathon_mobile.adapter.BoardColumnAdapter;
import com.inv1x.samsung_hackathon_mobile.adapter.BoardListAdapter;
import com.inv1x.samsung_hackathon_mobile.model.Board;
import com.inv1x.samsung_hackathon_mobile.model.BoardColumn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BoardListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_board_list);

        RecyclerView rv = findViewById(R.id.board_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        BoardListAdapter boardListAdapter = new BoardListAdapter();

        CompletableFuture.supplyAsync(() -> MainActivity.boardAPI.getAllBoards())
                .thenAccept(boards ->
                        runOnUiThread(() -> {
                            List<Board> newBoards = new ArrayList<>(boards);
                            boardListAdapter.addAll(newBoards);
                        }));

        rv.setAdapter(boardListAdapter);
    }
}