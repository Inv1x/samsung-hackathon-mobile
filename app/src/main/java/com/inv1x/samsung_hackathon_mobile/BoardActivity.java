package com.inv1x.samsung_hackathon_mobile;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.inv1x.samsung_hackathon_mobile.adapter.BoardColumnAdapter;
import com.inv1x.samsung_hackathon_mobile.model.BoardColumn;
import com.inv1x.samsung_hackathon_mobile.model.ColumnTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BoardActivity extends AppCompatActivity {
    private long boardId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_board);
        Bundle b = getIntent().getExtras();
        assert b != null;
        boardId = b.getLong("boardId");

        RecyclerView rv = findViewById(R.id.board_column_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        BoardColumnAdapter boardColumnAdapter = new BoardColumnAdapter();

        CompletableFuture.supplyAsync(() -> MainActivity.boardAPI.getBoard(boardId))
                .thenAccept(board ->
                        runOnUiThread(() -> {
                            List<BoardColumn> newBoardColumns = new ArrayList<>(board.getColumns());
                            boardColumnAdapter.addAll(newBoardColumns);
                        }));

        rv.setAdapter(boardColumnAdapter);
    }
}