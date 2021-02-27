package com.nineleaps.rewardandrecognition.service.impl;

import com.nineleaps.rewardandrecognition.dto.FothDateDto;
import com.nineleaps.rewardandrecognition.entity.FothDate;
import com.nineleaps.rewardandrecognition.exceptions.NotFoundException;
import com.nineleaps.rewardandrecognition.repository.FothDateRepository;
import com.nineleaps.rewardandrecognition.service.FothDateService;
import com.nineleaps.rewardandrecognition.utils.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FothDateServiceImpl implements FothDateService {
    private final FothDateRepository fothDateRepository;

    @Autowired
    public FothDateServiceImpl(FothDateRepository repository) {
        fothDateRepository = repository;
    }


    @Override
    public FothDateDto getUser(String email) {
        FothDate entity = fothDateRepository.findById(email)
                .orElseThrow(() -> new NotFoundException("User Not Found"));
        return DtoUtil.convertByCopy(entity, FothDateDto.class);
    }
}
