package com.airtribe.task_manager.service;

import com.airtribe.task_manager.entity.Task;
import com.airtribe.task_manager.entity.TaskStatus;
import com.airtribe.task_manager.entity.Team;
import com.airtribe.task_manager.entity.User;
import com.airtribe.task_manager.repository.TaskRepository;
import com.airtribe.task_manager.repository.TeamRepository;
import com.airtribe.task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTaskStatus(Long id, TaskStatus status) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);

        return taskRepository.save(task);
    }

    public Task assignTaskToUser(Long taskId, Long userId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        task.setAssignedUser(user);

        return taskRepository.save(task);
    }
    public Task assignTaskToTeam(Long taskId, Long teamId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        task.setTeam(team);

        return taskRepository.save(task);
    }
    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByAssignedUserId(userId);
    }
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }
    public List<Task> searchTasks(String keyword) {
        return taskRepository.findByTitleContainingIgnoreCase(keyword);
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }
    public Task updateTask(Long id, Task updatedTask) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setDueDate(updatedTask.getDueDate());

        return taskRepository.save(task);
    }
}