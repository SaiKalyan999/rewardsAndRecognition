package com.nineleaps.rewardandrecognition.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Project")
public class Project extends Aggregate {

   @Getter(AccessLevel.NONE)
   @ManyToOne
    @JoinColumn(name = "client_id",insertable = false, updatable = false, referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;
    @Getter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "manager_id",insertable = false, updatable = false, referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    @ManyToMany(mappedBy = "projectSet")
    Set<UserEntity> userEntitySet;


    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<NomineeForm> nomineeForms;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<FothDate> fothDates;

    @Column(name = "projectName", nullable = false)
    private String projectName;

    @Column(name = "manager_id", nullable = false)
    private UUID managerId;

    @Column(name = "client_id", nullable =true)
    private UUID clientId;


}

