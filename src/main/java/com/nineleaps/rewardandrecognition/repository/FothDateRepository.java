package com.nineleaps.rewardandrecognition.repository;

import com.nineleaps.rewardandrecognition.entity.FothDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FothDateRepository extends JpaRepository<FothDate, String> {
}

