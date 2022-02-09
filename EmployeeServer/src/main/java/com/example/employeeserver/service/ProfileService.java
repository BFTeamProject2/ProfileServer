package com.example.employeeserver.service;

import com.example.employeeserver.domain.ProfileDomain;
import com.example.employeeserver.entity.Profile;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {
    ProfileDomain getProfileDomainById(String id);
    Profile getProfileEntityById(String id);
    void updateProfile(ProfileDomain newProfileDomain, Profile profile);
}
