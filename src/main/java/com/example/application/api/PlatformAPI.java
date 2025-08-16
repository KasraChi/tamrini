package com.example.application.api;


import com.example.application.DTO.PlatformUsageProjection;
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
public class PlatformAPI {

    @Autowired
    private PlatformService service;

    @GetMapping
    public Map<String, Object> getPlatformsData() {
        List<PlatformUsageProjection> platformList = service.getUsagePerPlatform();

        List<String> labels = platformList.stream()
                .map(PlatformUsageProjection::getName)  // ✔
                .toList();

        List<Integer> values = platformList.stream()
                .map(PlatformUsageProjection::getUsage)        // ✔
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("labels", labels);
        response.put("values", values);

        return response;
    }


}




