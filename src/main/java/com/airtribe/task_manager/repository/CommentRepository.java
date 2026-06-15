package com.airtribe.task_manager.repository;

import com.airtribe.task_manager.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTaskId(Long taskId);

}