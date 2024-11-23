package com.ggymserver.service;

import com.ggymserver.dto.LoginDTO;
import com.ggymserver.dto.LoginResponseDTO;
import com.ggymserver.dto.RegisterUserDTO;
import com.ggymserver.entity.User;
import com.ggymserver.mapper.UserMapper;
import com.ggymserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RoleService roleService;

    public void save(RegisterUserDTO registerUserDTO) {
        User user = userMapper.toEntity(registerUserDTO);
        user.setRoles(Collections.singleton(roleService.getUserRole()));
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
