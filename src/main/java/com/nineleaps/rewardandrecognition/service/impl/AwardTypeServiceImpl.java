package com.nineleaps.rewardandrecognition.service.impl;

import com.nineleaps.rewardandrecognition.dto.AwardTypeDto;
import com.nineleaps.rewardandrecognition.entity.AwardType;
import com.nineleaps.rewardandrecognition.exceptions.NotFoundException;
import com.nineleaps.rewardandrecognition.repository.AwardTypeRepository;
import com.nineleaps.rewardandrecognition.service.AwardTypeService;
import com.nineleaps.rewardandrecognition.utils.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwardTypeServiceImpl implements AwardTypeService {

    private final AwardTypeRepository awardTypeRepository;

    @Autowired
    public AwardTypeServiceImpl(AwardTypeRepository repository) {
        awardTypeRepository = repository;
    }
    @Override
    public AwardTypeDto getUser(String email) {
        AwardType entity = awardTypeRepository.findById(email)
                .orElseThrow(() -> new NotFoundException("User Not Found"));
        return DtoUtil.convertByCopy(entity, AwardTypeDto.class);
    }
}
