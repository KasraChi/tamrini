package com.example.application.repository;

import com.example.application.DTO.PlatformUsageProjection;
import com.example.application.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {


    @Query("SELECT p.name as name, COUNT(p.name) as usage FROM Platform p GROUP BY p.name")
    List<PlatformUsageProjection> findPlatformUsageStats();


//
//    @Query("SELECT p.name, COUNT(p.name) " +
//            "FROM Platform p " +
//            "GROUP BY p.name")

//
//@Query("SELECT Platform.name, COUNT(Platform.name) FROM Platform GROUP BY Platform.name")


    // ا Native:
    // @Query(value = "SELECT platform_name AS platformName, COUNT(*) AS usage FROM activity GROUP BY platform_name", nativeQuery = true)
    // List<PlatformUsageProjection> findPlatformUsageStatsNative();
}

//        @Query("SELECT COUNT(u) FROM Platform u WHERE u.name = :platformName")
//        int countByPlatform(@Param("platformName") String platformName);
//
//


//    List<Platform> findByName(String name);

//    int countByName(String name);


