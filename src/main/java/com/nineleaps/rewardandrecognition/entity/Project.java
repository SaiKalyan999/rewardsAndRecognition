package com.nineleaps.rewardandrecognition.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table(name = "Project")
public class Project extends Aggregate {


    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    @ManyToMany(mappedBy = "projectSet")
    Set<UserEntity> userEntitySet;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<NomineeForm> nomineeForms;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<FothDate> fothDates;


    @Column(name = "name", nullable = false)
    private String name;


    public Project(UUID id, String created_by, String modified_by, Date created_date, Date last_modified_date, Boolean soft_delete) {
        super(id, created_by, modified_by, created_date, last_modified_date, soft_delete);
    }
}

