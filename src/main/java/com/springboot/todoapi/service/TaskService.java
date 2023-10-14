package com.springboot.todoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.todoapi.persistence.entity.TaskEntity;
import com.springboot.todoapi.persistence.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<TaskEntity> getTasks(){
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> getTask(Long id){
        return taskRepository.findById(id);
    }

    public TaskEntity saveTask(TaskEntity task){
        return taskRepository.save(task);
    }

    public Optional<TaskEntity> deleteTask(Long id){
        Optional<TaskEntity> task;
        task = taskRepository.findById(id);
        taskRepository.deleteById(id);
        return task;
    }

    public TaskEntity updateTask(TaskEntity request, Long id){
        TaskEntity task = taskRepository.findById(id).get();
        
        task.setTitulo(request.getTitulo());
        task.setDescripcion(request.getDescripcion());
        task.setFechaCreacion(request.getFechaCreacion());
        task.setFechaFin(request.getFechaFin());
        task.setFinalizada(request.isFinalizada());
        task.setEstado(request.getEstado());

        return task;
    }
}
