package com.example.employeeserver.service.impl;

import com.example.employeeserver.dao.ProfileRepository;
import com.example.employeeserver.domain.ProfileDomain;
import com.example.employeeserver.entity.Profile;
import com.example.employeeserver.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Override
    public ProfileDomain getProfileById(String id) {
        Profile profile = profileRepository.getProfileById(id);
        return ProfileDomain.builder()
                .cellphone(profile.getCellphone())
                .AddressLine1(profile.getAddressLine1())
                .AddressLine2(profile.getAddressLine2())
                .city(profile.getCity())
                .email(profile.getEmail())
                .state(profile.getState())
                .zipcode(profile.getZipcode())
                .emergencyContactName1(profile.getEmergencyContactName1())
                .emergencyContactCellphone1(profile.getEmergencyContactCellphone1())
                .emergencyContactName2(profile.getEmergencyContactName2())
                .emergencyContactCellphone2(profile.getEmergencyContactCellphone2())
                .build();
    }
}
