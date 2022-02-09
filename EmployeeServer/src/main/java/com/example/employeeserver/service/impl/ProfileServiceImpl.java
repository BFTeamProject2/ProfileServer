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
    public ProfileDomain getProfileById(String id) {
        List<Profile> profile = profileRepository.getProfileById(id);
        return ProfileDomain.builder()
                .cellphone(profile.get(0).getCellphone())
//                .AddressLine1(profile.get(0).getAddressLine1())
//                .AddressLine2(profile.get(0).getAddressLine2())
//                .city(profile.get(0).getCity())
//                .email(profile.get(0).getEmail())
//                .state(profile.get(0).getState())
//                .zipcode(profile.get(0).getZipcode())
//                .emergencyContactName1(profile.get(0).getEmergencyContactName1())
//                .emergencyContactCellphone1(profile.get(0).getEmergencyContactCellphone1())
//                .emergencyContactName2(profile.get(0).getEmergencyContactName2())
//                .emergencyContactCellphone2(profile.get(0).getEmergencyContactCellphone2())
                .build();
    }
}
