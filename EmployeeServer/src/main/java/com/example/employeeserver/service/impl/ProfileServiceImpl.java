package com.example.employeeserver.service.impl;

import com.example.employeeserver.dao.ProfileRepository;
import com.example.employeeserver.domain.ProfileDomain;
import com.example.employeeserver.entity.Profile;
import com.example.employeeserver.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Override
    public Profile getProfileEntityById(String id) {
        Profile profile = profileRepository.getProfileById(id);
        return profile;
    }
    @Override
    public ProfileDomain getProfileDomainById(String id) {
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
    public void updateProfile(ProfileDomain newProfileDomain, String id) {
//        Profile profile = profileRepository.getProfileById(id);
//        profile.setCellphone(newProfileDomain.getCellphone());
//        profile.setEmail(newProfileDomain.getEmail());
//        profile.setAddressLine1(newProfileDomain.getAddressLine1());
//        profile.setAddressLine2(newProfileDomain.getAddressLine2());
//        profile.setCity(newProfileDomain.getCity());
//        profile.setState(newProfileDomain.getState());
//        profile.setZipcode(newProfileDomain.getZipcode());
//        profile.setEmergencyContactCellphone1(newProfileDomain.getEmergencyContactCellphone1());
//        profile.setEmergencyContactName1(newProfileDomain.getEmergencyContactName1());
//        profile.setEmergencyContactName2(newProfileDomain.getEmergencyContactName2());
//        profile.setEmergencyContactCellphone2(newProfileDomain.getEmergencyContactCellphone2());
//        profileRepository.save(profile);

        profileRepository.updateProfile(id,
                newProfileDomain.getCellphone(),
                newProfileDomain.getEmail(),
                newProfileDomain.getAddressLine1(),
                newProfileDomain.getAddressLine2(),
                newProfileDomain.getCity(),
                newProfileDomain.getState(),
                newProfileDomain.getZipcode(),
                newProfileDomain.getEmergencyContactName1(),
                newProfileDomain.getEmergencyContactCellphone1(),
                newProfileDomain.getEmergencyContactName2(),
                newProfileDomain.getEmergencyContactCellphone2()
                );

    }
}
