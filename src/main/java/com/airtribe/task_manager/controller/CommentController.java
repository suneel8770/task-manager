package com.airtribe.task_manager.controller;

import com.airtribe.task_manager.entity.Comment;
import com.airtribe.task_manager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/task/{taskId}/user/{userId}")
    public Comment addComment(
            @PathVariable Long taskId,
            @PathVariable Long userId,
            @RequestBody Comment comment) {

        return commentService.addComment(taskId, userId, comment);
    }

    @GetMapping("/task/{taskId}")
    public List<Comment> getCommentsByTask(@PathVariable Long taskId) {
        return commentService.getCommentsByTask(taskId);
    }
}