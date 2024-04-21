package com.example.projectdemex.impl;

import com.example.projectdemex.dto.UserDto;
import com.example.projectdemex.model.Role;
import com.example.projectdemex.model.User;
import com.example.projectdemex.repo.UserRepo;
import com.example.projectdemex.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    @Override
    public void save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setLastname(userDto.getLastname());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Пользователь с ID: " + id + " не найден!"));
    }

    @Override
    public void updateUser(User user) {
        User updateUser = userRepo.findById(user.getId()).orElse(null);
        if (updateUser == null){
            throw new IllegalArgumentException("Пользователь не найден!");
        }
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setLastname(user.getLastname());
        updateUser.setUsername(user.getUsername());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
        userRepo.save(updateUser);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepo.deleteById(id);
    }
}
