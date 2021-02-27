package com.nineleaps.rewardandrecognition.service.impl;

import com.nineleaps.rewardandrecognition.dto.AwardDto;
import com.nineleaps.rewardandrecognition.entity.Award;
import com.nineleaps.rewardandrecognition.exceptions.NotFoundException;
import com.nineleaps.rewardandrecognition.repository.AwardRepository;
import com.nineleaps.rewardandrecognition.service.AwardService;
import com.nineleaps.rewardandrecognition.utils.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwardServiceImpl implements AwardService {
    private final AwardRepository awardRepository;

    @Autowired
    public AwardServiceImpl(AwardRepository repository) {
        awardRepository = repository;
    }


    @Override
    public AwardDto getUser(String email) {
        Award entity = awardRepository.findById(email)
                .orElseThrow(() -> new NotFoundException("User Not Found"));
        return DtoUtil.convertByCopy(entity, AwardDto.class);
    }
}