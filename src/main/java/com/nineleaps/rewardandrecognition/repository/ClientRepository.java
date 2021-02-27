package com.nineleaps.rewardandrecognition.repository;

import com.nineleaps.rewardandrecognition.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,String> {

}
