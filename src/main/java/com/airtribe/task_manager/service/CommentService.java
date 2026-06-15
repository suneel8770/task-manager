package com.airtribe.task_manager.service;

import com.airtribe.task_manager.entity.Comment;
import com.airtribe.task_manager.entity.Task;
import com.airtribe.task_manager.entity.User;
import com.airtribe.task_manager.repository.CommentRepository;
import com.airtribe.task_manager.repository.TaskRepository;
import com.airtribe.task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Comment addComment(Long taskId, Long userId, Comment comment) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        comment.setTask(task);
        comment.setUser(user);

        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByTask(Long taskId) {
        return commentRepository.findByTaskId(taskId);
    }
}