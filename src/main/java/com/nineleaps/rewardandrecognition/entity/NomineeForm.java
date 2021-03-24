package com.nineleaps.rewardandrecognition.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "NomineeForm")

public class NomineeForm extends Aggregate {

    @Getter(AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "award_type_id",insertable = false, updatable = false, referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AwardType awardType;

    @Getter(AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id",insertable = false, updatable = false, referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Project project;

    @Getter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "manager_id",insertable = false, updatable = false,referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    @Getter(AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nominee_id",insertable = false, updatable = false, referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntityNominee;




    @Column(name = "Comments")
    private String comments;

    @Column(name = "Month", nullable = false)
    private String month;

    @Column(name = "Year", nullable = false)
    private String year;

    @Column(name= "manager_id", nullable = false)
    private UUID managerId;

    @Column(name= "nominee_id")
    private UUID nomineeId;

    @Column(name= "award_type_id")
    private UUID awardTypeId;

    @Column(name= "project_id")
    private UUID projectId;

    @Column(name=" is_submitted")
    private Boolean isSubmitted;




}
