package com.example.swapnilg.finaltodoapp;

/**
 * Created by swapnilg on 07/01/16.
 *
 */
public class Task {
    private String name;
    private String description;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " " + description;
    }
}
