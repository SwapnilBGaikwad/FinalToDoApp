package com.example.swapnilg.finaltodoapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

/**
 * Created by swapnilg on 07/01/16.
 *
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.TaskHolder> {

    LinkedList<Task> linkedList;

    public CustomAdapter(LinkedList<Task> linkedList) {
        this.linkedList = linkedList;
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item , parent , false);

        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskHolder holder, int position) {
        holder.getTextViewName().setText(linkedList.get(position).getName());
        holder.getTextViewDescription().setText(linkedList.get(position).getDescription());
        holder.getDeleteButton().setTag(position);
    }

    @Override
    public int getItemCount() {
        return linkedList.size();
    }

    public static class TaskHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewDescription;
        private Button deleteButton;

        public TaskHolder(View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.task_item_name);
            textViewDescription = (TextView) itemView.findViewById(R.id.task_description_id);
            deleteButton = (Button) itemView.findViewById(R.id.delete_button);
        }

        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewDescription() {
            return textViewDescription;
        }

        public Button getDeleteButton() {
            return deleteButton;
        }
    }
}
