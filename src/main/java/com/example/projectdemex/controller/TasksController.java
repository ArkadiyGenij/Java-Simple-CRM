package com.example.projectdemex.controller;

import com.example.projectdemex.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TasksController {

    private final TaskService taskService;

    @GetMapping("/admin/tasks/list")
    String findAllTasks(Model model) {
        model.addAttribute("tasks", taskService.findAllTask());
        return "tasks_list";
    }

}
