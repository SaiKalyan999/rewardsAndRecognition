package com.nineleaps.rewardandrecognition.service;

import com.nineleaps.rewardandrecognition.dto.ProjectDto;
import org.springframework.http.ResponseEntity;

public interface ProjectService {
    ResponseEntity<String> saveProject(ProjectDto projectDto);
    //ProjectDto getUser(final String email);
    //ProjectDto getUserByprojectName(String name);
}
