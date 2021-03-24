package com.nineleaps.rewardandrecognition.service.impl;

import com.nineleaps.rewardandrecognition.dto.ProjectDto;
import com.nineleaps.rewardandrecognition.entity.Project;
import com.nineleaps.rewardandrecognition.repository.ProjectRepository;
import com.nineleaps.rewardandrecognition.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository repository) {
        projectRepository = repository;
    }

    @Override
    public ResponseEntity<String> saveProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setProjectName(projectDto.getProjectName());
        project.setManagerId(projectDto.getManagerId());
        project.setClientId(projectDto.getClientId());
        project.setCreatedBy("Admin");
        project.setCreated_date(new Date());
        project.setModifiedBy("Admin");
        project.setLastModifiedDate(new Date());

        projectRepository.save(project);
        return new ResponseEntity<>("Project Saved!", HttpStatus.CREATED);

    }


}
