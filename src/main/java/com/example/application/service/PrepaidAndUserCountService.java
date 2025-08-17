package com.example.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrepaidAndUserCountService {

    @Autowired
    private PrepaidUserInformationService prepaidService;

    @Autowired
    private UserCourseInformationService userCourseService;



}
