package com.example.application;

import com.example.application.model.Platform;
import com.example.application.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
    @RequestMapping("/api/platforms")
    public class API {

        @Autowired
        private PlatformService service;

        @GetMapping
        public Map<String, Object> getPlatformsData() {
            List<Platform> platformList = service.getAllPlatforms();

            List<String> labels = platformList.stream().map(Platform::getName).toList();
            List<Integer> values = platformList.stream().map(Platform::getUsage).toList();

            Map<String, Object> response = new HashMap<>();
            response.put("labels", labels);
            response.put("values", values);

            return response;
        }


    }




