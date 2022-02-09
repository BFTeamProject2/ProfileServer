package com.example.employeeserver.dao;

import com.example.employeeserver.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,String> {
    @Query(value="select * from Profile where id=:id",nativeQuery=true)
    List<Profile> getProfileById(String id);

}
