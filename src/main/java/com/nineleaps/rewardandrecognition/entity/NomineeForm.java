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
@Table(name = "NomineeForm")

public class NomineeForm extends Aggregate {


    @ManyToOne
    @JoinColumn(name = "award_type_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AwardType awardType;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "nominee_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntityNominee;



    @Column(name = "EntityID", nullable = false)
    private String entity_id;

    @Column(name = "Comments", nullable = false)
    private String comments;

    @Column(name = "Month", nullable = false)
    private String month;

    @Column(name = "Year", nullable = false)
    private String year;


    public NomineeForm(UUID id, String created_by, String modified_by, Date created_date, Date last_modified_date, Boolean soft_delete) {
        super(id, created_by, modified_by, created_date, last_modified_date, soft_delete);
    }
}
