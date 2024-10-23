package com.mat.todo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "task")
public class TaskConfigProperties {
    private boolean allowMultipleTasks;

    public boolean isAllowMultipleTasks() {
        return allowMultipleTasks;
    }

    void setAllowMultipleTasks(final boolean allowMultipleTasks) {
        this.allowMultipleTasks = allowMultipleTasks;
    }
}
