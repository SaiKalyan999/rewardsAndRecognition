package com.nineleaps.rewardandrecognition.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter

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
    private Date first_preference;

    @Column(name = "SecondPreference", nullable = false)
    private Date Second_preference;

    @Column(name = "ThirdPreference", nullable = false)
    private Date Third_preference;


    public FothDate(UUID id, String created_by, String modified_by, Date created_date, Date last_modified_date, Boolean soft_delete) {
        super(id, created_by, modified_by, created_date, last_modified_date, soft_delete);
    }
}
