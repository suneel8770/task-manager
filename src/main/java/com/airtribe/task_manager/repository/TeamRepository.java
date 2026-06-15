package com.airtribe.task_manager.repository;

import com.airtribe.task_manager.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}