package com.nineleaps.rewardandrecognition.service;
import com.nineleaps.rewardandrecognition.dto.AwardDto;


public interface AwardService {
    AwardDto getUser(final String email);
}
