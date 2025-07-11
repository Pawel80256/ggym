package com.ggymserver.controller;

import com.ggymserver.dto.RegisterUserDTO;
import com.ggymserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterUserDTO registerUserDTO) {
        userService.save(registerUserDTO);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/test-for-admin")
    public ResponseEntity<String> test() {
        int x = 2+1;
        for (int i = 0 ; i <= x ; i++){
            System.out.println("xd");
        }
        return ResponseEntity.ok("testADMIN");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/test-for-user")
    public ResponseEntity<String> test2() {
        int x = 2+1;
        for (int i = 0 ; i <= x ; i++){
            System.out.println("xd");
        }
        return ResponseEntity.ok("testUSER");
    }

}
