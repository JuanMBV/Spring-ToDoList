package com.springboot.todoapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todoapi.persistence.entity.TaskEntity;
import com.springboot.todoapi.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskEntity> getTasks(){
        return this.taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Optional<TaskEntity> getTask(@PathVariable("id") Long id){
        return this.taskService.getTask(id);
    }

    @PostMapping
    public TaskEntity saveTask(@RequestBody TaskEntity task){
        return this.taskService.saveTask(task);
    }

    @DeleteMapping
    public Optional<TaskEntity> deleteTask(@RequestBody Long id){
        return this.taskService.deleteTask(id);
    }

    @PutMapping 
    public TaskEntity updateTask(@RequestBody TaskEntity request, Long id){
        return this.taskService.updateTask(request, id);
    }
}
