package br.com.fiap.TaskFlow.service;

import com.taskflow.model.Task;
import com.taskflow.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Page<Task> getTasks(String title, Pageable pageable) {
        return taskRepository.findByTitleContaining(title, pageable);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Outros métodos (update, delete, etc.)
}