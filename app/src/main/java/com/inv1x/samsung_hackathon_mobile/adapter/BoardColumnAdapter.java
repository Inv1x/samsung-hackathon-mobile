package com.inv1x.samsung_hackathon_mobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.inv1x.samsung_hackathon_mobile.R;
import com.inv1x.samsung_hackathon_mobile.databinding.BoardColumnBoardListBinding;
import com.inv1x.samsung_hackathon_mobile.databinding.ColumnTaskBoardListBinding;
import com.inv1x.samsung_hackathon_mobile.model.BoardColumn;
import com.inv1x.samsung_hackathon_mobile.model.ColumnTask;

import java.util.ArrayList;
import java.util.List;

public class BoardColumnAdapter extends RecyclerView.Adapter<BoardColumnAdapter.BoardColumnViewHolder> {
    private List<BoardColumn> boardColumns = new ArrayList<>();

    @NonNull
    @Override
    public BoardColumnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.board_column_board_list, parent, false);
        return new BoardColumnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardColumnViewHolder holder, int position) {
        holder.bind(boardColumns.get(position));
    }

    @Override
    public int getItemCount() {
        return boardColumns.size();
    }

    public void addAll(List<BoardColumn> newBoardColumns) {
        boardColumns.addAll(newBoardColumns);
        notifyDataSetChanged();
    }


    public class BoardColumnViewHolder extends RecyclerView.ViewHolder {

        BoardColumnBoardListBinding boardColumnBoardListBinding;

        public BoardColumnViewHolder(@NonNull View view) {
            super(view);
            boardColumnBoardListBinding = BoardColumnBoardListBinding.bind(view);
        }

        public void bind(BoardColumn boardColumn) {
            boardColumnBoardListBinding.heading.setText(boardColumn.getHeading());
            ColumnTaskAdapter childMembersAdapter = new ColumnTaskAdapter();
            List<ColumnTask> newColumnTasks = new ArrayList<>(boardColumn.getColumnTasks());
            childMembersAdapter.addAll(newColumnTasks);
            boardColumnBoardListBinding.columnTaskRecyclerView.setLayoutManager(new LinearLayoutManager(boardColumnBoardListBinding.getRoot().getContext(), LinearLayoutManager.VERTICAL, false));
            boardColumnBoardListBinding.columnTaskRecyclerView.setAdapter(childMembersAdapter);
        }
    }
}
