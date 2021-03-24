package com.nineleaps.rewardandrecognition.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "FothDate")
@PrimaryKeyJoinColumn(name = "id")

public class FothDate extends Aggregate {


    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "award_type_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AwardType awardType;



    @Column(name = "Month", nullable = false)
    private String month;

    @Column(name = "Year", nullable = false)
    private String year;

    @Column(name = "FirstPreference", nullable = false)
    private Date firstPreference;

    @Column(name = "SecondPreference", nullable = false)
    private Date secondPreference;

    @Column(name = "ThirdPreference", nullable = false)
    private Date thirdPreference;



}
