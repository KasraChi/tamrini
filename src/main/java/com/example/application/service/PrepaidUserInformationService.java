package com.example.application.service;

import com.example.application.repository.PrepaidUserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrepaidUserInformationService {

    @Autowired
    private PrepaidUserInformationRepository prepaidUserInformationRepository;


    public long getAllCounts(){
        return prepaidUserInformationRepository.count();
    }

}
