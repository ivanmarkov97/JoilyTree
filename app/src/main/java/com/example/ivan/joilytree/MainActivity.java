package com.example.ivan.joilytree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.example.ivan.joilytree.MainTreeRecyclerView.MainTreeDragAndSwipe.ItemTouchHelperCallback;
import com.example.ivan.joilytree.MainTreeRecyclerView.Task;
import com.example.ivan.joilytree.MainTreeRecyclerView.TaskAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mainTree;
    private TaskAdapter taskAdapter;
    private ArrayList<Task> tasks = new ArrayList<>();
    private Button addTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTree = (RecyclerView) findViewById(R.id.main_tree);
        mainTree.setHasFixedSize(true);
        mainTree.setLayoutManager(new LinearLayoutManager(this));

        taskAdapter = new TaskAdapter(getApplicationContext());
        tasks = fillTestTasks(tasks);
        taskAdapter.setTasks(tasks);

        mainTree.setAdapter(taskAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(taskAdapter));
        itemTouchHelper.attachToRecyclerView(mainTree);

        addTaskButton = (Button) findViewById(R.id.add_task_main);
        addTaskButton.setOnClickListener(this);

    }

    public ArrayList<Task> fillTestTasks(ArrayList<Task> testTasks){
        Date taskDate = new Date();
        for(int i = 0; i < 20; i++){
            tasks.add(new Task("task " + i, taskDate));
        }
        return testTasks;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_task_main:
                tasks.add(new Task("new task", new Date()));
                taskAdapter.notifyItemInserted(tasks.size());
                break;
            default:
                break;
        }
    }
}
