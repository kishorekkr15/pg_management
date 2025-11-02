package com.example.pg_manager.service;

import com.example.pg_manager.model.Login;
import com.example.pg_manager.repository.LoginRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    // Constructor injection (best practice)
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    // ✅ Get all users
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    // ✅ Get user by ID
    public Optional<Login> getLoginById(Long id) {
        return loginRepository.findById(id);
    }

    // ✅ Create or update user
    public Login saveLogin(Login login) {
        return loginRepository.save(login);
    }

    // ✅ Delete user
    public void deleteLogin(Long id) {
        loginRepository.deleteById(id);
    }

    // ✅ Find by email (custom)
    public Login findByEmail(String email) {
        return loginRepository.findByEmail(email);
    }
}
