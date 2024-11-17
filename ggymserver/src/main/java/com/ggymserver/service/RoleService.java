package com.ggymserver.service;

import com.ggymserver.entity.Role;
import com.ggymserver.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").orElseThrow(
                () -> new IllegalArgumentException("Role 'user' not found")
        );
    }
}
