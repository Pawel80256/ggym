package com.ggymserver.service;

import com.ggymserver.dto.LoginDTO;
import com.ggymserver.dto.LoginResponseDTO;
import com.ggymserver.dto.RegisterUserDTO;
import com.ggymserver.entity.User;
import com.ggymserver.mapper.UserMapper;
import com.ggymserver.repository.UserRepository;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.UserRepresentation;
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
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8081/")
                .realm("ggym")
                .username("ggymadmin")
                .password("password")
                .clientId("ggym-server")
                .build();

        UserRepresentation userRep = new UserRepresentation();
        userRep.setUsername(registerUserDTO.name());
        userRep.setEnabled(true);
        userRep.setEmail(registerUserDTO.email());

        Response response = keycloak.realm("ggym").users().create(userRep);
        if (response.getStatus() != 201) {
            throw new RuntimeException("Error creating user");
        }
        response.close();

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
