package br.com.fiap.TaskFlow.repository;

import br.com.fiap.TaskFlow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}