package com.nineleaps.rewardandrecognition.service.impl;

import com.nineleaps.rewardandrecognition.dto.UserDto;
import com.nineleaps.rewardandrecognition.repository.UserEntityRepository;
import com.nineleaps.rewardandrecognition.entity.UserEntity;
import com.nineleaps.rewardandrecognition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserDto getUser(String email) {
        return null;
    }
}
