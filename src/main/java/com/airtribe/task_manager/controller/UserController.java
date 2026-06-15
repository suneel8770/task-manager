package com.airtribe.task_manager.controller;

import com.airtribe.task_manager.dto.LoginRequest;
import com.airtribe.task_manager.entity.Task;
import com.airtribe.task_manager.entity.User;
import com.airtribe.task_manager.service.TaskService;
import com.airtribe.task_manager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }

    @GetMapping("/{userId}/tasks")
    public List<Task> getTasksByUser(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        return userService.updateUser(id, user);
    }
}