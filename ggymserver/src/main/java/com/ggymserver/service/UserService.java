package com.ggymserver.service;

import com.ggymserver.dto.request.LoginDTO;
import com.ggymserver.dto.request.RegisterUserDTO;
import com.ggymserver.dto.response.LoginResponseDTO;
import com.ggymserver.entity.User;
import com.ggymserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public void save(RegisterUserDTO registerUserDTO) {
        User user = new User();
        user.setName(registerUserDTO.name());
        user.setEmail(registerUserDTO.email());
        user.setPassword(passwordEncoder.encode(registerUserDTO.password()));
        userRepository.save(user);
    }

    public LoginResponseDTO login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.name(), loginDTO.password())
        );
        String jwt = jwtService.generateToken((UserDetails) authentication.getPrincipal());

        return new LoginResponseDTO(jwt);
    }
}
