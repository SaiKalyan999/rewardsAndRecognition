package com.nineleaps.rewardandrecognition.service;
import com.nineleaps.rewardandrecognition.dto.NomineeFormDto;


public interface NomineeFormService {
    NomineeFormDto getUser(final String email);
}
