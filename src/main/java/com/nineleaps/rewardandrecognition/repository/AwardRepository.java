package com.nineleaps.rewardandrecognition.repository;

import com.nineleaps.rewardandrecognition.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends JpaRepository<Award,String> {
}
