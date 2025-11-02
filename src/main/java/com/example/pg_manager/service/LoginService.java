package com.example.pg_manager.service;

import com.example.pg_manager.dto.LoginDTO;
import com.example.pg_manager.model.Login;
import com.example.pg_manager.model.Profile;
import com.example.pg_manager.repository.LoginRepository;
import com.example.pg_manager.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final ProfileRepository profileRepository;

    // Constructor injection (best practice)
    public LoginService(LoginRepository loginRepository, ProfileRepository profileRepository) {
        this.loginRepository = loginRepository;
        this.profileRepository = profileRepository;
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
    // FIX: Changed return type from 'Login' to 'LoginDTO'
    public LoginDTO saveLogin(LoginDTO dto) {
        Login login = new Login();
        login.setName(dto.getName());
        login.setPhoneNumber(dto.getPhoneNumber());
        login.setEmail(dto.getEmail());
        login.setPassword(dto.getPassword());
        login.setActive(dto.isActive());
        login.setDeleted(dto.isDeleted());

        // 2. Create Profile entity from DTO fields
        Profile profile = new Profile();
        profile.setCity(dto.getCity());
        profile.setDistrict(dto.getDistrict());
        profile.setState(dto.getState());
        profile.setPincode(dto.getPincode());

        // 3. Establish bi-directional relationship.
        login.setProfile(profile);

        Login savedLogin = loginRepository.save(login);

        // 4. Map the saved entities back to the flattened DTO for response
        return mapToDTO(savedLogin);
    }

    // ✅ Delete user
    public void deleteLogin(Long id) {
        loginRepository.deleteById(id);
    }

    // ✅ Find by email (custom)
    public Login findByEmail(String email) {
        return loginRepository.findByEmail(email);
    }

    public LoginDTO mapToDTO(Login login) {
        LoginDTO dto = new LoginDTO();
        // Since ID is generated, ensure it's mapped back if needed in the DTO
        // dto.setId(login.getId());
        dto.setName(login.getName());
        dto.setPhoneNumber(login.getPhoneNumber());
        dto.setEmail(login.getEmail());
        dto.setPassword(login.getPassword());
        dto.setActive(login.isActive());
        dto.setDeleted(login.isDeleted());

        // Map Profile fields directly into the flattened DTO
        Profile profile = login.getProfile();
        if (profile != null) {
            dto.setCity(profile.getCity());
            dto.setDistrict(profile.getDistrict());
            dto.setState(profile.getState());
            dto.setPincode(profile.getPincode());
        }
        return dto;
    }
}