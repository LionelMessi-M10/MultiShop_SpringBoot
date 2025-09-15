package com.multishop.controller.web;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multishop.entity.Role;
import com.multishop.entity.User;
import com.multishop.enums.ERole;
import com.multishop.model.request.AuthenticationRequest;
import com.multishop.model.request.UserRequest;
import com.multishop.model.response.AuthenticationResponse;
import com.multishop.repository.RoleRepository;
import com.multishop.repository.UserRepository;
import com.multishop.security.CustomUserDetailsService;
import com.multishop.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Incorrect username or password");
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        // 1. Kiểm tra username đã tồn tại chưa
        if (userRepository.findByUsername(userRequest.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken!");
        }

        // 2. Tạo một đối tượng User mới
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        // 3. Gán vai trò (Role) mặc định
        // Tìm vai trò 'SELLER' hoặc 'BUYER' trong database
        Role sellerRole = roleRepository.findByCode(ERole.valueOf(userRequest.getRoleCode())).orElseThrow(() -> new RuntimeException("Role not found!"));
        
        user.setRoles(Collections.singleton(sellerRole));

        // 4. Lưu User vào database
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }
}