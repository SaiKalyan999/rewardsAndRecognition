package com.nineleaps.rewardandrecognition.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Aggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "CreatedBy",nullable = false)
    private String created_by;

    @Column(name = "ModifiedBy",nullable = false)
    private String modified_by;

    @Column(name = "CreatedDate",nullable = false)
    private Date created_date;

    @Column(name = "LastModifiedDate",nullable = false)
    private Date last_modified_date;

    @Column(name = "SoftDelete",nullable = false)
    private Boolean soft_delete;


}
