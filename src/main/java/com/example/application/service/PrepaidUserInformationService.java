package com.example.application.service;

import com.example.application.repository.PrepaidUserInformationRepository;
import org.springframework.stereotype.Service;

@Service
public class PrepaidUserInformationService {

    private PrepaidUserInformationRepository prepaidUserInformationRepository;


    private long getAllCounts(){
        return prepaidUserInformationRepository.count();
    }

}
