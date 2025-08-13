package com.example.application.service;

import com.example.application.model.Platform;
import com.example.application.repository.PlatformRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatformService {


    @Autowired
    private PlatformRepository repository;


    public List<Platform> getAllPlatforms() {
        return repository.findAll();

}







//    @PostConstruct
//    public void init() {
//        repository.saveAll(platforms);
//    }
//
//

//    public List<Platform> platforms = new ArrayList<>(List.of(
//            new Platform(1, "telegram", 10),
//            new Platform(2, "igap", 38),
//            new Platform(3, "Bale", 10),
//            new Platform(4, "whatsapp", 21)));
//
//
////    public void allPlatforms() {
////        repository.saveAll(platforms);
////    }
//    public List<Platform>  getAllPlatforms() {
//        return repository.findAll();
//    }
//

}
