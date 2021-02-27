package com.nineleaps.rewardandrecognition.repository;

import com.nineleaps.rewardandrecognition.entity.AwardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardTypeRepository extends JpaRepository<AwardType,String> {
}
