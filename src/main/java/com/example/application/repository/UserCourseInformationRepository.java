package com.example.application.repository;

import com.example.application.model.UserCourseInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseInformationRepository extends JpaRepository<UserCourseInformation, Long> {

    long count();

}
