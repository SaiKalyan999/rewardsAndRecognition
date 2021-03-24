package com.nineleaps.rewardandrecognition.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.UUID;
@Getter
@NoArgsConstructor
public class NomineeFormDto {
    private UUID id;
    private String year;
    private String name;
    private String comments;
    private String month;
    private UUID managerId;
    private UUID projectId;
    private UUID awardTypeId;
    private UUID nomineeId;
    private String createdBy;
    private String modifiedBy;





}
