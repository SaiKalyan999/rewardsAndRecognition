package com.nineleaps.rewardandrecognition.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProjectDto {
    private String projectName;
    private UUID clientId;
    private UUID managerId;



}
