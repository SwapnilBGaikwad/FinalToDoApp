package com.example.swapnilg.finaltodoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
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
    }

    public void onAddClick(View view) {
        String name;
        String description;
        EditText nameEditText = (EditText) findViewById(R.id.message_text1);
        EditText descEditText = (EditText) findViewById(R.id.message_text2);
        name = nameEditText.getText().toString();
        description = descEditText.getText().toString();
        Toast.makeText(AddTaskActivity.this, "Name : " + name + " description : " + description, Toast.LENGTH_LONG).show();

        Intent intent = new Intent();
        intent.putExtra("key" , name + "," + description);

        setResult(RESULT_OK , intent);
        finish();
    }

}
