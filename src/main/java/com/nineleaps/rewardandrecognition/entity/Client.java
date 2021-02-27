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
@Table(name = "Client")
public class Client extends Aggregate {


    @OneToMany(mappedBy = "client")
    private List<Project> project;


    @Column(name = "ClientName", nullable = false)
    private String client_name;

    @Column(name = "ClientLocation", nullable = false)
    private String client_location;

    @Column(name = "StartedWorkingFrom", nullable = false)
    private Date started_working_from;

    @Column(name = "WorkedTill", nullable = true)
    private Date worked_till;


    public Client(UUID id, String created_by, String modified_by, Date created_date, Date last_modified_date, Boolean soft_delete) {
        super(id, created_by, modified_by, created_date, last_modified_date, soft_delete);
    }
}