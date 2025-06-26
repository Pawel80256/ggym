package com.ggymserver.service;

import com.ggymserver.dto.RegisterUserDTO;
import com.ggymserver.entity.User;
import com.ggymserver.mapper.UserMapper;
import com.ggymserver.repository.UserRepository;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void save(RegisterUserDTO registerUserDTO) {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8081/")
                .realm("ggym")
                .clientId("ggym-server")
                .clientSecret("o2QJVmc6orIparHEIqoNxLBoLo2a12A9") //hide
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();

        UserRepresentation userRep = createUserRepresentation(registerUserDTO, keycloak);

        Response response = keycloak.realm("ggym").users().create(userRep);

        if (response.getStatus() != 201) {
            throw new RuntimeException("Error creating user");
        }

        String userId = CreatedResponseUtil.getCreatedId(response);
        response.close();

        assignRole(userId, keycloak);

        User user = userMapper.toEntity(registerUserDTO);
        userRepository.save(user);
    }

    private UserRepresentation createUserRepresentation(RegisterUserDTO registerUserDTO, Keycloak keycloak) {
        UserRepresentation userRep = new UserRepresentation();
        userRep.setUsername(registerUserDTO.name());
        userRep.setEmail(registerUserDTO.email());
        userRep.setEnabled(true);

        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(registerUserDTO.password());
        credential.setTemporary(false);

        userRep.setCredentials(Collections.singletonList(credential));
        return userRep;
    }

    private void assignRole (String userId, Keycloak keycloak) {
        RoleRepresentation userRole = keycloak.realm("ggym")
                .roles()
                .get("USER")
                .toRepresentation();

        keycloak.realm("ggym")
                .users()
                .get(userId)
                .roles()
                .realmLevel()
                .add(Collections.singletonList(userRole));
    }
}
