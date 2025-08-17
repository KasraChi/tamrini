package com.example.application.service;

import com.example.application.repository.UserCourseInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCourseInformationService {

    @Autowired
    private UserCourseInformationRepository userCourseInformationRepository;

    public long getAllCounts(){
        return userCourseInformationRepository.count();
    }


}
