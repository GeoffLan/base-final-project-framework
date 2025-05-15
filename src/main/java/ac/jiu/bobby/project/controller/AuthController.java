package ac.jiu.bobby.project.controller;

import ac.jiu.bobby.project.dto.LoginRequestDTO;
import ac.jiu.bobby.project.dto.UserResponseDTO;
import ac.jiu.bobby.project.model.User;
import ac.jiu.bobby.project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
        );

        // Setelah berhasil login, kita dapatkan user dari authentication
        User user = (User) authentication.getPrincipal();
        UserResponseDTO responseDTO = userService.getUserResponseDTO(user);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
