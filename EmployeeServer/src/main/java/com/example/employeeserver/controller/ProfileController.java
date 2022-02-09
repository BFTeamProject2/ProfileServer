package com.example.employeeserver.controller;

import com.example.employeeserver.constant.JwtConstant;
import com.example.employeeserver.domain.ProfileDomain;
import com.example.employeeserver.security.util.CookieUtil;
import com.example.employeeserver.security.util.JwtUtil;
import com.example.employeeserver.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

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

            ProfileDomain profileDomain = profileService.getProfileDomainById(id);
            return ResponseEntity.ok().body(profileDomain);
        } catch (Exception e) {
            System.out.println("error catch");
            return ResponseEntity.internalServerError().build();
        }


    }

    @PutMapping("/profile")
    public ResponseEntity<Object> updateProfile(ServletRequest servletRequest,@RequestPart(value = "model") String model) {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String token = CookieUtil.getValue(req, JwtConstant.JWT_COOKIE_NAME);
        String id = JwtUtil.getSubjectFromJwt(token);

        ProfileDomain profileDomain = null;
        try{

            Gson g = new Gson();
            profileDomain = g.fromJson(model,ProfileDomain.class);

            System.out.println(profileService.getProfileDomainById(id));
            profileService.updateProfile(profileDomain,id);

            return  ResponseEntity.ok().body(profileService.getProfileDomainById(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/test/{id}")
    public ResponseEntity<ProfileDomain> test(@PathVariable String id) {
        ProfileDomain profileDomain = profileService.getProfileDomainById(id);
        return ResponseEntity.ok().body(profileDomain);
    }
   

}
