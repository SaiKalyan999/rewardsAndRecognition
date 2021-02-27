package com.nineleaps.rewardandrecognition.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table(name = "User")
public class UserEntity extends Aggregate {


    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<NomineeForm> nomineeForms;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<FothDate> fothDates;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<Award> awards;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<NomineeForm> nomineeFormList;


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "entity_project",
            joinColumns = @JoinColumn(name = "entity_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    Set<Project> projectSet;

    @Column(name = "Firstname", nullable = false)
    private String first_name;

    @Column(name = "EmailAddress", nullable = false)
    private String email_address;

    @Column(name = "Lastname", nullable = false)
    private String last_name;

    @Column(name = "NlId", nullable = false)
    private String nl_id;

    @Column(name = "Designation", nullable = false)
    private String designation;

    @Column(columnDefinition = "ENUM('HR', 'Developer', 'Founder','Manager')", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "PhoneNumber", nullable = false)
    private String phone_number;

    @Lob
    @Column(name = "Image", nullable = false)
    private Byte image;


    public UserEntity(UUID id, String created_by, String modified_by, Date created_date, Date last_modified_date, Boolean soft_delete) {
        super(id, created_by, modified_by, created_date, last_modified_date, soft_delete);
    }
}






