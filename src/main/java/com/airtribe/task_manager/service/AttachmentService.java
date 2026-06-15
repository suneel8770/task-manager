package com.airtribe.task_manager.service;

import com.airtribe.task_manager.entity.Attachment;
import com.airtribe.task_manager.entity.Task;
import com.airtribe.task_manager.repository.AttachmentRepository;
import com.airtribe.task_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private TaskRepository taskRepository;

    public Attachment addAttachment(Long taskId, Attachment attachment) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        attachment.setTask(task);

        return attachmentRepository.save(attachment);
    }

    public List<Attachment> getAttachmentsByTask(Long taskId) {
        return attachmentRepository.findByTaskId(taskId);
    }
}