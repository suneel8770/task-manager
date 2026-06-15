package com.airtribe.task_manager.repository;

import com.airtribe.task_manager.entity.Task;
import com.airtribe.task_manager.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByAssignedUserId(Long userId);
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByTitleContainingIgnoreCase(String keyword);

}