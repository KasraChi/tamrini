package com.example.application.repository;

import com.example.application.model.UserCourseInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCourseInformationRepository extends JpaRepository<UserCourseInformation, Long> {


//    @Query("select ")
//    List<String> findAllCourseKeys();

    long count();

}
