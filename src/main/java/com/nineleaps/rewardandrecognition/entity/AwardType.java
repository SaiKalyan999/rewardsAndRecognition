package com.nineleaps.rewardandrecognition.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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

        /*@Column(columnDefinition = "ENUM('Monthly', 'Yearly')", nullable = false)
        @Enumerated(EnumType.STRING)
        private AwardCategory awardcategory;
*/


}
