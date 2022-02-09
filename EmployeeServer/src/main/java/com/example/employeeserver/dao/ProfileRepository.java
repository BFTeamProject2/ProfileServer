package com.example.employeeserver.dao;

import com.example.employeeserver.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,String> {
    Profile getProfileById(String id);

}
