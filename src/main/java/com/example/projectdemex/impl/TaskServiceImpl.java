package com.example.projectdemex.impl;

import com.example.projectdemex.dto.TaskDto;
import com.example.projectdemex.model.*;
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

    @Override
    public void save(TaskDto taskDto) {
        Tasks task = new Tasks();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(TaskStatus.OPEN);
        task.setPriority(TaskPriority.LOW);
        task.setDeadline(taskDto.getDeadline());
        task.setUser(taskDto.getUser());
        taskRepo.save(task);
    }
}
