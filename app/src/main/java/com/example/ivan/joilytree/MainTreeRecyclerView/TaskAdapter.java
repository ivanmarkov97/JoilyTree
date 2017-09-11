package com.example.ivan.joilytree.MainTreeRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ivan.joilytree.MainTreeRecyclerView.MainTreeDragAndSwipe.ItemTouchHelperAdapter;
import com.example.ivan.joilytree.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ivan on 11.09.2017.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> implements ItemTouchHelperAdapter{

    private List<Task> tasks;
    private Context context;

    public TaskAdapter(Context context){
        this.context = context;
    }

    public void setTasks(List<Task> tasks){
        this.tasks = tasks;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View task_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout, parent, false);
        return new TaskViewHolder(task_view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.taskName.setText(task.getTaskName());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        for(int i = fromPosition; i < toPosition; i++){
            Collections.swap(tasks, i, i + 1);
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        tasks.remove(position);
        notifyItemRemoved(position);
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{

        private TextView taskName;
        private ImageView taskSubtaskImage;

        public TaskViewHolder(View itemView) {
            super(itemView);

            taskName = (TextView) itemView.findViewById(R.id.task_name);
            taskSubtaskImage = (ImageView) itemView.findViewById(R.id.task_contains_subtasks_image);

        }
    }
}
