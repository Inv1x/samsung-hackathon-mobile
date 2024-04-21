package com.inv1x.samsung_hackathon_mobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.inv1x.samsung_hackathon_mobile.R;
import com.inv1x.samsung_hackathon_mobile.databinding.ColumnTaskBoardViewBinding;
import com.inv1x.samsung_hackathon_mobile.model.ColumnTask;

import java.util.ArrayList;
import java.util.List;

public class ColumnTaskAdapter extends RecyclerView.Adapter<ColumnTaskAdapter.ColumnTaskViewHolder> {
    private List<ColumnTask> columnTasks = new ArrayList<>();

    @NonNull
    @Override
    public ColumnTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.column_task_board_view, parent, false);
        return new ColumnTaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColumnTaskViewHolder holder, int position) {
        holder.bind(columnTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return columnTasks.size();
    }

    public void addAll(List<ColumnTask> newColumnTasks) {
        columnTasks.addAll(newColumnTasks);
        notifyDataSetChanged();
    }


    public class ColumnTaskViewHolder extends RecyclerView.ViewHolder {

        ColumnTaskBoardViewBinding columnTaskBoardViewBinding;

        public ColumnTaskViewHolder(@NonNull View view) {
            super(view);
            columnTaskBoardViewBinding = ColumnTaskBoardViewBinding.bind(view);
        }

        public void bind(ColumnTask columnTask) {
            columnTaskBoardViewBinding.description.setText(columnTask.getDescription());
        }
    }
}
