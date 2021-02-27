package com.nineleaps.rewardandrecognition.repository;

import com.nineleaps.rewardandrecognition.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectRepository extends JpaRepository<Project, String> {
}
