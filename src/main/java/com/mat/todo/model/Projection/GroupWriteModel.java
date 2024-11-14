package com.mat.todo.model.Projection;

import com.mat.todo.model.TaskGroup;

import java.util.Set;
import java.util.stream.Collectors;

public class GroupWriteModel {

    private String description;
    private Set<GroupTaskWriteModel> tasks;

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Set<GroupTaskWriteModel> getTasks() {
        return tasks;
    }

    public void setTasks(final Set<GroupTaskWriteModel> tasks) {
        this.tasks = tasks;
    }

    public TaskGroup toGroup() {
        TaskGroup group = new TaskGroup();
        group.setTitle(description);
        group.setTasks(
                tasks.stream()
                .map(GroupTaskWriteModel::toTask)
                        .collect(Collectors.toSet()));
        return group;
    }
}
