package com.ggymserver.service;

import com.ggymserver.model.entity.User;
import com.ggymserver.model.request.CreateUserRequest;
import com.ggymserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setUsername(createUserRequest.name());
        user.setEmail(createUserRequest.email());
        user.setPassword(passwordEncoder.encode(createUserRequest.password()));
        userRepository.save(user);
    }
}
