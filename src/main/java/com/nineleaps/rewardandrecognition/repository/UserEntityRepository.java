package com.nineleaps.rewardandrecognition.repository;

import com.nineleaps.rewardandrecognition.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,String> {


    UserEntity findByemailAddress(String email);

    UserEntity findByfirstName(String name);



    //UserEntity addUser(UserEntity userEntity);

    //public List<UserEntity> getAllUsers();

    //UserEntity deleteByfirstName(String firstName);


    List<UserEntity> findById(UUID id);

    @Query("select ue.firstName , ue.nlId  from UserEntity ue where ue.id =?1 ")
    Tuple findUserById(UUID id);




}


