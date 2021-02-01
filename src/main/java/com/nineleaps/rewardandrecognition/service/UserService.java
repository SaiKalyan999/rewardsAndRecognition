package com.nineleaps.rewardandrecognition.service;

import com.nineleaps.rewardandrecognition.dto.UserDto;

public interface UserService {

    UserDto getUser(final String email);
}
