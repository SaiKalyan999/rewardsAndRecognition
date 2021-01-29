package com.nineleaps.rewardandrecognition.service;

import com.nineleaps.rewardandrecognition.dto.UserDto;
import com.nineleaps.rewardandrecognition.entity.UserEntity;

public interface UserService {

    UserDto getUser(final String email);
}
