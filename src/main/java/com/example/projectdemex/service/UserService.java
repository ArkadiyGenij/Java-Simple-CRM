package com.example.projectdemex.service;

import com.example.projectdemex.dto.UserDto;
import com.example.projectdemex.model.User;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);

    User findByUsername(String username);

    List<User> findAllUser();

    List<User> findByName(String name);

    User findById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}
