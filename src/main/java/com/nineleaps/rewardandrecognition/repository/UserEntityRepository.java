package com.nineleaps.rewardandrecognition.repository;

import com.nineleaps.rewardandrecognition.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

}
