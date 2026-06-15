package com.airtribe.task_manager.service;

import com.airtribe.task_manager.entity.Team;
import com.airtribe.task_manager.entity.User;
import com.airtribe.task_manager.repository.TeamRepository;
import com.airtribe.task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    public Team createTeam(Team team) {

        if (team.getMembers() == null) {
            team.setMembers(new ArrayList<>());
        }

        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team addMemberToTeam(Long teamId, Long userId) {

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        team.getMembers().add(user);

        return teamRepository.save(team);
    }
}