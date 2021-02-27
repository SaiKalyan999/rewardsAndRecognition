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
@Table(name = "Award")

public class Award extends Aggregate{

    @ManyToOne
    @JoinColumn(name = "award_type_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AwardType awardType;

    @ManyToOne
    @JoinColumn(name = "award_winner_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    @Column(name = "Date", nullable = false)
    private Date date;

    @Column(name = "Entity_id", nullable = false)
    private String entity_id;


    public Award(UUID id, String created_by, String modified_by, Date created_date, Date last_modified_date, Boolean soft_delete) {
        super(id, created_by, modified_by, created_date, last_modified_date, soft_delete);
    }
}


