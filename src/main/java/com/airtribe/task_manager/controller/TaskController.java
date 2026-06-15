package com.airtribe.task_manager.controller;

import com.airtribe.task_manager.entity.Task;
import com.airtribe.task_manager.entity.TaskStatus;
import com.airtribe.task_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @PutMapping("/{id}/status")
    public Task updateTaskStatus(
            @PathVariable Long id,
            @RequestParam TaskStatus status) {

        return taskService.updateTaskStatus(id, status);
    }
    @PutMapping("/{taskId}/assign/{userId}")
    public Task assignTaskToUser(
            @PathVariable Long taskId,
            @PathVariable Long userId) {

        return taskService.assignTaskToUser(taskId, userId);
    }
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }
    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String keyword) {
        return taskService.searchTasks(keyword);
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        return "Task Deleted Successfully";
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @RequestBody Task task) {

        return taskService.updateTask(id, task);
    }
    @PutMapping("/{taskId}/team/{teamId}")
    public Task assignTaskToTeam(
            @PathVariable Long taskId,
            @PathVariable Long teamId) {

        return taskService.assignTaskToTeam(taskId, teamId);
    }
}