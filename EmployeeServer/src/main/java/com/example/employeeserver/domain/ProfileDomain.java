package com.example.employeeserver.domain;

//import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ProfileDomain {

    @JsonProperty
    private String cellphone;

    @JsonProperty
    private String email;
    @JsonProperty
    private String AddressLine1;
    @JsonProperty
    private String AddressLine2;
    @JsonProperty
    private String city;
    @JsonProperty
    private String state;
    @JsonProperty
    private String zipcode;
    @JsonProperty
    private String emergencyContactName1;
    @JsonProperty
    private String emergencyContactCellphone1;
    @JsonProperty
    private String emergencyContactName2;
    @JsonProperty
    private String emergencyContactCellphone2;
}
