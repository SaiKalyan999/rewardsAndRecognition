package com.nineleaps.rewardandrecognition.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Client")
public class Client extends Aggregate {


    @OneToMany(mappedBy = "client")
    private List<Project> project;




    @Column(name = "ClientName", nullable = false)
    private String clientName;

    @Column(name = "ClientLocation", nullable = false)
    private String clientLocation;

    @Column(name = "StartedWorkingFrom", nullable = false)
    private Date startedWorkingFrom;

    @Column(name = "WorkedTill", nullable = true)
    private Date workedTill;



}