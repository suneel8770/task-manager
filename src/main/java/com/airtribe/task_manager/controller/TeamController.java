package com.airtribe.task_manager.controller;

import com.airtribe.task_manager.entity.Team;
import com.airtribe.task_manager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping("/{teamId}/users/{userId}")
    public Team addMemberToTeam(
            @PathVariable Long teamId,
            @PathVariable Long userId) {

        return teamService.addMemberToTeam(teamId, userId);
    }
}