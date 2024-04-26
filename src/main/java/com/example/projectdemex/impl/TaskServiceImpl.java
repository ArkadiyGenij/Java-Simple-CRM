package com.example.projectdemex.impl;

import com.example.projectdemex.model.Tasks;
import com.example.projectdemex.repo.TaskRepo;
import com.example.projectdemex.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Override
    public List<Tasks> findAllTask() {
        return taskRepo.findAll();
    }
}
