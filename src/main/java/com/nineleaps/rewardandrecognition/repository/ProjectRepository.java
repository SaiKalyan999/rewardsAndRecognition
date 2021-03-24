package com.nineleaps.rewardandrecognition.repository;

import com.nineleaps.rewardandrecognition.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectRepository extends JpaRepository<Project, String> {
    //Project findByprojectName(String name);

    /*@Query("select pr.projectName from Project pr where pr.managerId =?1 ")
    String getProjectName(UUID managerId);

*/


}
