package com.nineleaps.rewardandrecognition.service;

import com.nineleaps.rewardandrecognition.dto.UserDto;
import com.nineleaps.rewardandrecognition.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {


    UserDto getUserByemailAddress(final String email);

    UserDto getUserByfirstName(String name);

    //void deleteByfirstName(String firstName);

     List<UserEntity> getAllUsers();

    UserDto getUserById(UUID id);

    ResponseEntity<String> saveUser(UserDto userRequest);

    /*UserDto addUser(UserDto userEntity);
*/
    //List<UserEntity> getAllUsers();
}
