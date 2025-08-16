package com.example.application.service;

import com.example.application.DTO.PlatformUsageProjection;
import com.example.application.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {

    @Autowired
    private PlatformRepository repository;

            public List<PlatformUsageProjection> getUsagePerPlatform() {
                return repository.findPlatformUsageStats();
            }


//        return repository.findAll();

    }




//    public int getAllTelegramUsages() {
//        return repository.countByName("T");
//    }


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


