package com.nineleaps.rewardandrecognition.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Firstname", nullable = false)
    private String firstName;

    @Column(name = "EmailAddress", nullable = false)
    private String emailAddress;

}


