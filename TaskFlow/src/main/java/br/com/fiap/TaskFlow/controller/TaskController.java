package br.com.fiap.TaskFlow.controller;

import br.com.fiap.TaskFlow.model.Task;
import br.com.fiap.TaskFlow.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public Page<Task> getTasks(@RequestParam(required = false) String title, Pageable pageable) {
        return taskService.getTasks(title, pageable);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
}