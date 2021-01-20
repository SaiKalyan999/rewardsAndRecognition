package com.example.testnine.Dto;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.ResponseBody;


    @Entity
    @Table(name="entities")

    public class Enty{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(name= "Firstname", nullable ="False")
        private String firstname;

        @Column(name= "LastName" , nullable ="True")
        private String lastname;

        public String getFirstName(){
            return firstname;}

        public void setFirstName(String firstname){
            this.firstname = firstname;}

        public String getLastName(){
            return lastname;}
        public void setLastName(String lastname){
            this.lastname = lastname;}
        @Column(name= "Image", nullable ="True")
        private String firstname;
        @Column(name= "EmailAddress", nullable ="False")
        private String EmailAddress;
        @Column(name= "NineleapsID", nullable ="False")
        private String NineleapsID;
        @Column(name= "Designation", nullable ="False")
        private String Designation;
        @Column(name= "Phonenumber", nullable ="True")
        private String Phonenumber;
        @Column(name= "ModifiedBy", nullable ="False")
        private String ModifiedBy;
        @Column(name= "CreatedBy", nullable ="False")
        private String CreatedBy;
        @Column(name= "LastModifiedDate", nullable ="False")
        private String LastModifiedDate;
        @Column(name= "CreatedDate", nullable ="False")
        private String CreatedDate;



            }


