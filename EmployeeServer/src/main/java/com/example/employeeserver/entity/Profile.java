package com.example.employeeserver.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profile {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "email")
    private String email;
    @Column(name = "addressLine1")
    private String AddressLine1;
    @Column(name = "addressLine2")
    private String AddressLine2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "emergencycontactname1")
    private String emergencyContactName1;
    @Column(name = "emergencycontactcellphone1")
    private String emergencyContactCellphone1;
    @Column(name = "emergencycontactname2")
    private String emergencyContactName2;
    @Column(name = "emergencycontactcellphone2")
    private String emergencyContactCellphone2;





}
