package com.example.projectdemex.controller;

import com.example.projectdemex.dto.UserDto;
import com.example.projectdemex.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping("/registration")
    String registrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    String saveUser(UserDto userDto) {
        userServiceImpl.save(userDto);
        return "redirect:/login";
    }

}
