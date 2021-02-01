package com.nineleaps.rewardandrecognition.service.impl;

import com.nineleaps.rewardandrecognition.dto.UserDto;
import com.nineleaps.rewardandrecognition.entity.UserEntity;
import com.nineleaps.rewardandrecognition.exceptions.NotFoundException;
import com.nineleaps.rewardandrecognition.repository.UserEntityRepository;
import com.nineleaps.rewardandrecognition.service.UserService;
import com.nineleaps.rewardandrecognition.utils.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserServiceImpl(UserEntityRepository repository) {
        userEntityRepository = repository;
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity entity = userEntityRepository.findById(email)
                .orElseThrow(() -> new NotFoundException("User Not Found"));
        return DtoUtil.convertByCopy(entity, UserDto.class);
    }
}
