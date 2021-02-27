package com.nineleaps.rewardandrecognition.service.impl;

import com.nineleaps.rewardandrecognition.dto.ProjectDto;
import com.nineleaps.rewardandrecognition.entity.Project;
import com.nineleaps.rewardandrecognition.exceptions.NotFoundException;
import com.nineleaps.rewardandrecognition.repository.ProjectRepository;
import com.nineleaps.rewardandrecognition.service.ProjectService;
import com.nineleaps.rewardandrecognition.utils.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    @Autowired
    public ProjectServiceImpl(ProjectRepository repository) {
        projectRepository = repository;
    }


    @Override
    public ProjectDto getUser(String email) {
        Project entity = projectRepository.findById(email)
                .orElseThrow(() -> new NotFoundException("User Not Found"));
        return DtoUtil.convertByCopy(entity, ProjectDto.class);
    }
}
