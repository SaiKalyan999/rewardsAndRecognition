package com.nineleaps.rewardandrecognition.repository;

import com.nineleaps.rewardandrecognition.entity.NomineeForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomineeFormRepository extends JpaRepository<NomineeForm, String> {
}
