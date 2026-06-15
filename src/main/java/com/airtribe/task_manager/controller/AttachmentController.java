package com.airtribe.task_manager.controller;

import com.airtribe.task_manager.entity.Attachment;
import com.airtribe.task_manager.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @PostMapping("/task/{taskId}")
    public Attachment addAttachment(
            @PathVariable Long taskId,
            @RequestBody Attachment attachment) {

        return attachmentService.addAttachment(taskId, attachment);
    }

    @GetMapping("/task/{taskId}")
    public List<Attachment> getAttachmentsByTask(
            @PathVariable Long taskId) {

        return attachmentService.getAttachmentsByTask(taskId);
    }
}