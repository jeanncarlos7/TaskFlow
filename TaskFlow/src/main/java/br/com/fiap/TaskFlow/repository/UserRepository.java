package br.com.fiap.TaskFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.TaskFlow.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}