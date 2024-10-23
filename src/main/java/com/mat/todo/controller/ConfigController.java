package com.mat.todo.controller;

import com.mat.todo.TaskConfigProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    private DataSourceProperties url;
    private TaskConfigProperties myProp;

    ConfigController(final DataSourceProperties url, final TaskConfigProperties myProp) {
        this.url = url;
        this.myProp = myProp;
    }

    @GetMapping("/url")
    public String getUrl() {
        return url.getUrl();
    }

    @GetMapping("myProp")
    public boolean getProp() {
        return myProp.isAllowMultipleTasks();
    }
}