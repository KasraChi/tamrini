package com.example.application.api;


import com.example.application.service.PrepaidUserInformationService;
import com.example.application.service.UserCourseInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/registeringStatus")
public class RegisteringStatusAPI {

//    @GetMapping("/api/chart/{classCode}")
//    public Map<String, Object> getChartData(@PathVariable String classCode) {
//        List<PlatformUsageProjection> platformList = service.getUsagePerClass(classCode);

    @Autowired
    private PrepaidUserInformationService prepaidService;

    @Autowired
    private UserCourseInformationService userService;


    public long NotRegisteredCounts() {
        return Math.abs(prepaidService.getAllCounts()) - userService.getAllCounts();
    }

    @GetMapping
    public Map<String, Object> getPlatformsData() {

//        List<PlatformUsageProjection> platformList = .getUsagePerPlatform();

        List<String> labels = List.of( "پیش ثبت نام" ,"ثبت نام","عدم ثبت نام") ;

        List<Long> values = List.of(prepaidService.getAllCounts(),userService.getAllCounts(), NotRegisteredCounts());
        Map<String, Object> response = new HashMap<>();
        response.put("labels", labels);
        response.put("values", values);

        return response;
    }

//    List<Integer> values = platformList.stream()
//            .map(PlatformUsageProjection::getUsage)        // ✔
//            .toList();
}

//
//    public long PrepaidCounts() {
//        return prepaidService.getAllCounts();
//    }
//
//    public long UserCounts() {
//        return userService.getAllCounts();
//    }






