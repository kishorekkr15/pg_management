package com.example.pg_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pg_manager.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    // You can add custom queries if needed, e.g.:
    Login findByEmail(String email);
}
