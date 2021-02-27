package com.nineleaps.rewardandrecognition.service.impl;

import com.nineleaps.rewardandrecognition.dto.NomineeFormDto;
import com.nineleaps.rewardandrecognition.entity.NomineeForm;
import com.nineleaps.rewardandrecognition.exceptions.NotFoundException;
import com.nineleaps.rewardandrecognition.repository.NomineeFormRepository;
import com.nineleaps.rewardandrecognition.service.NomineeFormService;
import com.nineleaps.rewardandrecognition.utils.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NomineeFormServiceImpl implements NomineeFormService {
    private final NomineeFormRepository nomineeformRepository;
    @Autowired
    public NomineeFormServiceImpl(NomineeFormRepository repository) {
        nomineeformRepository = repository;
    }


    @Override
    public NomineeFormDto getUser(String email) {

        NomineeForm entity = nomineeformRepository.findById(email)
                .orElseThrow(() -> new NotFoundException("User Not Found"));
        return DtoUtil.convertByCopy(entity, NomineeFormDto.class);
    }
}
