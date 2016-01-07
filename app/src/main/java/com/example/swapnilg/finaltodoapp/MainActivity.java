package com.example.swapnilg.finaltodoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<Task> linkedList;
    RecyclerView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listView = (RecyclerView) findViewById(R.id.recycler_view);
        listView.setLayoutManager(layoutManager);

        linkedList = new LinkedList<>();

        //Creating two new tasks.
        Task task1 = new Task("Java" , "Language");
        Task task2 = new Task("Android studio" , "Framework");
        linkedList.add(task1);
        linkedList.add(task2);


        CustomAdapter adapter = new CustomAdapter(linkedList);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onAddClick(View view) {
        Intent intent = new Intent(this , AddTaskActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Toast.makeText(MainActivity.this, "Hi onActivityResult called.", Toast.LENGTH_SHORT).show();
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String[] tasks = intent.getStringExtra("key").split(",");
                Task task = new Task(tasks[0] , tasks[1]);
                linkedList.add(task);
                CustomAdapter adapter = new CustomAdapter(linkedList);
                listView.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "Task  is  " + task, Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void onDeleteClick(View view) {
        if (view instanceof Button) {
            Button button = (Button) view;
            Toast.makeText(MainActivity.this, "Buton Tag : " + button.getTag() + " Removed Data : " + linkedList.get(Integer.parseInt(button.getTag()+"")), Toast.LENGTH_SHORT).show();

            linkedList.remove(Integer.parseInt(button.getTag() + ""));

            CustomAdapter adapter = new CustomAdapter(linkedList);
            listView.setAdapter(adapter);
        }

    }

}
