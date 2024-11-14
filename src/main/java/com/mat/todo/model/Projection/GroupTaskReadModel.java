package com.mat.todo.model.Projection;

import com.mat.todo.model.Task;

public class GroupTaskReadModel {

    private String description;
    private boolean done;

    public GroupTaskReadModel(Task soureTask) {
        this.description = soureTask.getDescription();
        this.done = soureTask.isDone();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }
}
