package com.example.employeeserver.dao;

import com.example.employeeserver.domain.ProfileDomain;
import com.example.employeeserver.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,String> {
    @Query(value="select * from Profile where id=:id",nativeQuery=true)
    Profile getProfileById(String id);
    @Transactional
    @Modifying
    @Query(value="UPDATE Profile SET cellphone=:Cellphone, email=:Email, addressline1=:AddressLine1, addressline2=:AddressLine2, city=:City, state=:State, zipcode=:Zipcode, emergencycontactname1=:EmergencyContactName1, emergencycontactcellphone1=:EmergencyContactCellphone1, emergencycontactname2=:EmergencyContactName2, emergencycontactcellphone2=:EmergencyContactCellphone2 where id =:ID",nativeQuery=true)
    void updateProfile(
            String ID,
            String Cellphone,
            String Email,
            String AddressLine1,
            String AddressLine2,
            String City,
            String State,
            String Zipcode,
            String EmergencyContactName1,
            String EmergencyContactCellphone1,
            String EmergencyContactName2,
            String EmergencyContactCellphone2
                        );
}
