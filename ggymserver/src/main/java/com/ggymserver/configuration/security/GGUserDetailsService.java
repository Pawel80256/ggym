package com.ggymserver.configuration.security;

import com.ggymserver.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class GGUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    //todo: sprawdzic czy jest stosowane
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new GGUserDetails(user);
    }
}
