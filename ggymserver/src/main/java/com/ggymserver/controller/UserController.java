package com.ggymserver.controller;

import com.ggymserver.model.request.CreateUserRequest;
import com.ggymserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody CreateUserRequest createUserRequest) {
        userService.save(createUserRequest);
        return ResponseEntity.ok().build();
    }
}
