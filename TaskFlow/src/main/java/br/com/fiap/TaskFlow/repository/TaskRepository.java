package br.com.fiap.TaskFlow.repository;

import br.com.fiap.TaskFlow.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByTitleContaining(String title, Pageable pageable);
}