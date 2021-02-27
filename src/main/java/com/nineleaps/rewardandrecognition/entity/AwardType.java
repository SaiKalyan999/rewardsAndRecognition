package com.nineleaps.rewardandrecognition.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table(name = "AwardType")


public class AwardType extends Aggregate {

        @OneToMany(mappedBy = "awardType", cascade = CascadeType.ALL)
        private List<Award> awards;

        @OneToMany(mappedBy = "awardType", cascade = CascadeType.ALL)
        private List<FothDate> fothDates;

        @OneToMany(mappedBy = "awardType", cascade = CascadeType.ALL)
        private List<NomineeForm> nomineeForms;

        @Column(name = "Name", nullable = false)
        private String name;

        @Column(columnDefinition = "ENUM('Monthly', 'Yearly')", nullable = false)
        @Enumerated(EnumType.STRING)
        private AwardCategory awardcategory;


        public AwardType(UUID id, String created_by, String modified_by, Date created_date, Date last_modified_date, Boolean soft_delete) {
                super(id, created_by, modified_by, created_date, last_modified_date, soft_delete);
        }
}
