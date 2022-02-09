package com.example.employeeserver.service;

import com.example.employeeserver.domain.ProfileDomain;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {
    ProfileDomain getProfileById(String id);
}
