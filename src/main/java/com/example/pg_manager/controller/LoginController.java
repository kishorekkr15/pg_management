package com.example.pg_manager.controller;

import com.example.pg_manager.model.Login;
import com.example.pg_manager.service.LoginService;
import com.example.pg_manager.dto.LoginDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController                      // Marks this class as a REST controller (handles HTTP requests)
@RequestMapping("/login")            // Base URL path → all routes will start with /login
public class LoginController {

    private final LoginService loginService;  // To call service layer methods

    // ✅ Constructor Injection — Spring will automatically provide LoginService object
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // ✅ GET all logins → http://localhost:8080/login
    @GetMapping
    public List<Login> getAllLogins() {
        return loginService.getAllLogins();
    }

    // ✅ GET a single login by ID → http://localhost:8080/login/1
    @GetMapping("/{id}")
    public Optional<Login> getLoginById(@PathVariable Long id) {
        return loginService.getLoginById(id);
    }

    // ✅ POST a new login → http://localhost:8080/login
    // Example JSON:
    // {
    //   "name": "John",
    //   "phoneNumber": "9876543210",
    //   "email": "john@mail.com",
    //   "password": "mypassword",
    //   "isActive": true,
    //   "isDeleted": false
    // }
    @PostMapping
    public LoginDTO createLogin(@RequestBody LoginDTO LoginDTO) {
        return loginService.saveLogin(LoginDTO);
    }

    // ✅ PUT (update) login → http://localhost:8080/login/1
    // @PutMapping("/{id}")
    // public Login updateLogin(@PathVariable Long id, @RequestBody Login login) {
    //     return loginService.updateLogin(id, login);
    // }

    // ✅ DELETE login → http://localhost:8080/login/1
    @DeleteMapping("/{id}")
    public void deleteLogin(@PathVariable Long id) {
        loginService.deleteLogin(id);
    }
}
