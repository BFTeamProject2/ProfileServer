package com.example.employeeserver.controller;

import com.example.employeeserver.constant.JwtConstant;
import com.example.employeeserver.domain.ProfileDomain;
import com.example.employeeserver.security.util.CookieUtil;
import com.example.employeeserver.security.util.JwtUtil;
import com.example.employeeserver.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping("/profile")
    public ResponseEntity<ProfileDomain> getProfile(ServletRequest servletRequest) {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String token = CookieUtil.getValue(req, JwtConstant.JWT_COOKIE_NAME);
        String id = JwtUtil.getSubjectFromJwt(token);

        try {

            ProfileDomain profileDomain = profileService.getProfileById(id);
            return ResponseEntity.ok().body(profileDomain);
        } catch (Exception e) {
            System.out.println("error catch");
            return ResponseEntity.internalServerError().build();
        }


    }
    @GetMapping("/test/{id}")
    public ResponseEntity<ProfileDomain> test(@PathVariable String id) {
        ProfileDomain profileDomain = profileService.getProfileById(id);
        return ResponseEntity.ok().body(profileDomain);
    }
}
