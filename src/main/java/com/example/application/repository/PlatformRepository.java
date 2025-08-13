package com.example.application.repository;

import com.example.application.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {
    List<Platform> findByName(String name);

    int countByName(String name);



}
