//package ac.jiu.bobby.project.service;
//
//import ac.jiu.bobby.project.model.User;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//public interface UserService {
//
//    Page<User> getAllUsers(Pageable pageable);
//    Optional<User> getUserById(UUID id);
//    List<User> getUsersByRoleId(UUID roleId);
//    User createUser(User user);
//    User updateUser(UUID id, User userDetails);
//    void softDeleteUser(UUID id);
//
//
//}

package ac.jiu.bobby.project.service;

import ac.jiu.bobby.project.dto.LoginRequestDTO;
import ac.jiu.bobby.project.dto.UserResponseDTO;
import ac.jiu.bobby.project.model.User;
import ac.jiu.bobby.project.repository.UserRepository;
import ac.jiu.bobby.project.security.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDetailsImpl(user);
    }

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Enkripsi password
        userRepository.save(user);
    }

    public UserResponseDTO getUserResponseDTO(User user) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setFirstName(user.getFirstName());
        responseDTO.setLastName(user.getLastName());
        responseDTO.setEmail(user.getUsername());
        responseDTO.setRole(user.getRole().getRoleName());
        return responseDTO;
    }
}
