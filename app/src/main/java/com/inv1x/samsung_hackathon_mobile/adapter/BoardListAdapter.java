package com.inv1x.samsung_hackathon_mobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.inv1x.samsung_hackathon_mobile.BoardActivity;
import com.inv1x.samsung_hackathon_mobile.R;
import com.inv1x.samsung_hackathon_mobile.databinding.BoardBoardListBinding;
import com.inv1x.samsung_hackathon_mobile.model.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardListAdapter extends RecyclerView.Adapter<BoardListAdapter.BoardListViewHolder> {
    private List<Board> boards = new ArrayList<>();

    @NonNull
    @Override
    public BoardListAdapter.BoardListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.board_board_list, parent, false);
        return new BoardListAdapter.BoardListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardListViewHolder holder, int position) {
        Board board = boards.get(position);
        holder.bind(board);
        holder.itemView.findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.boardBoardListBinding.getRoot().getContext(), BoardActivity.class);
                Bundle b = new Bundle();
                b.putLong("boardId", board.getId());
                intent.putExtras(b);
                holder.boardBoardListBinding.getRoot().getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return boards.size();
    }

    public void addAll(List<Board> newBoards) {
        boards.addAll(newBoards);
        notifyDataSetChanged();
    }

    public class BoardListViewHolder extends RecyclerView.ViewHolder {
        BoardBoardListBinding boardBoardListBinding;

        public BoardListViewHolder(@NonNull View view) {
            super(view);
            boardBoardListBinding = BoardBoardListBinding.bind(view);
        }

        public void bind(Board board) {
            boardBoardListBinding.title.setText(board.getTitle());
        }
    }
}
