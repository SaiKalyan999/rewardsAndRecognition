package com.nineleaps.rewardandrecognition.entity;

//import jdk.nashorn.internal.objects.annotations.Getter;
//import jdk.nashorn.internal.objects.annotations.Setter;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

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


